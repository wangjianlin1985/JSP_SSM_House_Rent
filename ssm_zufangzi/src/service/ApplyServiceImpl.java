// 
// 
// 

package service;

import Pojo.Houselist;
import java.util.List;
import Pojo.Apply;
import dao.HouselistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import dao.ApplyMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ApplyServiceImpl implements ApplyService
{
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private HouselistMapper houselistMapper;
    
    @Override
    public void insertapply(final Apply apply) {
        this.applyMapper.insertapply(apply);
    }
    
    @Override
    public List<Apply> findapplylist() throws Exception {
        final List<Apply> apply = this.applyMapper.findapplylist();
        return apply;
    }
    
    @Override
    public Apply findbyhouse_id(final String house_id) {
        final Apply apply = this.applyMapper.findbyhouse_id(house_id);
        return apply;
    }
    
    @Override
    public void deletebyhouse_id(final String house_id) {
        this.applyMapper.deletebyhouse_id(house_id);
    }
    
    @Override
    public void refuseapply(final Houselist houselist) {
        this.houselistMapper.updatestatus(houselist);
        this.applyMapper.deletebyhouse_id(houselist.getHouseid());
    }
}
