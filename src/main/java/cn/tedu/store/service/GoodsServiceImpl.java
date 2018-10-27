package cn.tedu.store.service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/9/5 - 14:49
 */
@Service("GoodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsList() {
        List<Goods> list = goodsMapper.getGoodsList();

        return list;
    }

    @Override
    public List<Goods> getGoodsListByCategory(Long categoryId, Integer offset, Integer countPerPage) {
        List<Goods> goodsListByCategory = goodsMapper.getGoodsListByCategory(categoryId, offset, countPerPage);

        return goodsListByCategory;
    }

    public List<Goods> getGoodsListByCategory(Long categoryId, Integer countPerPage){
        List<Goods> list = getGoodsListByCategory(categoryId, 0, countPerPage);
        return list;
    }

    @Override
    public Integer getGoodsCountByCategory(Long categoryId) {

       return goodsMapper.getGoodsCountByCategory(categoryId);
    }

    @Override
    public Goods getGoodsById(Long id) {
       return goodsMapper.getGoodsById(id);

    }

    @Override
    public List<Goods> getGoodsListByItemType(String itemType) {

      return   goodsMapper.getGoodsListByItemType(itemType);
    }

}
