package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张启阳
 * @date 2018/9/7 - 16:53
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 5422086414432967068L;
    private Integer id;
    private Integer uid;
    private Long goodsId;
    private Integer num;
    private String goodsImage;
    private String goodsTitle;
    private Long goodsPrice;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

    public Cart() {
    }

    public Cart(Integer id, Integer uid, Long goodsId, Integer num, String goodsImage, String goodsTitle, Long goodsPrice, Date createdTime, Date modifiedTime, String createdUser, String modifiedUser) {
        this.id = id;
        this.uid = uid;
        this.goodsId = goodsId;
        this.num = num;
        this.goodsImage = goodsImage;
        this.goodsTitle = goodsTitle;
        this.goodsPrice = goodsPrice;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.createdUser = createdUser;
        this.modifiedUser = modifiedUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid=" + uid +
                ", goodsId=" + goodsId +
                ", num=" + num +
                ", goodsImage='" + goodsImage + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                '}';
    }
}
