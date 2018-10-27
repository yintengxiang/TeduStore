package cn.tedu.store.service;

import cn.tedu.store.entity.Address;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 17:06
 */
public interface IAddressService {
    Address addnew(Address address);

    //获取某个用户所创建的所有地址
    List<Address> getAddressListByUid(Integer uid);

    //根据数据id获取指定的收获地址信息
    Address getAddressById(Integer id);
    //通过id删除收获地址
    Integer deleteAddressById(Integer id,Integer uid);

    /**
     * 将指定的收货地址设置为默认收获地址
     * @param id
     * @param uid
     * @return
     */
    Integer  setDefault(Integer id,Integer uid);

    /**
     * 修改用户数据
     * @param address 封装数据对象
     * @param username 用户名，该收获地址的持有者
     * @return 受影响的行数
     * @throws cn.tedu.store.service.ex.DataNotfindException
     */
    Integer update(Address address,String username);


}

