package myself.library.controller;

import com.sun.deploy.net.HttpResponse;
import myself.library.model.entities.User;
import myself.library.service.LoginService;
import myself.library.service.UserService;
import myself.library.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: library
 * @description: 登陆控制
 * @author: ChaiRJ
 * @create: 2020-08-27 15:35
 **/
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    /**
     * 用户登录
     *
     * @return 登陆页面
     */
    @RequestMapping(path = "/users/login", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    /**
     * 用户登录，保存cookie，response返回给浏览器
     * @param model
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(path = "/users/login/do", method = RequestMethod.POST)
    public String doLogin(Model model, HttpServletResponse response, User user) {
        try {
            String ticket = loginService.login(user.getUserName(), user.getUserPassword());
            CookieUtils.setCookie("ticket",ticket,response);
            //System.out.println("loginController-"+Thread.currentThread());
            return "redirect:/index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",e.getMessage());
            return "404";
        }

    }

    /**
     * 用户退出
     *
     * @return 登陆页面
     */
    @RequestMapping(path = "/users/logout/do", method = RequestMethod.GET)
    public String doLogout(@CookieValue("ticket") String ticket) {
        loginService.logout(ticket);
        return "redirect:/index";
    }

    /**
     * 用户注册调用
     *
     * @return 注册页面
     */
    @RequestMapping(path = "/users/register", method = RequestMethod.GET)
    public String register() {
        return "login/register";
    }

    /**
     * 用户注册，调用注册服务，抛出异常返回404页面
     *
     * @param model
     * @param response
     * @param user
     * @return 登陆页面
     */
    @RequestMapping(path = "/users/register/do", method = RequestMethod.POST)
    public String doRegister(Model model, HttpServletResponse response, User user) {
        try {
            String ticket = loginService.register(user);
            CookieUtils.setCookie("ticket",ticket,response);
            return "redirect:/index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "404";
        }
    }


}
