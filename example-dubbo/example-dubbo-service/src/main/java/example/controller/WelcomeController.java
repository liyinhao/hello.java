package example.controller;

import example.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liyinhao on 18/7/17.
 */
@RestController
public class WelcomeController {

    @Resource
    private HelloService helloService;

    @RequestMapping
    public String welcome(){
        return "welcome to dubbo service";
    }


    @RequestMapping("/hi")
    public String sayHi(){
        return helloService.sayHello("spring");
    }

}
