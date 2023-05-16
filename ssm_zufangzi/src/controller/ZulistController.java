// 
// 
// 

package controller;

import Pojo.Userlist;
import Pojo.User;
import javax.servlet.http.HttpSession;
import Pojo.Zulist;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import Pojo.Hetong;
import org.springframework.ui.Model;
import service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import service.ZulistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/zulist" })
public class ZulistController
{
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private UserlistService userlistService;
    
    @RequestMapping({ "/toaddhetong" })
    public String toaddhetong(final Model model, final String house_id) {
        final Hetong hetong = new Hetong();
        hetong.setHouse_id(house_id);
        model.addAttribute("hetong", (Object)hetong);
        model.addAttribute("mainPage", (Object)"addhetong.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/findzulist" })
    public String findzulist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) throws Exception {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Zulist> zulist = this.zulistService.findzuuserlist();
        final PageInfo<Zulist> p = (PageInfo<Zulist>)new PageInfo((List)zulist);
        model.addAttribute("p", (Object)p);
        model.addAttribute("zulist", (Object)zulist);
        model.addAttribute("mainPage", (Object)"zulist.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/myzulist" })
    public String myzulist(final Model model, final HttpSession httpSession, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) throws Exception {
        final User user1 = (User)httpSession.getAttribute("user");
        if (user1 == null) {
            return "login";
        }
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        if (userlist == null) {
            model.addAttribute("userlistzu", (Object)null);
        }
        else {
            PageHelper.startPage((int)page, (int)pageSize);
            final List<Userlist> list = this.userlistService.getUserzuList(userlist.getId());
            final PageInfo<Userlist> p = (PageInfo<Userlist>)new PageInfo((List)list);
            model.addAttribute("userlistzu", (Object)list);
            model.addAttribute("p", (Object)p);
        }
        model.addAttribute("mainPage", (Object)"myzulist.jsp");
        return "zuke/main";
    }
}
