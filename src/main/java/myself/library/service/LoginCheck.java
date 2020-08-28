package myself.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description: 登陆检查
 * @author: ChaiRJ
 * @create: 2020-08-27 21:28
 **/
@Service
public class LoginCheck {

    @Autowired
    UserService userService;


}
