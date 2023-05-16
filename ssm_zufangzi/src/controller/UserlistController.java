// 
// 
// 

package controller;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import Pojo.Userlist;
import Pojo.User;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserlistService;
import org.springframework.stereotype.Controller;

@Controller
public class UserlistController
{
    @Autowired
    private UserlistService userlistService;
    
    @RequestMapping({ "/findhasuserlist" })
    public String findhasuserlist(final HttpSession httpSession, final Model model) throws Exception {
        final User user1 = (User)httpSession.getAttribute("user");
        final Integer user_id = user1.getId();
        final Userlist userlist = this.userlistService.findhasuserlist(user_id);
        model.addAttribute("userlist", (Object)userlist);
        model.addAttribute("mainPage", (Object)"updateuserlist.jsp");
        return "zuke/main";
    }
    
    @RequestMapping({ "/checkuserlist" })
    public String checkuserlist(final Model model, final Userlist userlist, final HttpSession httpSession) throws Exception {
        if (userlist.getId() == null) {
            final String idcard = userlist.getIdcard();
            final Userlist list = this.userlistService.checkuserlist(idcard);
            if (list != null) {
                model.addAttribute("error", (Object)"\u8be5\u8eab\u4efd\u8bc1\u5df2\u88ab\u7ed1\u5b9a,\u4e00\u4e2a\u8eab\u4efd\u8bc1\u53f7\u7801\u53ea\u80fd\u88ab\u4e00\u4e2a\u8d26\u6237\u7ed1\u5b9a\uff01");
                model.addAttribute("mainPage", (Object)"updateuserlist.jsp");
                model.addAttribute("userlist", (Object)userlist);
            }
            else {
                final User user1 = (User)httpSession.getAttribute("user");
                final Integer user_id = user1.getId();
                userlist.setUser_id(user_id);
                this.userlistService.insertuserlist(userlist);
                final Userlist list2 = this.userlistService.checkuserlist(idcard);
                model.addAttribute("error", (Object)"\u8d44\u6599\u5b8c\u5584\u6210\u529f");
                model.addAttribute("mainPage", (Object)"updateuserlist.jsp");
                model.addAttribute("userlist", (Object)list2);
            }
        }
        else {
            final Userlist list3 = this.userlistService.finduserlistupdate(userlist);
            if (list3 != null) {
                model.addAttribute("error", (Object)"\u8be5\u8eab\u4efd\u8bc1\u53f7\u7801\u5df2\u88ab\u7ed1\u5b9a");
                model.addAttribute("mainPage", (Object)"updateuserlist.jsp");
                model.addAttribute("userlist", (Object)userlist);
            }
            else {
                this.userlistService.updateuserlist(userlist);
                model.addAttribute("error", (Object)"\u66f4\u65b0\u6210\u529f");
                model.addAttribute("mainPage", (Object)"updateuserlist.jsp");
                model.addAttribute("userlist", (Object)userlist);
            }
        }
        return "zuke/main";
    }
    
    @RequestMapping({ "/findalluserlist" })
    public String findalluserlist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Userlist> userlist = this.userlistService.findalluserlist();
        final PageInfo<Userlist> p = (PageInfo<Userlist>)new PageInfo((List)userlist);
        model.addAttribute("userlist", (Object)userlist);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"userlist.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/deleteuserlist" })
    public String deleteuserlist(final Model model, final Integer id) {
        this.userlistService.deleteuserlist(id);
        model.addAttribute("error", (Object)"deletesuccess");
        return "redirect:findalluserlist.action";
    }
}
