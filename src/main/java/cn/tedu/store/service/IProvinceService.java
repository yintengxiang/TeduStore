package cn.tedu.store.service;

import cn.tedu.store.entity.Province;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 12:53
 */
public interface IProvinceService {
    /**
     * 获取所有省的列表
     */
    List<Province> getProvinceList();

    /**
     * 根据省的代号，获取省的信息
     */
    Province getProvinceByCode(String provinceCode);
}
