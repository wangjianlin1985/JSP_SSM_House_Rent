// 
// 
// 

package service;

import java.util.Iterator;
import java.util.List;
import Pojo.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import dao.UserlistMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserlistServiceImpl implements UserlistService
{
    @Autowired
    private UserlistMapper userlistMapper;
    
    @Override
    public Userlist findhasuserlist(final Integer user_id) {
        final Userlist userlist = this.userlistMapper.findhasuserlist(user_id);
        return userlist;
    }
    
    @Override
    public Userlist checkuserlist(final String idcard) {
        final Userlist userlist = this.userlistMapper.checkuserlist(idcard);
        return userlist;
    }
    
    @Override
    public void insertuserlist(final Userlist userlist) {
        this.userlistMapper.insertuserlist(userlist);
    }
    
    @Override
    public void updateuserlist(final Userlist userlist) {
        this.userlistMapper.updateuserlist(userlist);
    }
    
    @Override
    public Userlist finduserlistupdate(final Userlist userlist) {
        final Userlist list = this.userlistMapper.finduserlistupdate(userlist);
        return list;
    }
    
    @Override
    public List<Userlist> getUserzuList(final Integer id) {
        final List<Userlist> userlist = this.userlistMapper.getUserzuList(id);
        for (final Userlist list : userlist) {
            System.out.println(list);
        }
        return userlist;
    }
    
    @Override
    public List<Userlist> getmycheckout(final Integer id) {
        final List<Userlist> list = this.userlistMapper.getmycheckout(id);
        return list;
    }
    
    @Override
    public List<Userlist> getmyapply(final Integer id) {
        final List<Userlist> list = this.userlistMapper.getmyapply(id);
        return list;
    }
    
    @Override
    public List<Userlist> getmyapplyout(final Integer id) {
        final List<Userlist> list = this.userlistMapper.getmyapplyout(id);
        return list;
    }
    
    @Override
    public List<Userlist> findalluserlist() {
        final List<Userlist> list = this.userlistMapper.findalluserlist();
        return list;
    }
    
    @Override
    public void deleteuserlist(final Integer id) {
        this.userlistMapper.deleteuserlist(id);
        this.userlistMapper.deleteuser(id);
    }
}
