package myself.library.utils;

import java.util.UUID;

/**
 * @program: library
 * @description: UUID工具
 * @author: ChaiRJ
 * @create: 2020-08-28 16:00
 **/
public class UUIDUtils {
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "a");
    }
}
