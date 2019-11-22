package com.jk.user.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CmsUser implements Serializable {

    private static final long serialVersionUID = 8511848585157966663L;

    private Integer cmsUserId;
    private String cmsUserPhone;
    private String  cmsUserName;
    private String  cmsUserPwd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmsUserDate;



    public Integer getCmsUserId() {
        return cmsUserId;
    }

    public void setCmsUserId(Integer cmsUserId) {
        this.cmsUserId = cmsUserId;
    }

    public String getCmsUserPhone() {
        return cmsUserPhone;
    }

    public void setCmsUserPhone(String cmsUserPhone) {
        this.cmsUserPhone = cmsUserPhone;
    }

    public String getCmsUserName() {
        return cmsUserName;
    }

    public void setCmsUserName(String cmsUserName) {
        this.cmsUserName = cmsUserName;
    }

    public String getCmsUserPwd() {
        return cmsUserPwd;
    }

    public void setCmsUserPwd(String cmsUserPwd) {
        this.cmsUserPwd = cmsUserPwd;
    }

    public Date getCmsUserDate() {
        return cmsUserDate;
    }

    public void setCmsUserDate(Date cmsUserDate) {
        this.cmsUserDate = cmsUserDate;
    }

    @Override
    public String toString() {
        return "CmsUser{" +
                "cmsUserId=" + cmsUserId +
                ", cmsUserPhone='" + cmsUserPhone + '\'' +
                ", cmsUserName='" + cmsUserName + '\'' +
                ", cmsUserPwd='" + cmsUserPwd + '\'' +
                ", cmsUserDate=" + cmsUserDate +
                '}';
    }
}
