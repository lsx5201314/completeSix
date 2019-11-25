package com.jk.utils;

import java.io.Serializable;

/**
 * @ClassName QueryParam
 * @Deacription TODO
 * @Author liushuxin
 * @Date 2019/11/25 14:35
 * @Version 1.0
 **/
public class QueryParam implements Serializable {
    private static final long serialVersionUID = 5589608311295820410L;
    private String flag;
    private Integer bigTypeId;
    private String bigTypeName;
    private Integer smallTypeid;
    private String smalltypename;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getBigTypeId() {
        return bigTypeId;
    }

    public void setBigTypeId(Integer bigTypeId) {
        this.bigTypeId = bigTypeId;
    }

    public String getBigTypeName() {
        return bigTypeName;
    }

    public void setBigTypeName(String bigTypeName) {
        this.bigTypeName = bigTypeName;
    }

    public Integer getSmallTypeid() {
        return smallTypeid;
    }

    public void setSmallTypeid(Integer smallTypeid) {
        this.smallTypeid = smallTypeid;
    }

    public String getSmalltypename() {
        return smalltypename;
    }

    public void setSmalltypename(String smalltypename) {
        this.smalltypename = smalltypename;
    }
}
