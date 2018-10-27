package cn.tedu.store.service;

import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/9/5 - 14:49
 */
@Service("GoodsCategoryService")
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> getGoodsCategoryList(Long parentId) {
        List<GoodsCategory> list = goodsCategoryMapper.getGoodsCategoryList(parentId);

        return list;
    }

    @Override
    public List<GoodsCategory> getList(Long parentId, Integer count) {
        //通过持久层执行查询并获取数据
        List<GoodsCategory> list = goodsCategoryMapper.getList(parentId, count);
        return list;
    }
    //重载
    public List<GoodsCategory> getList(Long parentId) {
        //调用自身的重载方法
       return getList(parentId,null);
    }

    @Override
    public GoodsCategory getGoodsCategoryById(Long id) {

        return goodsCategoryMapper.getGoodsCategoryById(id);
    }
}
