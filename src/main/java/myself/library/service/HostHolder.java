package myself.library.service;

import myself.library.model.entities.User;
import myself.library.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description:
 * @author: ChaiRJ
 * @create: 2020-08-27 14:56
 **/
@Service
public class HostHolder {
    public User getUser(){
        return ConcurrentUtils.getHost();
    }

    public void setUser(User user){
        ConcurrentUtils.setHost(user);
    }
}
