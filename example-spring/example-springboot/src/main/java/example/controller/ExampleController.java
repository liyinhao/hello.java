package example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyinhao on 18/7/16.
 */

@RestController
public class ExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @RequestMapping
    public String welcome() {
        logger.info("hello world.");
        return "hello world.";
    }

    @RequestMapping("/test")
    public String test() {
        logger.info("hello springboot.");

        return "hello springboot.";
    }


}
