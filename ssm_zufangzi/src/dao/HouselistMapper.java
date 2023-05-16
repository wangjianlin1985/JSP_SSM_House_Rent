// 
// 
// 

package dao;

import Pojo.QueryVo;
import Pojo.Houselist;
import java.util.List;

public interface HouselistMapper
{
    List<Houselist> selectAll();
    
    Integer findhouselistByVoCount(QueryVo p0);
    
    Houselist findhouseid(String p0);
    
    void inserthouse(Houselist p0);
    
    void deletehouse(int p0);
    
    Houselist findid(int p0);
    
    Houselist findhouseidupdate(Houselist p0);
    
    void updatehouse(Houselist p0);
    
    void updatehousestatus(Houselist p0);
    
    void deletehousebyhouseid(String p0);
    
    void updatestatus(Houselist p0);
}
