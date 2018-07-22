package example;


import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import java.lang.management.ManagementFactory;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by liyinhao on 18/7/20.
 */
public class JMXQuery {

    private MBeanServer mbs;

    public JMXQuery() {

        try {
            mbs = ManagementFactory.getPlatformMBeanServer();
        } catch (Throwable e) {
            // TODO Logger
        }
    }

    public List<Map<String, Object>> query(String category, String typeName, String[] attributes) {
        return query(category, null, typeName, attributes);
    }

    public List<Map<String, Object>> query(String category, String objNamePattern, String typeName, String[] attributes) {

        List<Map<String, Object>> rtn = new ArrayList<Map<String, Object>>();
        final ObjectName pool;
        try {
            pool = new ObjectName(category + ":type=" + typeName + ",*");
        } catch (Throwable e) {
            //TODO Logger
            return null;
        }
        final Set<ObjectName> names = mbs.queryNames(pool, null);
        if (names == null) {
            return null;
        }

        for (ObjectName name : names) {
            if (objNamePattern != null && !Pattern.matches(objNamePattern, name.getCanonicalName())) {
                continue;
            }
            Map<String, Object> attrs = new HashMap<String, Object>();
            try {
                AttributeList list = mbs.getAttributes(name, attributes);
                for (Attribute a : list.asList()) {
                    Object attrVal = a.getValue();
                    if (attrVal instanceof CompositeDataSupport) {
                        CompositeDataSupport dataSupport = (CompositeDataSupport) attrVal;
                        attrs.put(a.getName(), dataSupport.values());

                    } else {
                        attrs.put(a.getName(), attrVal);
                    }
                }
                rtn.add(attrs);
            } catch (Throwable e) {
                // TODO Logger
                continue;
            }
        }

        return rtn;

    }
}
