package cn.tedu.store.controller;

import cn.tedu.store.entity.City;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 15:33
 */
@Controller
@RequestMapping("/city")
public class CityController extends BaseController{
    @Autowired
   private ICityService cityService;
    @RequestMapping("/list.do")
    @ResponseBody
    public ResponseResult<List<City>> getList(String provinceCode){
        ResponseResult<List<City>> rr;
        List<City> cities=cityService.getCityListByProvinceCode(provinceCode);
        rr=new ResponseResult<>(ResponseResult.STATE_OK,cities);
        return rr;
    }
    @RequestMapping("/info.do")
    @ResponseBody
    public ResponseResult<City> getInfo(String cityCode){
        ResponseResult<City> rr;
        City city = cityService.getCityByCode(cityCode);
        rr=new ResponseResult<>(ResponseResult.STATE_OK,city);
        return rr;
    }

}
