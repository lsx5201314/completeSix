package com.jk.comd.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Adv
 * @Deacription TODO
 * @Author 原国庆
 * @Date 2019/11/21 10:25
 * @Version 1.0
 **/
public class Adv implements Serializable {
    private static final long serialVersionUID = 8665772060199167950L;

    private  int advid;
    private String advname;
    private String advimg;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date advdate;
    private String advinfo;
    private String advurl;

    public int getAdvid() {
        return advid;
    }

    public void setAdvid(int advid) {
        this.advid = advid;
    }

    public String getAdvname() {
        return advname;
    }

    public void setAdvname(String advname) {
        this.advname = advname;
    }

    public String getAdvimg() {
        return advimg;
    }

    public void setAdvimg(String advimg) {
        this.advimg = advimg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAdvdate() {
        return advdate;
    }

    public void setAdvdate(Date advdate) {
        this.advdate = advdate;
    }

    public String getAdvinfo() {
        return advinfo;
    }

    public void setAdvinfo(String advinfo) {
        this.advinfo = advinfo;
    }

    public String getAdvurl() {
        return advurl;
    }

    public void setAdvurl(String advurl) {
        this.advurl = advurl;
    }

    @Override
    public String toString() {
        return "Adv{" +
                "advid=" + advid +
                ", advname='" + advname + '\'' +
                ", advimg='" + advimg + '\'' +
                ", status='" + status + '\'' +
                ", advdate=" + advdate +
                ", advinfo='" + advinfo + '\'' +
                ", advurl='" + advurl + '\'' +
                '}';
    }
}
