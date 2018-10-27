package cn.tedu.store.service.ex;

/**
 * @author 张启阳
 * @date 2018/9/10 - 14:10
 */
public class InsertFailException extends ServiceException {


    private static final long serialVersionUID = 3423944746460594186L;

    public InsertFailException() {
    }

    public InsertFailException(String message) {
        super(message);
    }

    public InsertFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertFailException(Throwable cause) {
        super(cause);
    }

    public InsertFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
