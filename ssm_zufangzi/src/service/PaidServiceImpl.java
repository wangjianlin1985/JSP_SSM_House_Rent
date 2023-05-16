// 
// 
// 

package service;

import Pojo.Zulist;
import Pojo.Paid;
import java.util.List;
import Pojo.QueryVo;
import dao.ZulistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import dao.PaidMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaidServiceImpl implements PaidService
{
    @Autowired
    private PaidMapper paidMapper;
    @Autowired
    private ZulistMapper zulistMapper;
    
    @Override
    public List<Paid> selectall(final QueryVo vo) {
        final List<Paid> list = this.paidMapper.selectall(vo);
        return list;
    }
    
    @Override
    public Double selectsum(final QueryVo vo) {
        final Double sum = this.paidMapper.selectsum(vo);
        return sum;
    }
    
    @Override
    public void deletepaid(final Integer id) {
        this.paidMapper.deletepaid(id);
    }
    
    @Override
    public List<Zulist> findzuuserlist() throws Exception {
        final List<Zulist> list = this.zulistMapper.findzuuserlist();
        return list;
    }
    
    @Override
    public Zulist findzukezulist(final Integer id) {
        final Zulist zulist = this.zulistMapper.findzukezulist(id);
        return zulist;
    }
}
