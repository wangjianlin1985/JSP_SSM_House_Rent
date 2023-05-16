// 
// 
// 

package dao;

import Pojo.Paid;
import java.util.List;
import Pojo.QueryVo;

public interface PaidMapper
{
    List<Paid> selectall(QueryVo p0);
    
    Double selectsum(QueryVo p0);
    
    void deletepaid(Integer p0);
    
    void insertpaid(Paid p0);
}
