// 
// 
// 

package service;

import java.util.List;
import Pojo.Schedule;

public interface ScheduleService
{
    void insertschedule(Schedule p0);
    
    List<Schedule> selectAll();
    
    void deleteschedule(Integer p0);
    
    void updateschedule(Schedule p0);
    
    Schedule selectbyid(Integer p0);
}
