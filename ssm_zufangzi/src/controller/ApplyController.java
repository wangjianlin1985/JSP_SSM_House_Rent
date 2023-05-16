// 
// 
// 

package controller;

import Pojo.Zulist;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import Pojo.Houselist;
import Pojo.Userlist;
import Pojo.Apply;
import Pojo.User;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import service.ApplyService;
import service.HouselistService;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserlistService;
import org.springframework.stereotype.Controller;

@Controller
public class ApplyController
{
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private HouselistService houselistService;
    @Autowired
    private ApplyService applyService;
    
    @RequestMapping({ "/applycheckuserlist" })
    public String applycheckuserlist(final HttpSession httpSession, final Model model, final Integer id) {
        final User user1 = (User)httpSession.getAttribute("user");
        final Integer user_id = user1.getId();
        final Userlist list = this.userlistService.findhasuserlist(user_id);
        if (list == null) {
            model.addAttribute("error", (Object)"applycheck");
            return "redirect:houselist.action";
        }
        final Houselist houselist = this.houselistService.findid(id);
        houselist.setStatus("\u5df2\u88ab\u7533\u8bf7");
        this.houselistService.updatehousestatus(houselist);
        final Integer userlist_id = list.getId();
        final Apply apply = new Apply();
        apply.setHouse_id(houselist.getHouseid());
        apply.setAddress(houselist.getAddress());
        apply.setPrice(houselist.getPrice());
        apply.setArea(houselist.getArea());
        apply.setStatus("\u7533\u8bf7\u4e2d");
        apply.setUserlist_id(userlist_id);
        this.applyService.insertapply(apply);
        model.addAttribute("error", (Object)"applysuccess");
        return "redirect:houselist.action";
    }
    
    @RequestMapping({ "/findapplylist" })
    public String findapplylist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) throws Exception {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Apply> applylist = this.applyService.findapplylist();
        final PageInfo<Apply> p = (PageInfo<Apply>)new PageInfo((List)applylist);
        model.addAttribute("applylist", (Object)applylist);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"applylist.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/applychangehousestatus" })
    public String applychangehousestatus(final HttpSession httpSession, final Model model, final String house_id) throws Exception {
        final User user1 = (User)httpSession.getAttribute("user");
        final Integer user_id = user1.getId();
        final Userlist userlist = this.userlistService.findhasuserlist(user_id);
        final Houselist houselist = this.houselistService.findhouseid(house_id);
        houselist.setStatus("\u5df2\u79df\u8d41");
        this.houselistService.updatehousestatus(houselist);
        final Zulist zulist = new Zulist();
        zulist.setHouse_id(house_id);
        zulist.setPrice(houselist.getPrice());
        zulist.setAddress(houselist.getAddress());
        return "";
    }
    
    @RequestMapping({ "/refuseapply" })
    public String refuseapply(final String house_id, final Model model) {
        final Houselist houselist = new Houselist();
        houselist.setHouseid(house_id);
        houselist.setStatus("\u672a\u79df\u8d41");
        this.applyService.refuseapply(houselist);
        return "redirect:findapplylist.action";
    }
    
    @RequestMapping({ "/getmyapply" })
    public String getmyapply(final Model model, final HttpSession httpSession, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        if (user1 == null) {
            return "login";
        }
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        PageHelper.startPage((int)page, (int)pageSize);
        if (userlist != null) {
            final List<Userlist> list = this.userlistService.getmyapply(userlist.getId());
            final PageInfo<Userlist> p = (PageInfo<Userlist>)new PageInfo((List)list);
            model.addAttribute("userlist", (Object)list);
            model.addAttribute("p", (Object)p);
            model.addAttribute("mainPage", (Object)"myapply.jsp");
        }
        else {
            model.addAttribute("userlist", (Object)null);
            model.addAttribute("mainPage", (Object)"myapply.jsp");
        }
        return "zuke/main";
    }
}
