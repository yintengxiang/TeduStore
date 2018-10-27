package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import cn.tedu.store.service.ex.UserNameConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ServiceException;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/reg.do")
    public String showReg() {
        return "register";
    }

    @RequestMapping("/login.do")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/change_password.do")
    public String showChangePassword() {
        return "user_password";
    }

    @RequestMapping("/change_info.do")
    public String showChangeInfo(
            ModelMap modelMap,
            HttpSession session) {
        // 从session中获取当前用户的id
        Integer id = getuidFromSession(session);
        // 根据id获取当前用户的信息
        User user = userService.findUserById(id);
        // 判断是否获取到用户数据，因为可能在登录后，数据被管理员删除
        if (user != null) {
            // 将数据封装到ModelMap对象，以转发到前端页面
            modelMap.addAttribute("user", user);
            System.out.println(user);
            // 执行转发
            return "user_info";
        } else {
            // 找不到数据，极可能是被管理员删除了
            // 执行重定向
            return "redirect:../main/error.do";
        }
    }

    @RequestMapping(value="/handle_reg.do",
            method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleReg(
            String username,
            String password,
            String phone,
            String email,
            HttpSession session) {
        ResponseResult<Void> rr;

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);

        try {
            User u = userService.reg(user);
            session.setAttribute("uid", u.getId());
            session.setAttribute("username", u.getUsername());
            rr = new ResponseResult<Void>(
                    ResponseResult.STATE_OK);
        } catch (UserNameConflictException e) {
            rr = new ResponseResult<Void>(e);
        }

        return rr;
    }

    @RequestMapping(value="/handle_login.do",
            method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleLogin(
            String username,
            String password,
            HttpSession session) {
        ResponseResult<Void> rr;
        try {
            User user = userService.login(username, password);
            session.setAttribute("uid", user.getId());
            session.setAttribute("username", user.getUsername());
            rr = new ResponseResult<Void>(
                    ResponseResult.STATE_OK);
        } catch (ServiceException e) {
            rr = new ResponseResult<Void>(e);
        }
        return rr;
    }

    @RequestMapping(value="/handle_change_password.do",
            method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleChangePassword(
            String oldPassword,
            String newPassword,
            String confirmPassword,
            HttpSession session) {
        // 声明返回值
        ResponseResult<Void> rr;
        // 检查数据的有效性
        if (newPassword != null &&
                newPassword.equals(confirmPassword) &&
                newPassword.length() >= 6 && newPassword.length() <= 16) {
            try {
                // 从session中获取当前登录的用户的id
                Integer id = getuidFromSession(session);
                // 执行修改密码
                userService.changePassword(
                        id, oldPassword, newPassword);
                rr = new ResponseResult<Void>(
                        ResponseResult.STATE_OK);
            } catch (ServiceException e) {
                rr = new ResponseResult<Void>(e);
            }
        } else {
            // 两次输入的新密码不一致
            rr = new ResponseResult<Void>(
                    ResponseResult.STATE_REE,
                    "两次输入的新密码不一致！");
        }
        // 返回
        return rr;
    }

    @RequestMapping(value="/handle_change_info.do",
            method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleChangeInfo(
            String username,
            Integer gender,
            String phone,
            String email,
            HttpSession session) {
        // 检查数据的有效性
        if ("".equals(username)) {
            username = null;
        }
        // 获取session中的uid
        Integer id = getuidFromSession(session);

        // 声明返回值
        ResponseResult<Void> rr;

        try {
            // 执行修改
            userService.changeInfo(id, username, gender, phone, email);
            rr = new ResponseResult<Void>(
                    ResponseResult.STATE_OK);
        } catch (ServiceException e) {
            rr = new ResponseResult<Void>(e);
        }

        // 返回
        return rr;
    }
    @RequestMapping("/logout.do")
    public String handleLogout(HttpSession session){
        //清除session中的信息
        session.invalidate();
        //重定向到首页
        return "redirect:../main/index.do";
    }
}









