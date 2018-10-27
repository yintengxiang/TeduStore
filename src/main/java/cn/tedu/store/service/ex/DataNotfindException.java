package cn.tedu.store.service.ex;

/**
 * @author 张启阳
 * @date 2018/9/3 - 10:43
 */
public class DataNotfindException extends ServiceException {
    private static final long serialVersionUID = 6730897352100786122L;

    public DataNotfindException() {
    }

    public DataNotfindException(String message) {
        super(message);
    }

    public DataNotfindException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotfindException(Throwable cause) {
        super(cause);
    }

    public DataNotfindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
