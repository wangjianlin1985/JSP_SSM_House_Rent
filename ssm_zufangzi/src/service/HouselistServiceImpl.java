// 
// 
// 

package service;

import Pojo.Houselist;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.HouselistMapper;
import org.springframework.stereotype.Service;

@Service
public class HouselistServiceImpl implements HouselistService
{
    @Autowired
    private HouselistMapper houselistMapper;
    
    @Override
    public List<Houselist> selectAll() {
        final List<Houselist> houselist = this.houselistMapper.selectAll();
        return houselist;
    }
    
    @Override
    public Houselist findhouseid(final String houseid) {
        final Houselist houselist = this.houselistMapper.findhouseid(houseid);
        return houselist;
    }
    
    @Override
    public void inserthouse(final Houselist houselist) {
        this.houselistMapper.inserthouse(houselist);
    }
    
    @Override
    public void deletehouse(final int id) {
        this.houselistMapper.deletehouse(id);
    }
    
    @Override
    public Houselist findhouseidupdate(final Houselist houselist) {
        final Houselist list = this.houselistMapper.findhouseidupdate(houselist);
        return list;
    }
    
    @Override
    public void updatehouse(final Houselist houselist) {
        this.houselistMapper.updatehouse(houselist);
    }
    
    @Override
    public Houselist findid(final int id) {
        final Houselist list = this.houselistMapper.findid(id);
        return list;
    }
    
    @Override
    public void updatehousestatus(final Houselist houselist) {
        this.houselistMapper.updatehousestatus(houselist);
    }
    
    @Override
    public void deletehousebyhouseid(final String house_id) {
        this.houselistMapper.deletehousebyhouseid(house_id);
    }
}
