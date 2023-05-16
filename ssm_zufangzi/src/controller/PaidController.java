// 
// 
// 

package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import Pojo.Topaid;
import Pojo.Zulist;
import Pojo.Userlist;
import Pojo.User;
import javax.servlet.http.HttpSession;
import Pojo.Paid;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import Pojo.QueryVo;
import org.springframework.ui.Model;
import service.UserlistService;
import service.TopaidService;
import org.springframework.beans.factory.annotation.Autowired;
import service.PaidService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/paid" })
public class PaidController
{
    @Autowired
    private PaidService paidService;
    @Autowired
    private TopaidService topaidService;
    @Autowired
    private UserlistService userlistService;
    
    @RequestMapping({ "/selectall" })
    public String selectall(final Model model, final QueryVo vo, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Paid> list = this.paidService.selectall(vo);
        final PageInfo<Paid> p = (PageInfo<Paid>)new PageInfo((List)list);
        final Double sum = this.paidService.selectsum(vo);
        model.addAttribute("paid", (Object)list);
        model.addAttribute("sum", (Object)sum);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"paid.jsp");
        model.addAttribute("vo", (Object)vo);
        return "admin/main1";
    }
    
    @RequestMapping({ "/findmypaid" })
    public String findmypaid(final HttpSession httpSession, final Model model, final QueryVo vo, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        vo.setUserlist_id(userlist.getId());
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Paid> list = this.paidService.selectall(vo);
        final PageInfo<Paid> p = (PageInfo<Paid>)new PageInfo((List)list);
        final Double sum = this.paidService.selectsum(vo);
        model.addAttribute("paid", (Object)list);
        model.addAttribute("sum", (Object)sum);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"mypaid.jsp");
        model.addAttribute("vo", (Object)vo);
        return "zuke/main";
    }
    
    @RequestMapping({ "/deletepaid" })
    public String deletepaid(final Integer id) {
        this.paidService.deletepaid(id);
        return "redirect:selectall.action";
    }
    
    @RequestMapping({ "/zukedeletepaid" })
    public String zukedeletepaid(final Integer id) {
        this.paidService.deletepaid(id);
        return "redirect:findmypaid.action";
    }
    
    @RequestMapping({ "/showaddpaid" })
    public String showaddpaid(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) throws Exception {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Zulist> list = this.paidService.findzuuserlist();
        final PageInfo<Zulist> p = (PageInfo<Zulist>)new PageInfo((List)list);
        model.addAttribute("zulist", (Object)list);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"showaddpaid.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/addpaid" })
    public String addpaid(final Integer id, final Model model) {
        final Zulist zulist = this.paidService.findzukezulist(id);
        model.addAttribute("zulist", (Object)zulist);
        model.addAttribute("mainPage", (Object)"addpaid.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/inserttopaid" })
    public String inserttopaid(final Topaid topaid, final Model model) {
        this.topaidService.inserttopaid(topaid);
        model.addAttribute("error", (Object)"inserttopaid");
        return "redirect:showaddpaid.action";
    }
    
    @RequestMapping({ "/topaidlist" })
    public String topaidlist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final QueryVo vo = new QueryVo();
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Topaid> list = this.topaidService.findtopaid(vo);
        final PageInfo<Topaid> p = (PageInfo<Topaid>)new PageInfo((List)list);
        model.addAttribute("topaid", (Object)list);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"topaid.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/mytopaidlist" })
    public String mytopaidlist(final Model model, final HttpSession httpSession, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        if (user1 == null) {
            return "login";
        }
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        if (userlist != null) {
            final QueryVo vo = new QueryVo();
            vo.setUserlist_id(userlist.getId());
            PageHelper.startPage((int)page, (int)pageSize);
            final List<Topaid> topaid = this.topaidService.findtopaid(vo);
            final PageInfo<Topaid> p = (PageInfo<Topaid>)new PageInfo((List)topaid);
            model.addAttribute("p", (Object)p);
            model.addAttribute("topaid", (Object)topaid);
            model.addAttribute("mainPage", (Object)"mytopaid.jsp");
        }
        else {
            model.addAttribute("topaid", (Object)null);
            model.addAttribute("mainPage", (Object)"mytopaid.jsp");
        }
        return "zuke/main";
    }
    
    @RequestMapping({ "/gotopay" })
    public String gotopay(final Integer id, final Model model) {
        final Date dt = new Date();
        final SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
        final String paydate = matter1.format(dt);
        final Topaid topaid = this.topaidService.findbyid(id);
        final Paid paid = new Paid();
        paid.setHouse_id(topaid.getHouse_id());
        paid.setAddress(topaid.getAddress());
        paid.setPrice(topaid.getPrice());
        paid.setDate(topaid.getDate());
        paid.setPaydate(paydate);
        paid.setName(topaid.getName());
        paid.setUserlist_id(topaid.getUserlist_id());
        paid.setStatus("\u79df\u91d1\u5df2\u7f34");
        this.topaidService.gotopay(id, paid);
        model.addAttribute("error", (Object)"paysucess");
        return "redirect:findmypaid.action";
    }
}
