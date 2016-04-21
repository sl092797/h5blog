package com.victor.h5blog.entity;

import java.util.Date;

public class Video {
    private Long videoId;

    private String videoName;

    private String videoDesc;

    private String videoTag;

    private String videoPosterpath;

    private String videoOriginalpath;

    private String videoCompressedpath;

    private Long catlogId;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }

    public String getVideoTag() {
        return videoTag;
    }

    public void setVideoTag(String videoTag) {
        this.videoTag = videoTag == null ? null : videoTag.trim();
    }

    public String getVideoPosterpath() {
        return videoPosterpath;
    }

    public void setVideoPosterpath(String videoPosterpath) {
        this.videoPosterpath = videoPosterpath == null ? null : videoPosterpath.trim();
    }

    public String getVideoOriginalpath() {
        return videoOriginalpath;
    }

    public void setVideoOriginalpath(String videoOriginalpath) {
        this.videoOriginalpath = videoOriginalpath == null ? null : videoOriginalpath.trim();
    }

    public String getVideoCompressedpath() {
        return videoCompressedpath;
    }

    public void setVideoCompressedpath(String videoCompressedpath) {
        this.videoCompressedpath = videoCompressedpath == null ? null : videoCompressedpath.trim();
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