// 
// 
// 

package dao;

import java.util.List;
import Pojo.QueryVo;
import Pojo.Topaid;

public interface TopaidMapper
{
    void inserttopaid(Topaid p0);
    
    List<Topaid> findtopaid(QueryVo p0);
    
    Topaid findbyid(Integer p0);
    
    void deletetopaid(Integer p0);
}
