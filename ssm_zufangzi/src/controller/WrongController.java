// 
// 
// 

package controller;

import Pojo.Wrong;
import Pojo.Zulist;
import Pojo.Userlist;
import Pojo.User;
import javax.servlet.http.HttpSession;
import Pojo.Solve;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import Pojo.QueryVo;
import org.springframework.ui.Model;
import service.ZulistService;
import service.PaidService;
import service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import service.SolveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/wrong" })
public class WrongController
{
    @Autowired
    private SolveService solveService;
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private PaidService paidService;
    @Autowired
    private ZulistService zulistService;
    
    @RequestMapping({ "/selectall" })
    public String selectall(final Model model, final QueryVo vo, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Solve> list = this.solveService.selectall(vo);
        final PageInfo<Solve> p = (PageInfo<Solve>)new PageInfo((List)list);
        final Integer count = this.solveService.selectcount(vo);
        model.addAttribute("solve", (Object)list);
        model.addAttribute("count", (Object)count);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"solve.jsp");
        model.addAttribute("vo", (Object)vo);
        return "admin/main1";
    }
    
    @RequestMapping({ "/findmysolve" })
    public String findmysolve(final HttpSession httpSession, final Model model, final QueryVo vo, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        vo.setUserlist_id(userlist.getId());
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Solve> list = this.solveService.selectall(vo);
        final PageInfo<Solve> p = (PageInfo<Solve>)new PageInfo((List)list);
        final Integer count = this.solveService.selectcount(vo);
        model.addAttribute("solve", (Object)list);
        model.addAttribute("count", (Object)count);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"mysolve.jsp");
        model.addAttribute("vo", (Object)vo);
        return "zuke/main";
    }
    
    @RequestMapping({ "/deletesolve" })
    public String deletesolve(final Integer id) {
        this.solveService.deletesolve(id);
        return "redirect:selectall.action";
    }
    
    @RequestMapping({ "/zukedeletesolve" })
    public String zukedeletesolve(final Integer id) {
        this.solveService.deletesolve(id);
        return "redirect:findmypaid.action";
    }
    
    @RequestMapping({ "/showaddwrong" })
    public String showaddwrong(final HttpSession httpSession, final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) throws Exception {
        final User user1 = (User)httpSession.getAttribute("user");
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Zulist> list = this.zulistService.findzulistbyuid(userlist.getId());
        final PageInfo<Zulist> p = (PageInfo<Zulist>)new PageInfo((List)list);
        model.addAttribute("zulist", (Object)list);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"showaddwrong.jsp");
        return "zuke/main";
    }
    
    @RequestMapping({ "/addwrong" })
    public String addwrong(final Integer id, final Model model) {
        final Zulist zulist = this.paidService.findzukezulist(id);
        model.addAttribute("zulist", (Object)zulist);
        model.addAttribute("mainPage", (Object)"addwrong.jsp");
        return "zuke/main";
    }
    
    @RequestMapping({ "/insertwrong" })
    public String insertwrong(final Wrong wrong, final Model model) {
        this.solveService.insertwrong(wrong);
        model.addAttribute("error", (Object)"insertwrong");
        return "redirect:showaddwrong.action";
    }
    
    @RequestMapping({ "/wronglist" })
    public String wronglist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final QueryVo vo = new QueryVo();
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Wrong> list = this.solveService.findwrong(vo);
        final PageInfo<Wrong> p = (PageInfo<Wrong>)new PageInfo((List)list);
        model.addAttribute("wrong", (Object)list);
        model.addAttribute("p", (Object)p);
        model.addAttribute("mainPage", (Object)"wrong.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/mywronglist" })
    public String mywronglist(final Model model, final HttpSession httpSession, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        final User user1 = (User)httpSession.getAttribute("user");
        if (user1 == null) {
            return "login";
        }
        final Userlist userlist = this.userlistService.findhasuserlist(user1.getId());
        if (userlist != null) {
            final QueryVo vo = new QueryVo();
            vo.setUserlist_id(userlist.getId());
            PageHelper.startPage((int)page, (int)pageSize);
            final List<Wrong> list = this.solveService.findwrong(vo);
            final PageInfo<Wrong> p = (PageInfo<Wrong>)new PageInfo((List)list);
            model.addAttribute("p", (Object)p);
            model.addAttribute("wrong", (Object)list);
            model.addAttribute("mainPage", (Object)"mywrong.jsp");
        }
        else {
            model.addAttribute("wrong", (Object)null);
            model.addAttribute("mainPage", (Object)"mywrong.jsp");
        }
        return "zuke/main";
    }
    
    @RequestMapping({ "/gotosolve" })
    public String gotosolve(final Integer id, final Model model) {
        final Wrong wrong = this.solveService.findbyid(id);
        final Solve solve = new Solve();
        solve.setHouse_id(wrong.getHouse_id());
        solve.setAddress(wrong.getAddress());
        solve.setDate(wrong.getDate());
        solve.setDetail(wrong.getDetail());
        solve.setName(wrong.getName());
        solve.setUserlist_id(wrong.getUserlist_id());
        solve.setStatus("\u5df2\u5904\u7406");
        this.solveService.gotosolve(id, solve);
        model.addAttribute("error", (Object)"duesucess");
        return "redirect:selectall.action";
    }
}
