package myself.library.service;

import myself.library.dao.UserDao;
import myself.library.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description: 用户服务
 * @author: ChaiRJ
 * @create: 2020-08-27 20:44
 **/
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(int id){
        return userDao.selectById(id);
    }
    public User getUser(String name){
        return userDao.selectByName(name);
    }

    public int register(User user){
        return userDao.insertUser(user);
    }

    public int updateUserInfo(User user){
        return userDao.updateUserInfo(user);
    }

}
