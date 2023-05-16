// 
// 
// 

package controller;

import Pojo.Checkout;
import Pojo.Apply;
import Pojo.Houselist;
import Pojo.Zulist;
import Pojo.Hetong;
import org.springframework.ui.Model;
import service.CheckoutService;
import service.ZulistService;
import service.ApplyService;
import service.HouselistService;
import org.springframework.beans.factory.annotation.Autowired;
import service.HetongService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/hetong" })
public class HetongController
{
    @Autowired
    private HetongService hetongService;
    @Autowired
    private HouselistService houselistService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private CheckoutService checkoutService;
    
    @RequestMapping({ "/inserthetong" })
    public String inserthetong(final Model model, final Hetong hetong) {
        this.hetongService.inserthetong(hetong);
        final Hetong hetong2 = this.hetongService.findhetong(hetong.getHouse_id());
        final Houselist houselist = this.houselistService.findhouseid(hetong2.getHouse_id());
        houselist.setStatus("\u5df2\u79df\u8d41");
        this.houselistService.updatehousestatus(houselist);
        final Zulist zulist = new Zulist();
        final Apply apply = this.applyService.findbyhouse_id(hetong.getHouse_id());
        zulist.setHouse_id(hetong.getHouse_id());
        zulist.setUserlist_id(apply.getUserlist_id());
        zulist.setContract_id(hetong2.getId());
        zulist.setPrice(apply.getPrice());
        zulist.setAddress(apply.getAddress());
        this.zulistService.insertzulist(zulist);
        this.applyService.deletebyhouse_id(hetong2.getHouse_id());
        model.addAttribute("error", (Object)"zusuccess");
        return "redirect:/zulist/findzulist.action";
    }
    
    @RequestMapping({ "/seehetong" })
    public String seehetong(final String house_id, final Model model) {
        final Hetong hetong = this.hetongService.findhetong(house_id);
        model.addAttribute("hetong", (Object)hetong);
        model.addAttribute("mainPage", (Object)"hetong.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/updatehetong" })
    public String updatehetong(final String house_id, final Model model) {
        final Hetong hetong = this.hetongService.findhetong(house_id);
        model.addAttribute("hetong", (Object)hetong);
        model.addAttribute("mainPage", (Object)"updatehetong.jsp");
        return "admin/main1";
    }
    
    @RequestMapping({ "/changehetong" })
    public String changehetong(final Hetong hetong) {
        this.hetongService.updatehetong(hetong);
        return "redirect:/zulist/findzulist.action";
    }
    
    @RequestMapping({ "/deletehetong" })
    public String deletehetong(final String house_id, final Model model) {
        this.hetongService.deletehetong(house_id);
        final Zulist zulist = this.zulistService.findzulist(house_id);
        final Checkout checkout = new Checkout();
        checkout.setHouse_id(house_id);
        checkout.setAddress(zulist.getAddress());
        checkout.setStatus("\u5df2\u9000\u79df");
        checkout.setUserlist_id(zulist.getUserlist_id());
        this.checkoutService.insertcheckout(checkout);
        this.houselistService.deletehousebyhouseid(house_id);
        this.zulistService.deletezulist(house_id);
        model.addAttribute("error", (Object)"checkoutsuccess");
        return "redirect:/zulist/findzulist.action";
    }
    
    @RequestMapping({ "/zukeseehetong" })
    public String zukeseehetong(final String house_id, final Model model) {
        final Hetong hetong = this.hetongService.findhetong(house_id);
        model.addAttribute("hetong", (Object)hetong);
        model.addAttribute("mainPage", (Object)"showhetong.jsp");
        return "zuke/main";
    }
}
