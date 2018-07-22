package example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by liyinhao on 18/7/10.
 */
@SpringBootApplication
public class ExampleDruidComplexApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ExampleDruidComplexApplication.class).run(args);
    }
}
