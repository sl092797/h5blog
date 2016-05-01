package com.victor.h5blog.entity;

import java.util.Date;

public class Blog {
    private Long blogId;

    private String blogName;

    private String blogDesc;

    private String blogTag;

    private Byte blogCheck;

    private Byte blogStatus;

    private Long catlogId;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;

    private String blogContent;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName == null ? null : blogName.trim();
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc == null ? null : blogDesc.trim();
    }

    public String getBlogTag() {
        return blogTag;
    }

    public void setBlogTag(String blogTag) {
        this.blogTag = blogTag == null ? null : blogTag.trim();
    }

    public Byte getBlogCheck() {
        return blogCheck;
    }

    public void setBlogCheck(Byte blogCheck) {
        this.blogCheck = blogCheck;
    }

    public Byte getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Byte blogStatus) {
        this.blogStatus = blogStatus;
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

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}