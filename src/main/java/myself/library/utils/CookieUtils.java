package myself.library.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: library
 * @description:
 * @author: ChaiRJ
 * @create: 2020-08-28 16:40
 **/
public class CookieUtils {
    private static int COOKIE_AGE = 60 * 60 * 24 * 7;

    /**
     * 服务器设置cookie发送给客户端，客户端保存cookie
     *
     * @param key
     * @param value
     * @param response
     */
    public static void setCookie(String key, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(COOKIE_AGE);
        response.addCookie(cookie);
    }

    /**
     * 搜索cookie返回value
     *
     * @param key
     * @param request
     * @return
     */
    public static String getCookie(String key, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 找到cookie，覆盖空值
     * @param key
     * @param request
     * @param response
     */
    public static void removeCookie(String key, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
            if ((key).equalsIgnoreCase(cookies[i].getName())) {
                Cookie cookie = new Cookie(key, "");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }


}
