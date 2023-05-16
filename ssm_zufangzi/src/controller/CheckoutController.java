// 
// 
// 

package controller;

import Pojo.Userlist;
import Pojo.User;
import javax.servlet.http.HttpSession;
import Pojo.Checkout;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import service.CheckoutService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/checkout" })
public class CheckoutController
{
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private UserlistService userlistService;
    
    @RequestMapping({ "/getallcheckout" })
    public String getallcheckout(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Checkout> checkout = this.checkoutService.getallcheckout();
        final PageInfo<Checkout> p = (PageInfo<Checkout>)new PageInfo((List)checkout);
        model.addAttribute("p", (Object)p);
        model.addAttribute("checkout", (Object)checkout);
        model.addAttribute("mainPage", (Object)"checkout.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/deletecheckout" })
    public String deletecheckout(final Integer id) {
        this.checkoutService.deletecheckout(id);
        return "redirect:/checkout/getmycheckout.action";
    }
    
    @RequestMapping({ "/admindeletecheckout" })
    public String admindeletecheckout(final Integer id) {
        this.checkoutService.deletecheckout(id);
        return "redirect:/checkout/getallcheckout.action";
    }
    
    @RequestMapping({ "/getmycheckout" })
    public String getmycheckout(final Model model, final HttpSession httpSession, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        if (user1 == null) {
            return "login";
        }
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        PageHelper.startPage((int)page, (int)pageSize);
        List<Userlist> list = null;
        if (userlist != null) {
            list = this.userlistService.getmycheckout(userlist.getId());
            final PageInfo<Userlist> p = (PageInfo<Userlist>)new PageInfo((List)list);
            model.addAttribute("p", (Object)p);
            model.addAttribute("userlistcheck", (Object)list);
            model.addAttribute("mainPage", (Object)"mycheckout.jsp");
        }
        else {
            model.addAttribute("userlistcheck", (Object)null);
            model.addAttribute("mainPage", (Object)"mycheckout.jsp");
        }
        return "zuke/main";
    }
}
