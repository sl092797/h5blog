package com.victor.h5blog.entity;

import java.util.Date;

public class Photo {
    private Long photoId;

    private String photoName;

    private String photoDesc;

    private String photoPath;

    private String photoTag;

    private Long catlogId;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc == null ? null : photoDesc.trim();
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public String getPhotoTag() {
        return photoTag;
    }

    public void setPhotoTag(String photoTag) {
        this.photoTag = photoTag == null ? null : photoTag.trim();
    }

    public Long getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(Long catlogId) {
        this.catlogId = catlogId;
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