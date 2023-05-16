// 
// 
// 

package service;

import Pojo.Paid;
import java.util.List;
import Pojo.QueryVo;
import Pojo.Topaid;

public interface TopaidService
{
    void inserttopaid(Topaid p0);
    
    List<Topaid> findtopaid(QueryVo p0);
    
    Topaid findbyid(Integer p0);
    
    void gotopay(Integer p0, Paid p1);
}
