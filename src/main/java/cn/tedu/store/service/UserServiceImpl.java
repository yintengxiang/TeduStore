package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNameConflictException;
import cn.tedu.store.service.ex.UsernameNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 张启阳
 * @date 2018/8/27 - 20:17
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @param user 用户信息
     * @return 插入后的用户信息携带ID返回
     */
    @Override
    public User reg(User user) {
        User userByUserName = findUserByUserName(user.getUsername());
        if(userByUserName!=null){
            //用户名被占用
            throw new UserNameConflictException("用户名"+user.getUsername()+"已经注册");
        }else {
            //用户名没有被占用

            String uuid = UUID.randomUUID().toString();
            String password = getEncrpytedPassword(user.getPassword(), uuid);
            user.setPassword(password);
            user.setUuid(uuid);
            Date date=new Date();
            user.setCreatedTime(date);
            user.setCreatedUser("System");
            user.setModifiedUser("System");
            user.setModifiedTime(date);



            userMapper.insert(user);
            return user;
        }



    }

    /**
     * 根据用户名查找用户信息
     * @param name 用户名
     * @return 如果有返回用户信息，没有则返回null
     */
    @Override
    public User findUserByUserName(String name) {
        String where="username='"+name+"'";
        List<User> select = userMapper.select(where, null, null, null);
        if(select.size()==0){
            return null;

        }else {

            return select.get(0);
        }


    }

    public String getEncrpytedPassword(String password,String salt){
        String str=password+salt;
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        return md5;
    }

    public User login(String username, String password) {
        // 根据用户名查询用户信息
        User user = findUserByUserName(username);
        // 判断是否查询到匹配的用户信息
        if (user == null) {
            // 没有：抛出异常：用户名不存在UsernameNotExistsException
            throw new UsernameNotExistsException("尝试登录的用户名" + username + "不存在！");

        } else {
            // 获取该用户的盐(UUID)
            String salt = user.getUuid();
            // 基于盐，对用户输入的密码(方法的参数)进行加密
            String md5Password
                    = getEncrpytedPassword(password, salt);
            // 判断加密后的密码，与获取的用户信息中的密码是否匹配
            if (user.getPassword().equals(md5Password)) {
                // 返回查询到的User对象
                return user;
            } else {
                // 不匹配，抛出异常：密码错误 PasswordNotMatchException
                throw new PasswordNotMatchException("您输入的密码有误！");
            }
        }
    }

    @Override
    public User findUserById(Integer id) {
        List<User> select = userMapper.select("id=" + id, null, null, null);
        if(select.size()>0){
            return select.get(0);

        }else {
            return null;
        }
    }

    @Override
    public Integer changePassword(Integer id, String oldpassword, String newpassword) {
       //获取id对应的用户信息
        User userById = findUserById(id);
        //判断用户信息是否存在
        if(userById==null){
            throw new UsernameNotExistsException("用户信息不存在，请联系管理员");
        }else {
            //获取盐值
            String salt=userById.getUuid();
            //加密旧密码
            String oldmd5password=getEncrpytedPassword(oldpassword,salt);
            //判断输入的旧密码是否正确
            if(oldmd5password.equals(userById.getPassword())){
                //加密新密码
                String md5newPassword=getEncrpytedPassword(newpassword,salt);
                User user=new User();
                user.setId(id);
                user.setPassword(md5newPassword);
                Integer integer = userMapper.update(user);
                return integer;
            }else {
                //旧密码输入错误
                throw new PasswordNotMatchException("您输入的原密码不正确！");
            }

        }


    }

    @Override
    public Integer changeInfo(Integer id, String username, Integer gender, String phone, String email) {
        User data=findUserById(id);
        if(data==null){
            throw new UsernameNotExistsException("用户不存在！");
        }else {
            if(username!=null){
                //不为null，即客户端提交了用户名，表示希望修改则：检查用户名是否被占用
                User user = findUserByUserName(username);
                if(user!=null){
                    //找到用户名匹配的数据，即用户名是存在的，则：判断这个用户名是不是当前用户的
                    if(data.getUsername().equals(user.getUsername())){
                        username=null;
                    }else {
                        //找到的用户名并不是自己占用的 ，而是别人的则：抛出异常
                        throw new UserNameConflictException("您希望更改的用户名已经被使用！");
                    }
                }
            }
            User user=new User();
            user.setId(id);
            user.setUsername(username);
            user.setGender(gender);
            user.setPhone(phone);
            user.setEmail(email);
            return userMapper.update(user);
        }
    }
}
