package cn.tedu.store.entity;

import java.io.Serializable;

/**
 * @author 张启阳
 * @date 2018/8/30 - 10:25
 */
public class City implements Serializable {
    private static final long serialVersionUID = 5548487581175393841L;
    private Integer id;
    private String provinceCode;
    private String code;
    private String name;

    public City() {
    }

    public City(Integer id, String provinceCode, String code, String name) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", provinceCode='" + provinceCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
