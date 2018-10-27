package cn.tedu.store.entity;

import java.io.Serializable;

/**
 * @author 张启阳
 * @date 2018/8/30 - 10:44
 */
public class Area implements Serializable {
    private static final long serialVersionUID = 5339408959426848825L;
    private Integer id;
    private String cityCode;
    private String code;
    private String name;

    public Area() {
    }

    public Area(Integer id, String cityCode, String code, String name) {
        this.id = id;
        this.cityCode = cityCode;
        this.code = code;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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
        return "Area{" +
                "id=" + id +
                ", cityCode='" + cityCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
