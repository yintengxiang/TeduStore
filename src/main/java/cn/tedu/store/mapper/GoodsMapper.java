package cn.tedu.store.mapper;

import cn.tedu.store.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/9/5 - 11:52
 */
public interface GoodsMapper {

    /**
     * 获取所有商品的数据
     * @return 所有商品的数据的list集合
     */
    @Deprecated//已过期
    List<Goods> getGoodsList();

    /**
     * 通过商品分类ID--categoryId查询商品列表
     * @param categoryId 商品分类Id
     * @param offset 跳过的数据
     * @param countPerPage 每页显示的数据条数
     * @return 查询后的商品数据集合，在每一个商品中，只包括id、title、price、image
     */
    List<Goods> getGoodsListByCategory(@Param("categoryId") Long categoryId, @Param("offset") Integer offset, @Param("countPerPage") Integer countPerPage);

    /**
     * 通过商品分类ID--categoryId查询商品数量
     * @param categoryId  商品分类Id
     * @return 某个分类下的商品数量
     */
    Integer getGoodsCountByCategory(Long categoryId);

    /**
     * 根据商品id获取商品数据
     * @param id 商品id
     * @return 商品数据
     */
    Goods getGoodsById(Long id);

    /**
     * 根据商品型号获取商品列表
     * @param itemType 商品型号
     * @return 同型号的商品列表
     */
    List<Goods> getGoodsListByItemType(String itemType);

}
