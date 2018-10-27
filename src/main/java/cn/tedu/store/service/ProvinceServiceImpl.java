package cn.tedu.store.service;

import cn.tedu.store.entity.Province;
import cn.tedu.store.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 12:54
 */
@Service("provinceSerice")
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;
    @Override
    public List<Province> getProvinceList() {
        return provinceMapper.getProvinceList();
    }

    @Override
    public Province getProvinceByCode(String provinceCode) {
        return provinceMapper.getProvinceByCode(provinceCode);
    }
}
