package example;

import com.alibaba.dubbo.common.utils.StringUtils;
import example.service.RemoteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboClientApplication.class)
public class HelloServiceTest {

    @Resource
    private RemoteService remoteService;

    @Test
    public void test(){

        String result = remoteService.sayHello();

        Assert.assertTrue(StringUtils.isEquals(result, "hello dubbo"));
    }
}
