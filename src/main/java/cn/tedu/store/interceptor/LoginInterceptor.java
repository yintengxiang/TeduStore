package cn.tedu.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author 张启阳
 * @date 2018/9/4 - 16:35
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //判断登陆状态，如果没有登录，则跳转到登录页
        HttpSession session= request.getSession();
        if(session.getAttribute("uid")==null){
            //session中没有uid,重定向到登录页
            response.sendRedirect("../user/login.do");
            //返回：拦截，不继续向后分发到控制器
            return false;
        }else {
            //已经登录
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
