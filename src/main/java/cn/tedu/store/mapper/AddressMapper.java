package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张启阳
 * @date 2018/8/30 - 16:20
 */
public interface AddressMapper {
    /**
     * 新增收获地址
     * @param address
     * @return
     */
    Integer insert(Address address);

    List<Address> select(@Param("where") String where, @Param("orderBy") String orderBy, @Param("offset") Integer offset, @Param("countPaPage") Integer countPaPage);

    /**
     * 删除收获地址
     * @param where
     * @return
     */
    Integer delete(@Param("where") String where);

    Integer update(Address address);


}
