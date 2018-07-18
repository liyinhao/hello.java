package example.service;

import com.alibaba.dubbo.config.annotation.Service;
import example.HelloService;
import org.springframework.stereotype.Component;

/**
 * Created by liyinhao on 18/6/11.
 */
@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}