package cn.tedu.store.controller;

import cn.tedu.store.entity.Area;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 15:44
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {
   @Autowired
    private IAreaService areaService;
   @RequestMapping("/list.do")
    @ResponseBody
    public ResponseResult<List<Area>> getList(String cityCode){
       ResponseResult<List<Area>> rr;
       List<Area> areas = areaService.getAreaListByCityCode(cityCode);
       rr=new ResponseResult<>(ResponseResult.STATE_OK,areas);
       return rr;
   }

   @RequestMapping("/info.do")
   @ResponseBody
    public ResponseResult<Area> getInfo(String areaCode){
       ResponseResult<Area> rr;
       Area area = areaService.getAreaByCode(areaCode);
       rr=new ResponseResult<>(ResponseResult.STATE_OK,area);
       return rr;
   }
}
