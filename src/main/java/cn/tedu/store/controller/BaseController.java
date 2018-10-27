package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

/**
 * @author 张启阳
 * @date 2018/8/29 - 11:04
 */
public abstract class  BaseController {
    public Integer getuidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
}
