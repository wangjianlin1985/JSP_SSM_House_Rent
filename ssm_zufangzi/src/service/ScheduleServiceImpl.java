// 
// 
// 

package service;

import java.util.List;
import Pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import dao.ScheduleMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService
{
    @Autowired
    private ScheduleMapper scheduleMapper;
    
    @Override
    public void insertschedule(final Schedule schedule) {
        this.scheduleMapper.insertschedule(schedule);
    }
    
    @Override
    public List<Schedule> selectAll() {
        final List<Schedule> list = this.scheduleMapper.selectAll();
        return list;
    }
    
    @Override
    public void deleteschedule(final Integer id) {
        this.scheduleMapper.deleteschedule(id);
    }
    
    @Override
    public void updateschedule(final Schedule schedule) {
        this.scheduleMapper.updateschedule(schedule);
    }
    
    @Override
    public Schedule selectbyid(final Integer id) {
        final Schedule schedule = this.scheduleMapper.selectbyid(id);
        return schedule;
    }
}
