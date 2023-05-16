// 
// 
// 

package dao;

import Pojo.Applyout;
import java.util.List;
import Pojo.Apply;

public interface ApplyMapper
{
    void insertapply(Apply p0);
    
    List<Apply> findapplylist() throws Exception;
    
    Apply findbyhouse_id(String p0);
    
    void deletebyhouse_id(String p0);
    
    void updateapplyout(Applyout p0);
}
