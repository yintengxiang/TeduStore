package cn.tedu.store.service.ex;

import cn.tedu.store.service.ex.ServiceException;

/**
 * @author 张启阳
 * @date 2018/8/28 - 15:14
 */
public class UsernameNotExistsException extends DataNotfindException {


    private static final long serialVersionUID = -7615440882222638070L;

    public UsernameNotExistsException() {
    }

    public UsernameNotExistsException(String message) {
        super(message);
    }

    public UsernameNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotExistsException(Throwable cause) {
        super(cause);
    }

    public UsernameNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
