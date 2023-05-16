// 
// 
// 

package dao;

import Pojo.Wrong;
import java.util.List;
import Pojo.QueryVo;

public interface WrongMapper
{
    List<Wrong> findwrong(QueryVo p0);
    
    Wrong findbyid(Integer p0);
    
    void insertwrong(Wrong p0);
    
    void deletewrong(Integer p0);
}
