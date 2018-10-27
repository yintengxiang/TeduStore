package cn.tedu.store.mapper;

import cn.tedu.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 张启阳
 * @date 2018/8/26 - 20:35
 */
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户信息
     * @return 受影响行数
     */
    Integer insert(User user);

    /**
     * 查询用户信息
     * @param where 查询条件
     * @param orderBy 排序
     * @param offset limit(0,1)
     * @param countPage limit(0,1)
     * @return 查询结果集合List
     */
    List<User> select(
            @Param("where") String where,
            @Param("orderBy") String orderBy,
            @Param("offset") Integer offset,
            @Param("countPage") Integer countPage
    );


    /**
     * 修改用户信息
     * @param user
     * @return 受影响的行数
     */
    Integer update(User user);


}
