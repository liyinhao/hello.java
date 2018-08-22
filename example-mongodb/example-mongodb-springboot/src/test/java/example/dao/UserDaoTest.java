package example.dao;

import com.dianping.cat.Cat;
import example.meta.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Set;

/**
 * Created by liyinhao on 18/8/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() throws Exception{
        testSaveUser();
        findUserByUserName();

        Cat.logEvent("test", "begin");

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName pool = new ObjectName("org.mongodb.driver:type=ConnectionPool" + ",*");

        Set<ObjectName> set = mbs.queryNames(pool, null);
        for (ObjectName objectName : set) {
            System.out.println(objectName.getDomain());
            System.out.println(objectName.toString());
        }

        System.in.read();
    }

    private void testSaveUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userDao.saveUser(user);
    }


    private void findUserByUserName() {
        UserEntity user = userDao.findUserByUserName("小明");
        System.out.println("user is " + user.getPassWord());
    }

    @Test
    public void updateUser() {
        UserEntity user = new UserEntity();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1l);
    }

}
