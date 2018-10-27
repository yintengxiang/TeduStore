package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UsernameNotExistsException;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author 张启阳
 * @date 2018/8/27 - 20:02
 */

public interface IUserService {
    User reg(User user);

   User findUserByUserName(String name);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功登录的用户信息
     * @throws UsernameNotExistsException
     * @throws PasswordNotMatchException
     */
    User login(String username, String password);

    User findUserById(Integer id);

    /**
     * 修改密码
     * @param id 用户id
     * @param oldpassword 旧密码
     * @param newpassword 新密码
     * @return 受影响的行数
     */
    Integer changePassword(Integer id,String oldpassword,String newpassword);

    /**
     * 修改用户信息
     * @param id 用户id
     * @param username 用户名
     * @param gender 性别
     * @param phone 电话
     * @param email 邮箱
     * @return 受影响行数
     */
    Integer changeInfo(Integer id,String username,Integer gender,String phone,String email);
}
