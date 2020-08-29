package myself.library.service;

import myself.library.model.entities.User;
import myself.library.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description: 用户获取user服务
 * @author: ChaiRJ
 * @create: 2020-08-27 14:56
 **/
@Service
public class HostHolder {
    /**
     * 获取当前使用者
     * @return 返回user对象
     */
    public User getUser(){
        return ConcurrentUtils.getHost();
    }

    public void setUser(User user){
        ConcurrentUtils.setHost(user);
    }
}
