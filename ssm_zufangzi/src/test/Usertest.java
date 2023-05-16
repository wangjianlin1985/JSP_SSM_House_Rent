// 
// 
// 

package test;

import java.util.List;
import Pojo.UserExample;
import org.junit.Test;
import Pojo.User;
import dao.UserMapper;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Usertest
{
    private ApplicationContext applicatonContext;
    
    @Before
    public void setUp() throws Exception {
        final String configLocation = "classpath:ApplicationContext-dao.xml";
        this.applicatonContext = (ApplicationContext)new ClassPathXmlApplicationContext(configLocation);
    }
    
    @Test
    public void testFindUserById() throws Exception {
        final UserMapper userMapper = (UserMapper)this.applicatonContext.getBean("userMapper");
        final User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
    
    @Test
    public void testFindUserAndSex() throws Exception {
        final UserMapper userMapper = (UserMapper)this.applicatonContext.getBean("userMapper");
        final UserExample userExample = new UserExample();
        final UserExample.Criteria createCriteria = userExample.createCriteria();
        createCriteria.andUsernameLike("%z%");
        final List<User> list = userMapper.selectByExample(userExample);
        System.out.println(list);
    }
}
