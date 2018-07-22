package example.controller;

import example.JMXQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by liyinhao on 18/7/22.
 */
@RestController
public class HelloController {


    @RequestMapping
    public String hello() {
        return "hello druid simple.";
    }


    @RequestMapping("/jmxd")
    public List<Map<String, Object>> jmxd() {
        JMXQuery jmxQuery = new JMXQuery();


        String[] atts = {"Name", "Url", "PoolingCount", "PoolingPeak", "ActiveCount", "ActivePeak"};
        List<Map<String, Object>> res = jmxQuery.queryList("com.alibaba.druid", "DruidDataSource", atts);


        return res;
    }

    @RequestMapping("/jmxr")
    public Map<String, Map<String, Object>> jmxr() {
        JMXQuery jmxQuery = new JMXQuery();


        String[] atts = {"NumActive", "NumIdle", "FactoryType"};
        Map<String, Map<String, Object>> res = jmxQuery.queryMap("org.apache.commons.pool2", "GenericObjectPool", atts);


        return res;
    }
}
