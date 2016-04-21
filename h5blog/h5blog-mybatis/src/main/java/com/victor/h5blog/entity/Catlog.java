package com.victor.h5blog.entity;

import java.util.Date;

public class Catlog {
    private Long catlogId;

    private Long catlogFatherId;

    private String catlogKey;

    private String catlogName;

    private String catlogDesc;

    private Long catlogCoverid;

    private Byte catlogPrivacy;

    private Byte catlogLevel;

    private String catlogTag;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;

    public Long getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(Long catlogId) {
        this.catlogId = catlogId;
    }

    public Long getCatlogFatherId() {
        return catlogFatherId;
    }

    public void setCatlogFatherId(Long catlogFatherId) {
        this.catlogFatherId = catlogFatherId;
    }

    public String getCatlogKey() {
        return catlogKey;
    }

    public void setCatlogKey(String catlogKey) {
        this.catlogKey = catlogKey == null ? null : catlogKey.trim();
    }

    public String getCatlogName() {
        return catlogName;
    }

    public void setCatlogName(String catlogName) {
        this.catlogName = catlogName == null ? null : catlogName.trim();
    }

    public String getCatlogDesc() {
        return catlogDesc;
    }

    public void setCatlogDesc(String catlogDesc) {
        this.catlogDesc = catlogDesc == null ? null : catlogDesc.trim();
    }

    public Long getCatlogCoverid() {
        return catlogCoverid;
    }

    public void setCatlogCoverid(Long catlogCoverid) {
        this.catlogCoverid = catlogCoverid;
    }

    public Byte getCatlogPrivacy() {
        return catlogPrivacy;
    }

    public void setCatlogPrivacy(Byte catlogPrivacy) {
        this.catlogPrivacy = catlogPrivacy;
    }

    public Byte getCatlogLevel() {
        return catlogLevel;
    }

    public void setCatlogLevel(Byte catlogLevel) {
        this.catlogLevel = catlogLevel;
    }

    public String getCatlogTag() {
        return catlogTag;
    }

    public void setCatlogTag(String catlogTag) {
        this.catlogTag = catlogTag == null ? null : catlogTag.trim();
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