// 
// 
// 

package service;

import Pojo.Zulist;
import Pojo.Paid;
import java.util.List;
import Pojo.QueryVo;

public interface PaidService
{
    List<Paid> selectall(QueryVo p0);
    
    Double selectsum(QueryVo p0);
    
    void deletepaid(Integer p0);
    
    List<Zulist> findzuuserlist() throws Exception;
    
    Zulist findzukezulist(Integer p0);
}
