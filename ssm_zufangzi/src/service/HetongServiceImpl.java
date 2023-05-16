// 
// 
// 

package service;

import Pojo.Hetong;
import org.springframework.beans.factory.annotation.Autowired;
import dao.HetongMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HetongServiceImpl implements HetongService
{
    @Autowired
    private HetongMapper hetongMapper;
    
    @Override
    public void inserthetong(final Hetong hetong) {
        this.hetongMapper.inserthetong(hetong);
    }
    
    @Override
    public Hetong findhetong(final String house_id) {
        final Hetong hetong = this.hetongMapper.findhetong(house_id);
        return hetong;
    }
    
    @Override
    public void updatehetong(final Hetong hetong) {
        this.hetongMapper.updatehetong(hetong);
    }
    
    @Override
    public void deletehetong(final String house_id) {
        this.hetongMapper.deletehetong(house_id);
    }
}
