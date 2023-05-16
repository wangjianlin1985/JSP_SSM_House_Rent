// 
// 
// 

package service;

import Pojo.Applyout;
import java.util.List;
import Pojo.Zulist;

public interface ApplyoutService
{
    void insertapplyout(Zulist p0);
    
    List<Applyout> findallapplyout();
    
    void updateapplyout(Applyout p0);
    
    void agreeapplyout(Integer p0);
    
    void deleteapplyout(Integer p0);
}
