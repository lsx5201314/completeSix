package com.jk.collect.model;

import java.io.Serializable;

/**
 * @ClassName Collect
 * @Description
 * @Author
 * @Date 2019/11/22 10:47
 * @Version V1.0
 **/
public class Collect implements Serializable {
    private static final long serialVersionUID = 3169502929875890736L;

    private Integer id;
    private Integer commodityId;
    private Integer userId;

    private String productName;
    private Integer productPrice;
    private String colorImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getColorImg() {
        return colorImg;
    }

    public void setColorImg(String colorImg) {
        this.colorImg = colorImg;
    }
}
