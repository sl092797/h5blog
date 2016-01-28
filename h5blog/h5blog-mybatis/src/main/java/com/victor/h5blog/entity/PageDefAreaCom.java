package com.victor.h5blog.entity;

import java.util.Date;

public class PageDefAreaCom {
    private Long defAreaComId;

    private Long tplAreaId;

    private Long defId;

    private Long comDefId;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;
    
    public Long getDefAreaComId() {
        return defAreaComId;
    }

    public void setDefAreaComId(Long defAreaComId) {
        this.defAreaComId = defAreaComId;
    }

    public Long getTplAreaId() {
        return tplAreaId;
    }

    public void setTplAreaId(Long tplAreaId) {
        this.tplAreaId = tplAreaId;
    }

    public Long getDefId() {
        return defId;
    }

    public void setDefId(Long defId) {
        this.defId = defId;
    }

    public Long getComDefId() {
        return comDefId;
    }

    public void setComDefId(Long comDefId) {
        this.comDefId = comDefId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser == null ? null : changeUser.trim();
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}