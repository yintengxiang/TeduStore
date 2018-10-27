package cn.tedu.store.service;

import cn.tedu.store.entity.Area;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 14:18
 */
public interface IAreaService {
    List<Area> getAreaListByCityCode(String cityCode);

    Area getAreaByCode(String areaCode);


}
