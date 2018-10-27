import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/27 - 20:35
 */
public class TestUser {
    @Test
    public void testchangeInfo(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl", UserServiceImpl.class);
        Integer integer = userServiceImpl.changeInfo(1, "admin1", 1, "10000000000", "1000000000@qq.com");
        System.out.println(integer);
        ac.close();
    }

    @Test
    public void testSelect(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        List<User> select = userMapper.select(
                "id=4", null, null, null
        );
        for (User user : select) {
            System.out.println(user);
        }
        ac.close();
    }
    @Test
    public void testchangePassword(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl", UserServiceImpl.class);
        Integer integer = userServiceImpl.changePassword(
                9,"123456" , "1212"
        );
        System.out.println(integer);
        ac.close();
    }
    public List queryAllDeptIds(String deptId,List<Department> depts){

        return null;
    }
}
