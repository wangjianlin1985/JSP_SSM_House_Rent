// 
// 
// 

package controller;

import Pojo.Userlist;
import Pojo.User;
import javax.servlet.http.HttpSession;
import Pojo.Applyout;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import Pojo.Zulist;
import org.springframework.ui.Model;
import service.UserlistService;
import service.ApplyoutService;
import org.springframework.beans.factory.annotation.Autowired;
import service.ZulistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/applyout" })
public class ApplyoutController
{
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private ApplyoutService applyoutService;
    @Autowired
    private UserlistService userlistService;
    
    @RequestMapping({ "/insertapplyout" })
    public String insertapplyout(final String house_id, final Model model) {
        final Zulist zulist = this.zulistService.findzulist(house_id);
        this.applyoutService.insertapplyout(zulist);
        model.addAttribute("error", (Object)"applysuccess");
        return "redirect:/zulist/myzulist.action";
    }
    
    @RequestMapping({ "/findallapplyout" })
    public String findallapplyout(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Applyout> applyout = this.applyoutService.findallapplyout();
        final PageInfo<Applyout> p = (PageInfo<Applyout>)new PageInfo((List)applyout);
        model.addAttribute("applyout", (Object)applyout);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"applyout.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/refuseapplyout" })
    public String refuseapplyout(final Model model, final Integer id) {
        final Applyout applyout = new Applyout();
        applyout.setId(id);
        applyout.setStatus("\u5df2\u62d2\u7edd");
        this.applyoutService.updateapplyout(applyout);
        model.addAttribute("mainPage", (Object)"applyout.jsp");
        return "redirect:findallapplyout.action";
    }
    
    @RequestMapping({ "/agreeapplyout" })
    public String agreeapplyout(final Model model, final Integer id) {
        this.applyoutService.agreeapplyout(id);
        model.addAttribute("error", (Object)"applyoutsucess");
        return "redirect:findallapplyout.action";
    }
    
    @RequestMapping({ "/deleteapplyout" })
    public String deleteapplyout(final Model model, final Integer id) {
        this.applyoutService.deleteapplyout(id);
        model.addAttribute("error", (Object)"deletesucess");
        return "redirect:findallapplyout.action";
    }
    
    @RequestMapping({ "/getmyapplyout" })
    public String getmyapplyout(final Model model, final HttpSession httpSession, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        if (user1 == null) {
            return "login";
        }
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        PageHelper.startPage((int)page, (int)pageSize);
        if (userlist != null) {
            final List<Userlist> list = this.userlistService.getmyapplyout(userlist.getId());
            final PageInfo<Userlist> p = (PageInfo<Userlist>)new PageInfo((List)list);
            model.addAttribute("userlist", (Object)list);
            model.addAttribute("p", (Object)p);
            model.addAttribute("mainPage", (Object)"myapplyout.jsp");
        }
        else {
            model.addAttribute("userlist", (Object)null);
            model.addAttribute("mainPage", (Object)"myapplyout.jsp");
        }
        return "zuke/main";
    }
}
