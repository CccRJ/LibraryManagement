package myself.library.utils;

import myself.library.model.entities.User;

/**
 * @program: library
 * @description: 并发同步工具，当前访问者容器host
 * @author: ChaiRJ
 * @create: 2020-08-27 14:58
 **/
public class ConcurrentUtils {
    //线程内部存储类，线程安全
    private static ThreadLocal<User> host = new ThreadLocal<>();

    public static User getHost() {
        //System.out.println("get-"+Thread.currentThread());
        return host.get();
    }

    /**
     * ThreadLocal 当前线程存储user对象
     *
     * @param user
     */
    public static void setHost(User user) {
        //System.out.println("set-"+Thread.currentThread());
        host.set(user);
    }
}
