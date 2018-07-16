package example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by liyinhao on 18/7/16.
 */

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class).run(args);
    }
}
