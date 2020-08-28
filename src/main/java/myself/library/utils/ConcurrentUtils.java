package myself.library.utils;

import myself.library.model.entities.User;

/**
 * @program: library
 * @description: 并发同步工具
 * @author: ChaiRJ
 * @create: 2020-08-27 14:58
 **/
public class ConcurrentUtils {
    //线程内部存储类，线程安全
    private static ThreadLocal<User> host = new ThreadLocal<>();

    public static User getHost(){
        return host.get();
    }

    public static void setHost(User user){
        host.set(user);
    }
}
