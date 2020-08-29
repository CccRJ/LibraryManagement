package myself.library.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: library
 * @description: 密码加密，不可逆
 * @author: ChaiRJ
 * @create: 2020-08-28 15:24
 **/
public class MD5 {
    public static String encrypt(String key) {
        char[] hexDigits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 1.获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //2.使用指定字节更新摘要
            md5.update(btInput);
            //3.获得密文
            byte[] digest = md5.digest();
            //4.转换成十六进制字符串
            char[] str = new char[digest.length * 2];
            int k = 0;
            for (byte tmp : digest) {
                //与操作 1111
                //高4位
                str[k++] = hexDigits[tmp >>> 4 & 0xf];
                //低4位
                str[k++] = hexDigits[tmp & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
