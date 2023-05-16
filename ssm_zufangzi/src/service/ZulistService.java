// 
// 
// 

package service;

import java.util.List;
import Pojo.Zulist;

public interface ZulistService
{
    void insertzulist(Zulist p0);
    
    List<Zulist> findzuuserlist() throws Exception;
    
    Zulist findzulist(String p0);
    
    void deletezulist(String p0);
    
    List<Zulist> findzulistbyuid(Integer p0);
}
