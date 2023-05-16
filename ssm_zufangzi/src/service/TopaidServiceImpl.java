// 
// 
// 

package service;

import Pojo.Paid;
import java.util.List;
import Pojo.QueryVo;
import Pojo.Topaid;
import dao.PaidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import dao.TopaidMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TopaidServiceImpl implements TopaidService
{
    @Autowired
    private TopaidMapper topaidMapper;
    @Autowired
    private PaidMapper paidMapper;
    
    @Override
    public void inserttopaid(final Topaid topaid) {
        topaid.setStatus("\u79df\u91d1\u672a\u7f34");
        this.topaidMapper.inserttopaid(topaid);
    }
    
    @Override
    public List<Topaid> findtopaid(final QueryVo vo) {
        final List<Topaid> list = this.topaidMapper.findtopaid(vo);
        return list;
    }
    
    @Override
    public Topaid findbyid(final Integer id) {
        final Topaid topaid = this.topaidMapper.findbyid(id);
        return topaid;
    }
    
    @Override
    public void gotopay(final Integer id, final Paid paid) {
        this.paidMapper.insertpaid(paid);
        this.topaidMapper.deletetopaid(id);
    }
}
