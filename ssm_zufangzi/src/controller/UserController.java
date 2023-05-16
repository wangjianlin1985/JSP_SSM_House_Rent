// 
// 
// 

package controller;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import Pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping({ "/login" })
    public String userList() throws Exception {
        return "login";
    }
    
    @RequestMapping({ "/register" })
    public String register() throws Exception {
        return "register";
    }
    
    @RequestMapping({ "/logincheck" })
    public String login(final User user, final Model model, final HttpSession httpSession) throws Exception {
        final User user2 = this.userService.login(user);
        if (user2 == null) {
            final String error = "error";
            model.addAttribute("error", (Object)error);
            return "login";
        }
        httpSession.setAttribute("user", (Object)user2);
        if (user2.getType().equals("zuke")) {
            return "zuke/main";
        }
        return "admin/main1";
    }
    
    @RequestMapping({ "/registercheck" })
    public String registercheck(final User user, final Model model, final HttpSession httpSession) throws Exception {
        user.setType("zuke");
        final int num = this.userService.register(user);
        if (num > 0) {
            return "login";
        }
        return "register";
    }
    
    @RequestMapping({ "/toindex" })
    public String toindex(final Model model) throws Exception {
        return "admin/index";
    }
}
