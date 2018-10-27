package cn.tedu.store.service.ex;

/**
 * @author 张启阳
 * @date 2018/8/27 - 22:02
 */
public class UserNameConflictException extends ServiceException {

    private static final long serialVersionUID = -8805299603628683913L;

    public UserNameConflictException() {
    }

    public UserNameConflictException(String message) {
        super(message);
    }

    public UserNameConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameConflictException(Throwable cause) {
        super(cause);
    }

    public UserNameConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
