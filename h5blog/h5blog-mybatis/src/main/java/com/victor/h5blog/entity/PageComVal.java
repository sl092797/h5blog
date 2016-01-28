package com.victor.h5blog.entity;

import java.util.Date;

public class PageComVal {
    private Long id;

    private Long pgComDefId;

    private Long pgComVarId;

    private String pgComCode;

    private String pgComValue;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPgComDefId() {
        return pgComDefId;
    }

    public void setPgComDefId(Long pgComDefId) {
        this.pgComDefId = pgComDefId;
    }

    public Long getPgComVarId() {
        return pgComVarId;
    }

    public void setPgComVarId(Long pgComVarId) {
        this.pgComVarId = pgComVarId;
    }

    public String getPgComCode() {
        return pgComCode;
    }

    public void setPgComCode(String pgComCode) {
        this.pgComCode = pgComCode == null ? null : pgComCode.trim();
    }

    public String getPgComValue() {
        return pgComValue;
    }

    public void setPgComValue(String pgComValue) {
        this.pgComValue = pgComValue == null ? null : pgComValue.trim();
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