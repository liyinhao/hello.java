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


    @RequestMapping("/jmx")
    public List<Map<String, Object>> jmx(){
        JMXQuery jmxQuery = new JMXQuery();


        String[] atts = {"Name", "Url", "PoolingCount", "PoolingPeak", "ActiveCount", "ActivePeak"};
        List<Map<String, Object>> res = jmxQuery.query("com.alibaba.druid", "DruidDataSource", atts);


        return res;
    }
}
