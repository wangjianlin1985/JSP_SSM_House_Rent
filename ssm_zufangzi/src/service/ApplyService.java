// 
// 
// 

package service;

import Pojo.Houselist;
import java.util.List;
import Pojo.Apply;

public interface ApplyService
{
    void insertapply(Apply p0);
    
    List<Apply> findapplylist() throws Exception;
    
    Apply findbyhouse_id(String p0);
    
    void deletebyhouse_id(String p0);
    
    void refuseapply(Houselist p0);
}
