// 
// 
// 

package service;

import java.util.List;
import Pojo.Zulist;
import org.springframework.beans.factory.annotation.Autowired;
import dao.ZulistMapper;
import org.springframework.stereotype.Service;

@Service
public class ZulistServiceImpl implements ZulistService
{
    @Autowired
    private ZulistMapper zulistMapper;
    
    @Override
    public void insertzulist(final Zulist zulist) {
        this.zulistMapper.insertzulist(zulist);
    }
    
    @Override
    public List<Zulist> findzuuserlist() throws Exception {
        final List<Zulist> zulist = this.zulistMapper.findzuuserlist();
        return zulist;
    }
    
    @Override
    public Zulist findzulist(final String house_id) {
        final Zulist zulist = this.zulistMapper.findzulist(house_id);
        return zulist;
    }
    
    @Override
    public void deletezulist(final String house_id) {
        this.zulistMapper.deletezulist(house_id);
    }
    
    @Override
    public List<Zulist> findzulistbyuid(final Integer userlist_id) {
        final List<Zulist> zulist = this.zulistMapper.findzulistbyuid(userlist_id);
        return zulist;
    }
}
