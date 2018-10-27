package cn.tedu.store.service.ex;

/**
 * @author 张启阳
 * @date 2018/8/27 - 22:03
 */
public class ServiceException extends RuntimeException {


    private static final long serialVersionUID = 6725385242850681161L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
