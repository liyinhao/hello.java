package example;

import com.dianping.cat.Cat;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception {


        Cat.logEvent("Hello", "world");
        Cat.logEvent("Hello", "中文");

        System.in.read();
    }
}
