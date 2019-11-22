package com.jk.comd.model;

import java.io.Serializable;

/**
 * @ClassName Comment
 * @Deacription TODO
 * @Author 原国庆
 * @Date 2019/11/20 21:16
 * @Version 1.0
 **/
public class Comment implements Serializable {
    private static final long serialVersionUID = -6857354132092080993L;

    private int id;
    private int productId;
    private  int badCom;
    private int goodCom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBadCom() {
        return badCom;
    }

    public void setBadCom(int badCom) {
        this.badCom = badCom;
    }

    public int getGoodCom() {
        return goodCom;
    }

    public void setGoodCom(int goodCom) {
        this.goodCom = goodCom;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", productId=" + productId +
                ", badCom=" + badCom +
                ", goodCom=" + goodCom +
                '}';
    }
}
