package myself.library.controller;

import com.sun.deploy.net.HttpResponse;
import myself.library.model.entities.User;
import myself.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 用户登录
     * @return 登陆页面
     */
    @RequestMapping(path = "/users/login",method= RequestMethod.GET)
    public String login(){
        return "login/login";
    }

    /**
     * 用户退出
     * @return 登陆页面
     */
    @RequestMapping(path = "/users/logout/do",method= RequestMethod.GET)
    public String doLogout(@CookieValue("t") String t){
        return "login/login";
    }

    /**
     * 用户注册调用
     * @return 注册页面
     */
    @RequestMapping(path = "/users/register",method = RequestMethod.GET)
    public String register(){
        return "login/register";
    }

    @RequestMapping(path = "/users/register/do",method = RequestMethod.POST)
    public String doRegister(Model model, HttpResponse response, User user){
        userService.register(user);
        return "redirect:/index";
    }

}
