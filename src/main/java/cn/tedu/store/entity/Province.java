package cn.tedu.store.entity;

import java.io.Serializable;

/**
 * @author 张启阳
 * @date 2018/8/30 - 10:42
 */
public class Province implements Serializable {
    private static final long serialVersionUID = -4812307475637481454L;
    private Integer id;
    private String code;
    private String name;

    public Province(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Province() {
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
        return "Province{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
