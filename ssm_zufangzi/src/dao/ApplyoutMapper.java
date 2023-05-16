// 
// 
// 

package dao;

import java.util.List;
import Pojo.Applyout;

public interface ApplyoutMapper
{
    void insertapplyout(Applyout p0);
    
    List<Applyout> findallapplyout();
    
    void updateapplyout(Applyout p0);
    
    void updateapplyoutbyhouse(Applyout p0);
    
    Applyout findbyid(Integer p0);
    
    void deleteapplyout(Integer p0);
}
