package cn.tedu.store.service;

import cn.tedu.store.entity.City;
import cn.tedu.store.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 14:09
 */
@Service("cityService")
public class CityServiceImpl implements ICityService {
    @Autowired
    private CityMapper cityMapper;


    @Override
    public List<City> getCityListByProvinceCode(String provinceCode) {
        return cityMapper.getCityListByProvinceCode(provinceCode);
    }

    @Override
    public City getCityByCode(String CityCode) {
        return cityMapper.getCityByCode(CityCode);
    }
}
