// 
// 
// 

package dao;

import java.util.List;
import Pojo.Zulist;

public interface ZulistMapper
{
    void insertzulist(Zulist p0);
    
    List<Zulist> findzuuserlist() throws Exception;
    
    Zulist findzulist(String p0);
    
    void deletezulist(String p0);
    
    List<Zulist> findzulistbyuid(Integer p0);
    
    Zulist findzukezulist(Integer p0);
}
