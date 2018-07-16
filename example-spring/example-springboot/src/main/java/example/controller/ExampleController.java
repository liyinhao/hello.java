package example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyinhao on 18/7/16.
 */

@RestController
public class ExampleController {

    @RequestMapping
    public String welcome(){
        return "hello world.";
    }

    @RequestMapping("/test")
    public String test(){
        return "hello springboot.";
    }


}
