package myself.library.model.exceptions;

/**
 * @program: library
 * @description: 登陆异常错误
 * @author: ChaiRJ
 * @create: 2020-08-28 15:20
 **/
public class LoginRegisterException extends RuntimeException{
    public LoginRegisterException() {
        super();
    }

    public LoginRegisterException(String message) {
        super(message);
    }

    public LoginRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginRegisterException(Throwable cause) {
        super(cause);
    }
}
