// 
// 
// 

package dao;

import Pojo.Solve;
import java.util.List;
import Pojo.QueryVo;

public interface SolveMapper
{
    List<Solve> selectall(QueryVo p0);
    
    Integer selectcount(QueryVo p0);
    
    void deletesolve(Integer p0);
    
    void insertsolve(Solve p0);
}
