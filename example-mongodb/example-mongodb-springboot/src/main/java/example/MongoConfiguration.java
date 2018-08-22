package example;

import com.mongodb.MongoClientOptions;
import com.mongodb.management.JMXConnectionPoolListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liyinhao on 18/8/22.
 */
@Configuration
public class MongoConfiguration {

    @Bean
    public MongoClientOptions mongoClientOptions() {
        return MongoClientOptions.builder()
                .alwaysUseMBeans(true)
                .addConnectionPoolListener(new JMXConnectionPoolListener()).build();
    }

}
