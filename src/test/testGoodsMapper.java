import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/9/5 - 12:41
 */
public class testGoodsMapper {
    @Test
    public void testGetGoodsList(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
        GoodsMapper goodMapper = ac.getBean("goodsMapper", GoodsMapper.class);
        List<Goods> list = goodMapper.getGoodsList();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }
    @Test
    public void testgetgoodCategory(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");

    }



}
