package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderItemMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.ex.InsertFailException;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;

	public Order insert(Order order) {
		Integer rows = orderMapper
				.insert(order);
		if (rows == 1) {
			return order;
		} else {
			throw new InsertFailException(
				"增加数据失败！请联系系统员！");
		}
	}

	public Integer insert(OrderItem orderItem) {
		Integer rows = orderItemMapper
				.insert(orderItem);
		if (rows == 1) {
			return 1;
		} else {
			throw new InsertFailException(
				"增加数据失败！请联系系统员！");
		}
	}

	@Transactional
	public Order createOrder(
			Order order, 
			List<OrderItem> orderItems) {
		// 增加订单表数据，并产生订单id
		insert(order);
		// 获取订单id
		Integer orderId = order.getId();
			
		// 遍历多个订单中的商品信息
		for (OrderItem orderItem : orderItems) {
			// 为订单中的商品数据添加订单id
			orderItem.setOrderId(orderId);
			// 增加订单中的商品数据
			insert(orderItem);
		}
		// 返回订单表数据
		return order;
	}

}
