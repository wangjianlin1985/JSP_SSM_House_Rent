// 
// 
// 

package service;

import Pojo.Wrong;
import Pojo.Solve;
import java.util.List;
import Pojo.QueryVo;

public interface SolveService
{
    List<Solve> selectall(QueryVo p0);
    
    Integer selectcount(QueryVo p0);
    
    void deletesolve(Integer p0);
    
    List<Wrong> findwrong(QueryVo p0);
    
    Wrong findbyid(Integer p0);
    
    void insertwrong(Wrong p0);
    
    void gotosolve(Integer p0, Solve p1);
}
