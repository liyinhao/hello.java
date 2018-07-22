package example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by liyinhao on 18/7/10.
 */
@SpringBootApplication
public class SimpleDruidSpringBootApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(SimpleDruidSpringBootApplication.class).run(args);
    }
}
