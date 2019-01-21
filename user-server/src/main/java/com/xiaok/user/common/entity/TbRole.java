package com.xiaok.user.common.entity;

import java.util.Date;

public class TbRole {
    private String id;

    private String name;

    private String rlExplain;

    private String rlType;

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

    public String getRlExplain() {
        return rlExplain;
    }

    public void setRlExplain(String rlExplain) {
        this.rlExplain = rlExplain;
    }

    public String getRlType() {
        return rlType;
    }

    public void setRlType(String rlType) {
        this.rlType = rlType;
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