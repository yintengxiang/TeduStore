import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 16:39
 */
public class AddressMapperTest {
    @Test
    public void testgetAddressListByUid(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        IAddressService addressService = ac.getBean("addressService", IAddressService.class);
        Integer uid=8;
        List<Address> addressListByUid = addressService.getAddressListByUid(uid);
        System.out.println("数据列表");
        for (Address address : addressListByUid) {
            System.out.println(address);
        }
        System.out.println("结束");

        ac.close();

    }
    @Test
    public void testGetAddress() {
        AbstractApplicationContext ac
                = new ClassPathXmlApplicationContext(
                "spring-dao.xml", "spring-service.xml");

        IAddressService service
                = ac.getBean(
                "addressService", IAddressService.class);

        Integer id = 2;
        Address address = service.getAddressById(id );
        System.out.println("【Result】");
        System.out.println(address);
        System.out.println("【Done】");

        ac.close();
    }

}
