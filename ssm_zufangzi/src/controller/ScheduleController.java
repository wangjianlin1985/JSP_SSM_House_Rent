// 
// 
// 

package controller;

import Pojo.Schedule;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/schedule" })
public class ScheduleController
{
    @Autowired
    private ScheduleService scheduleService;
    
    @RequestMapping({ "/selectAll" })
    public String selectAll(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Schedule> schedule = this.scheduleService.selectAll();
        final PageInfo<Schedule> p = (PageInfo<Schedule>)new PageInfo((List)schedule);
        model.addAttribute("schedule", (Object)schedule);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"schedule.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/deleteschedule" })
    public String deleteschedule(final Integer id) {
        this.scheduleService.deleteschedule(id);
        return "redirect:selectAll.action";
    }
    
    @RequestMapping({ "/insertschedule" })
    public String insertschedule(final Schedule schedule, final Model model) {
        this.scheduleService.insertschedule(schedule);
        return "redirect:selectAll.action";
    }
    
    @RequestMapping({ "/updateschedule" })
    public String updateschedule(final Schedule schedule, final Model model) {
        this.scheduleService.updateschedule(schedule);
        model.addAttribute("error", (Object)"\u66f4\u65b0\u6210\u529f");
        model.addAttribute("schedule", (Object)schedule);
        model.addAttribute("mainPage", (Object)"updateschedule.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/toinsert" })
    public String toinsert(final Model model) {
        model.addAttribute("mainPage", (Object)"addschedule.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/toupdate" })
    public String toupdate(final Model model, final Integer id) {
        final Schedule schedule = this.scheduleService.selectbyid(id);
        model.addAttribute("schedule", (Object)schedule);
        model.addAttribute("mainPage", (Object)"updateschedule.jsp");
        return "admin/main1";
    }
}
