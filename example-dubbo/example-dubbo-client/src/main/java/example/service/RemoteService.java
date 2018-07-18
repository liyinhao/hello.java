package example.service;

import com.alibaba.dubbo.config.annotation.Reference;
import example.HelloService;
import org.springframework.stereotype.Component;

/**
 * Created by liyinhao on 18/7/17.
 */
@Component
public class RemoteService {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private HelloService helloService;



    public String sayHello(){
        return helloService.sayHello("dubbo");
    }
}
