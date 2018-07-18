package example.controller;

import example.service.RemoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liyinhao on 18/7/17.
 */
@RestController
public class HelloController {

    @Resource
    private RemoteService remoteService;


    @RequestMapping
    public String welcome() {
        return "welcome to dubbo client.";
    }


    @RequestMapping("/hi")
    public String hi() {
        return remoteService.sayHello();
    }


}
