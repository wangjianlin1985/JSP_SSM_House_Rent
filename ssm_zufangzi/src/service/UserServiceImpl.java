// 
// 
// 

package service;

import Pojo.UserExample;
import Pojo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public List<User> userList() throws Exception {
        final UserExample example = new UserExample();
        final List<User> list = this.userMapper.selectByExample(example);
        System.out.println("123" + list);
        return list;
    }
    
    @Override
    public User login(final User user) throws Exception {
        final User user2 = this.userMapper.selectByUser(user);
        return user2;
    }
    
    @Override
    public int register(final User user) throws Exception {
        final int num = this.userMapper.insert(user);
        return num;
    }
}
