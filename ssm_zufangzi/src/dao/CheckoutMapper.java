// 
// 
// 

package dao;

import java.util.List;
import Pojo.Checkout;

public interface CheckoutMapper
{
    void insertcheckout(Checkout p0);
    
    List<Checkout> getallcheckout();
    
    void deletecheckout(Integer p0);
}
