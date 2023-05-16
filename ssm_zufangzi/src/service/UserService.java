// 
// 
// 

package service;

import Pojo.User;
import java.util.List;

public interface UserService
{
    List<User> userList() throws Exception;
    
    User login(User p0) throws Exception;
    
    int register(User p0) throws Exception;
}
