package cn.tedu.store.service;

import java.util.Date;
import java.util.List;

import cn.tedu.store.service.ex.DataNotfindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OrderBy;

@Service("addressService")
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private ICityService cityService;
    @Autowired
    private IAreaService areaService;

    @Autowired
    private AddressMapper addressMapper;

    public Address addnew(Address address) {
        // TODO 组成recvDistrict
        // 11000  110100  110101
        // recvDistrict = "北京市   市辖区     海淀区"
         String district=getDistrict(
                 address.getRecvProvince(),
                 address.getRecvCity(),
                 address.getRecvArea()
         );
        address.setRecvDistrict(district);
        // 封装日志信息
        Date now = new Date();
        address.setCreatedUser("System");
        address.setCreatedTime(now);
        address.setModifiedUser("System");
        address.setModifiedTime(now);
        //确定是否为默认收货地址
        List<Address> list = getAddressListByUid(address.getUid());
        if(list.size()==0){
            // 在执行此次增加之前，该用户还没有任何收货地址信息
            // 则此次增加的收货地址应该是默认的
            address.setIsDefault(1);
        }else {
            // 在执行此次增加之前，该用户已经有收货地址信息
            address.setIsDefault(0);
        }

        // 执行增加
        addressMapper.insert(address);
        // 返回
        return address;
    }

    @Override
    public List<Address> getAddressListByUid(Integer uid) {
        String where="uid="+uid;
        String OrderBy="is_default desc";
        List<Address> addresses = addressMapper.select(where, OrderBy, null, null);
        return addresses;

    }

    @Override
    public Address getAddressById(Integer id) {
        String where="id="+id;
        List<Address> list = addressMapper.select(where, null, null, null);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    @Transactional
    public Integer deleteAddressById(Integer id,Integer uid) {
        // 根据要删除的数据的id，查询数据
        Address address = getAddressById(id);

        //确定删除时的条件
        String where="id="+id+" and uid="+uid;
        //执行删除
        Integer integer = addressMapper.delete(where);

        // 查询该数据是否是默认收货地址
        // 执行删除
        Integer rows = addressMapper.delete(where);
        //判断删除是否成功
        if (rows == 0) {
            throw new DataNotfindException("删除失败！请联系管理员");
        }

        if (address.getIsDefault()==1) {
            // 是默认收货地址
            // 查询该用户所有收货地址中id最大的那一条，通过持久层对象直接查询
            // select * from t_address where uid=? order by id desc limit 0,1
            where="uid="+uid;
            String orderBy="id desc";
            Integer offset=0;
            Integer countPaPage=1;
            List<Address> list = addressMapper.select(where,orderBy,offset,countPaPage);
            if (list.size() > 0) {
                // 获取用户剩下的数据中的第1条要设置为默认的
                Address data = list.get(0);
                // 获取第1条数据的id
                Integer dataId = data.getId();
                // 将这条数据设置为默认收货地址
                // 直接调用持久层进行处理
                Address addr = new Address();
                addr.setId(dataId);
                addr.setUid(uid);
                addr.setIsDefault(1);
                rows = addressMapper.update(addr);
                if (rows > 0) {
                    // 成功把某数据设置为默认收货地址
                    return 1;
                } else {
                    // 失败
                    throw new DataNotfindException("删除失败！……");
                }
            }
        }

        return integer;
    }

    @Override
    @Transactional
    public Integer setDefault(Integer id, Integer uid) {
        // 创建Address对象，因为持久层方法参数必须是Address类型
        Address address=new Address();
        // 将第1条修改的数据封装到address对象中
        address.setIsDefault(0);
        address.setUid(uid);
        // 执行：将该uid的所有收货地址设置为非默认
        Integer rows = addressMapper.update(address);
        // 判断以上操作是否成功
        if(rows>0){
            // 受影响行数大于0，则操作成功，准备执行第2次修改操作
            // 将第2次修改的数据封装到address对象
            address.setId(id);
            address.setUid(uid);
            address.setIsDefault(1);
            // 执行：将指定的收货地址设置为默认收货地址
            rows=addressMapper.update(address);
            // 判断以上操作是否成功
            if(rows>0){
                return rows;
            }else{
                throw new DataNotfindException("修改失败！请求访问的数据不存在，请联系系统管理员！");
            }
        }else{
            // 受影响行数不大于0（等于0）
            // 可能是用户通过修改URL非法访问
            // 也可能是用户显示列表后，后台将数据删除
            throw new DataNotfindException("修改失败！请求访问的数据不存在，请联系系统管理员！");
        }
    }

    /**
     * 获取省市区的名称
     * @param provinceCode 省的代号
     * @param cityCode 市的代号
     * @param areaCode 区的代号
     * @return 省市区的名称
     */
    private String getDistrict(String provinceCode,String cityCode,String areaCode){

        StringBuffer district = new StringBuffer();
        String provinceName =
                provinceService.getProvinceByCode(provinceCode).getName();
        String cityName =
                cityService.getCityByCode(cityCode).getName();
        String areaName =
                areaService.getAreaByCode(areaCode).getName();
        district.append(provinceName);
        district.append(cityName);
        district.append(areaName);

        return district.toString();

    }

    @Override
    public Integer update(Address address,String username) {
       //获取省市区的名称
        String district=getDistrict(
                address.getRecvProvince(),
                address.getRecvCity(),
                address.getRecvArea());

        //确定参数address中的必要数据
        address.setIsDefault(null);
        address.setRecvDistrict(district);
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        // 执行修改
        Integer rows = addressMapper.update(address);

        // 判断执行结果
        if (rows == 1) {
            return 1;//基于id进行修改，受影响的行数只能为1;
        } else {
            throw new DataNotfindException("修改失败！尝试修改的数据不存在，请联系系统管理员！");
        }
    }
}
