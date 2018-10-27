package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.service.ex.InsertFailException;

public interface IOrderService {

	/**
	 * 增加订单数据
	 * @param order 订单数据
	 * @return 成功增加的订单数据，包括订单id
	 * @throws InsertFailException
	 */
	Order insert(Order order);
	
	/**
	 * 增加订单中的商品数据
	 * @param orderItem 订单中的商品数据
	 * @return 受影响的行数
	 */
	Integer insert(OrderItem orderItem);
	
	/**
	 * 创建订单
	 * @param order 订单表数据
	 * @param orderItems 多条订单中的商品数据
	 * @return 成功创建后的订单表数据，该数据中包括订单ID
	 */
	Order createOrder(
            Order order,
            List<OrderItem> orderItems);
	
}
