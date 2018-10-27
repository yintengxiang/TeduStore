package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;

/**
 * @author 张启阳
 * @date 2018/9/10 - 10:56
 */
public interface OrderMapper {
    /**
     * 增加订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insert(Order order);
}
