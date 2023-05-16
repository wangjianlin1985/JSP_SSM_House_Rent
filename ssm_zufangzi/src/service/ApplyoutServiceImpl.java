// 
// 
// 

package service;

import Pojo.Checkout;
import java.util.List;
import Pojo.Applyout;
import Pojo.Zulist;
import dao.ZulistMapper;
import dao.CheckoutMapper;
import dao.HetongMapper;
import dao.HouselistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import dao.ApplyoutMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ApplyoutServiceImpl implements ApplyoutService
{
    @Autowired
    private ApplyoutMapper applyoutMapper;
    @Autowired
    private HouselistMapper houselistMapper;
    @Autowired
    private HetongMapper hetongMapper;
    @Autowired
    private CheckoutMapper checkoutMapper;
    @Autowired
    private ZulistMapper zulistMapper;
    
    @Override
    public void insertapplyout(final Zulist zulist) {
        final Applyout applyout = new Applyout();
        applyout.setHouse_id(zulist.getHouse_id());
        applyout.setAddress(zulist.getAddress());
        applyout.setStatus("\u7533\u8bf7\u4e2d");
        applyout.setUserlist_id(zulist.getUserlist_id());
        this.applyoutMapper.insertapplyout(applyout);
    }
    
    @Override
    public List<Applyout> findallapplyout() {
        final List<Applyout> list = this.applyoutMapper.findallapplyout();
        return list;
    }
    
    @Override
    public void updateapplyout(final Applyout applyout) {
        this.applyoutMapper.updateapplyout(applyout);
    }
    
    @Override
    public void agreeapplyout(final Integer id) {
        final Applyout applyout = this.applyoutMapper.findbyid(id);
        this.houselistMapper.deletehousebyhouseid(applyout.getHouse_id());
        this.hetongMapper.deletehetong(applyout.getHouse_id());
        final Checkout checkout = new Checkout();
        checkout.setHouse_id(applyout.getHouse_id());
        checkout.setAddress(applyout.getAddress());
        checkout.setStatus("\u5df2\u9000\u79df");
        checkout.setUserlist_id(applyout.getUserlist_id());
        this.checkoutMapper.insertcheckout(checkout);
        applyout.setStatus("\u5df2\u540c\u610f");
        this.applyoutMapper.updateapplyoutbyhouse(applyout);
        this.zulistMapper.deletezulist(applyout.getHouse_id());
    }
    
    @Override
    public void deleteapplyout(final Integer id) {
        this.applyoutMapper.deleteapplyout(id);
    }
}
