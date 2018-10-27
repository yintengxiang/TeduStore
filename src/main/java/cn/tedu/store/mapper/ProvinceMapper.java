package cn.tedu.store.mapper;

import cn.tedu.store.entity.Province;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 10:47
 */
public interface ProvinceMapper {
    /**
     * 获取所有省的列表
     * @return 所有省的列表
     */
    List<Province> getProvinceList();

    /**
     * 根据省的代号，获取省的信息
     * @param provinceCode 省的代号
     * @return 省的信息
     */
    Province getProvinceByCode(String provinceCode);


}
