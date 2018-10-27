package cn.tedu.store.controller;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.entity.Province;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 17:27
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired private IGoodsCategoryService goodsCategoryService;
    @RequestMapping("/address.do")
    public String showTest(ModelMap map){
        List<Province> provinces = provinceService.getProvinceList();
        map.addAttribute("provinces",provinces);
        return "test";
    }

    @RequestMapping("/goods.do")
    public String showGoodsList(ModelMap map){
        List<Goods> goodsList = goodsService.getGoodsList();
        map.addAttribute("goodsList",goodsList);
        return "test_goods";
    }
    @RequestMapping("/goods_category.do")
    public String showGoodsCategoryList(Long parentId,ModelMap map){
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.getGoodsCategoryList(parentId);
        map.addAttribute("goodsCategoryList",goodsCategoryList);
        return "test_goods_category";
    }

}
