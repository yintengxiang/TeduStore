package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	@Autowired
	private ICartService cartService;
	@Autowired
	private IAddressService addressService;

	@RequestMapping("/confirm.do")
	public String showConfirm(
		@RequestParam("cart_ids") Integer[] cartIds,
		ModelMap modelMap,
		HttpSession session) {
		// 获取uid
		Integer uid = getuidFromSession(session);
		// 读取当前用户的收货地址
		List<Address> addresses = 
				addressService
					.getAddressListByUid(uid);
		// 根据用户提交的cart_ids获取若干个购物车中的商品信息
		List<Cart> carts = 
				cartService.getListByIds(cartIds);
		
		// 测试即将转发的数据
		for (Address addr : addresses) {
			System.out.println(addr);
		}
		for (Cart cart : carts) {
			System.out.println(cart);
		}
		
		// 将用户的购物车信息封装，以准备转发到JSP
		modelMap.addAttribute("addresses", addresses);
		modelMap.addAttribute("carts", carts);
		
		// 执行转发
		return "order_confirm";
	}
	
}






