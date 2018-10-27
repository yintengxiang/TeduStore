package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;

public interface ICartService {
	
	int DEFAULT_COUNT_PER_PAGE = 20;
	
	/**
	 * 增加购物车数据
	 * @param cart 购物车数据
	 * @return 新增的数据对象，包括数据id
	 */
	Cart insert(Cart cart);
	
	/**
	 * 查询某用户的购物车信息
	 * @param uid 用户id
	 * @param page 页码
	 * @return 用户的购物车信息
	 */
	List<Cart> getListByUid(
            Integer uid,
            Integer page);
	
	/**
	 * 根据用户id和商品id查询购物车信息
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 购物车信息，如果没有匹配信息，则返回null
	 */
	Cart getCartByUserAndGoods(
            Integer uid,
            Long goodsId);
	
	/**
	 * 修改购物车某商品的数量
	 * @param num 商品的新的数量
	 * @param id 购物车信息的id
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	Integer changeNumber(
            Integer num,
            Integer id,
            Integer uid);
	
	/**
	 * 将商品添加到购物车
	 * @param cart 购物车信息
	 * @return 受影响的行数
	 */
	Integer addToCart(Cart cart);

	/**
	 * 根据若干个id获取购物车数据的集合
	 * @param cartIds 若干个id组成的数组
	 * @return 购物车数据的集合
	 */
	List<Cart> getListByIds(Integer[] cartIds);
	
}








