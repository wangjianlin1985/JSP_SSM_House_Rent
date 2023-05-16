// 
// 
// 

package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import Pojo.Houselist;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import service.HouselistService;
import org.springframework.stereotype.Controller;

@Controller
public class HoustlistController
{
    @Autowired
    private HouselistService houselistService;
    
    @RequestMapping({ "/houselist" })
    public String houselist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Houselist> houselist = this.houselistService.selectAll();
        final PageInfo<Houselist> p = (PageInfo<Houselist>)new PageInfo((List)houselist);
        model.addAttribute("p", (Object)p);
        model.addAttribute("houselist", (Object)houselist);
        model.addAttribute("mainPage", (Object)"houselist.jsp");
        return "zuke/main";
    }
    
    @RequestMapping({ "/ahouselist" })
    public String ahouselist(final Model model, @RequestParam(required = false, defaultValue = "1") final Integer page, @RequestParam(required = false, defaultValue = "5") final Integer pageSize) {
        PageHelper.startPage((int)page, (int)pageSize);
        final List<Houselist> houselist = this.houselistService.selectAll();
        final PageInfo<Houselist> p = (PageInfo<Houselist>)new PageInfo((List)houselist);
        model.addAttribute("p", (Object)p);
        model.addAttribute("houselist", (Object)houselist);
        model.addAttribute("mainPage", (Object)"ahouselist.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/addhouse" })
    public String addhouse(final Model model, final Houselist houselist) {
        final String houseid = houselist.getHouseid();
        final Houselist houselist2 = this.houselistService.findhouseid(houseid);
        if (houselist2 != null) {
            model.addAttribute("error", (Object)"\u8be5\u623f\u5c4bid\u5df2\u5b58\u5728");
            model.addAttribute("houselist", (Object)houselist);
            model.addAttribute("mainPage", (Object)"addhouse.jsp");
            return "admin/main1";
        }
        model.addAttribute("error", (Object)"\u6dfb\u52a0\u6210\u529f");
        this.houselistService.inserthouse(houselist);
        model.addAttribute("houselist", (Object)houselist);
        model.addAttribute("mainPage", (Object)"addhouse.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/toaddhouse" })
    public String toaddhoust(final Model model) {
        model.addAttribute("mainPage", (Object)"addhouse.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/deletehouse" })
    public String deletehouse(final Integer id) {
        this.houselistService.deletehouse(id);
        return "redirect:ahouselist.action";
    }
    
    @RequestMapping({ "/toahouselist" })
    public String toahouselist() {
        return "ahouselist.action";
    }
    
    @RequestMapping({ "/findid" })
    public String findid(final Integer id, final Model model) {
        final Houselist list = this.houselistService.findid(id);
        model.addAttribute("houselist", (Object)list);
        model.addAttribute("mainPage", (Object)"changehouse.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/findhouseidupdate" })
    public String findhouseidupdate(final Houselist houselist, final Model model) {
        final Houselist list = this.houselistService.findhouseidupdate(houselist);
        if (list != null) {
            model.addAttribute("houselist", (Object)houselist);
            model.addAttribute("mainPage", (Object)"changehouse.jsp");
            model.addAttribute("error", (Object)"\u8be5\u623f\u5c4bid\u5df2\u5b58\u5728");
            return "admin/main1";
        }
        this.houselistService.updatehouse(houselist);
        model.addAttribute("houselist", (Object)houselist);
        model.addAttribute("mainPage", (Object)"changehouse.jsp");
        model.addAttribute("error", (Object)"\u66f4\u65b0\u6210\u529f");
        return "admin/main1";
    }
}
