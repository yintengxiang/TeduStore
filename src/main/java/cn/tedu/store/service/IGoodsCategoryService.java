package cn.tedu.store.service;

import cn.tedu.store.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/9/5 - 14:48
 */

public interface IGoodsCategoryService {
    /**
     * 获取某个分类下的分类列表
     * @param parentId 父级分类的id
     * @return 商品分类的list集合
     */
    List<GoodsCategory> getGoodsCategoryList(Long parentId);

    /**
     * 获取某个分类下的分类列表
     * @param parentId
     * @param count 获取多少条数据
     * @return 商品分类列表的list集合
     */
    List<GoodsCategory> getList(@Param("parentId") Long parentId, @Param("count") Integer count);

    List<GoodsCategory> getList(Long id);

    GoodsCategory getGoodsCategoryById(Long id);
}
