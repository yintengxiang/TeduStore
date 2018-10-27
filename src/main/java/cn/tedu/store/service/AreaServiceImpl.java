package cn.tedu.store.service;

import cn.tedu.store.entity.Area;
import cn.tedu.store.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 14:18
 */
@Service("areaService")
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> getAreaListByCityCode(String cityCode) {
        return areaMapper.getAreaListByCityCode(cityCode);
    }

    @Override
    public Area getAreaByCode(String areaCode) {
        return areaMapper.getAreaByCode(areaCode);
    }
}
