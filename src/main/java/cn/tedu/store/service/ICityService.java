package cn.tedu.store.service;

import cn.tedu.store.entity.City;
import cn.tedu.store.entity.Province;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 14:07
 */
public interface ICityService {

    List<City> getCityListByProvinceCode(String provinceCode);

    City getCityByCode(String CityCode);
}
