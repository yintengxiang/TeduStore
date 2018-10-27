package cn.tedu.store.mapper;

import cn.tedu.store.entity.OrderItem;

/**
 * @author 张启阳
 * @date 2018/9/10 - 10:57
 */
public interface OrderItemMapper {
    /**
     * 增加订单中商品数据
     * @param orderItem 订单商品信息
     * @return 受影响的行数
     */
    Integer insert(OrderItem orderItem);
}
