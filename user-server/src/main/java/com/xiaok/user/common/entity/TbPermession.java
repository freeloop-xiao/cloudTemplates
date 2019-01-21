package com.xiaok.user.common.entity;

import java.util.Date;

public class TbPermession {
    private String id;

    private String name;

    private String pmType;

    private String pmResource;

    private String pmExplain;

    private String appId;

    private String appType;

    private Date createTime;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPmType() {
        return pmType;
    }

    public void setPmType(String pmType) {
        this.pmType = pmType;
    }

    public String getPmResource() {
        return pmResource;
    }

    public void setPmResource(String pmResource) {
        this.pmResource = pmResource;
    }

    public String getPmExplain() {
        return pmExplain;
    }

    public void setPmExplain(String pmExplain) {
        this.pmExplain = pmExplain;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}