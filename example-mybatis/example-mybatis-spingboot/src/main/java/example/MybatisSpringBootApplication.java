package example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by liyinhao on 18/7/10.
 */
@SpringBootApplication
public class MybatisSpringBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MybatisSpringBootApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MybatisSpringBootApplication.class).run(args);
    }

}
