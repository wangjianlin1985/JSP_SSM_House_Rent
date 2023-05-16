// 
// 
// 

package dao;

import java.util.List;
import Pojo.Userlist;

public interface UserlistMapper
{
    Userlist findhasuserlist(Integer p0);
    
    Userlist checkuserlist(String p0);
    
    void insertuserlist(Userlist p0);
    
    void updateuserlist(Userlist p0);
    
    Userlist finduserlistupdate(Userlist p0);
    
    List<Userlist> getUserzuList(Integer p0);
    
    List<Userlist> getmycheckout(Integer p0);
    
    List<Userlist> getmyapply(Integer p0);
    
    List<Userlist> getmyapplyout(Integer p0);
    
    List<Userlist> findalluserlist();
    
    void deleteuser(Integer p0);
    
    void deleteuserlist(Integer p0);
}
