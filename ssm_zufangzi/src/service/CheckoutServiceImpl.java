// 
// 
// 

package service;

import java.util.List;
import Pojo.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import dao.CheckoutMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService
{
    @Autowired
    private CheckoutMapper checkoutMapper;
    
    @Override
    public void insertcheckout(final Checkout checkout) {
        this.checkoutMapper.insertcheckout(checkout);
    }
    
    @Override
    public List<Checkout> getallcheckout() {
        final List<Checkout> checkout = this.checkoutMapper.getallcheckout();
        return checkout;
    }
    
    @Override
    public void deletecheckout(final Integer id) {
        this.checkoutMapper.deletecheckout(id);
    }
}
