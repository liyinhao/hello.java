package example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liyinhao on 18/7/10.
 */
@Configuration
@MapperScan("example.mapper")
public class DaoConfig {

}
