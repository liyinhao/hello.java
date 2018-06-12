package example;

/**
 * Created by liyinhao on 18/6/11.
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}