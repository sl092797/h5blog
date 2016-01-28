package com.victor.h5blog.entity;

import java.util.Date;

public class PageComDef {
    private Long id;

    private Long pgComId;
    
    private String desc;

    private Integer aval;
    
    private Long catlogId;

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

    public Long getPgComId() {
        return pgComId;
    }

    public void setPgComId(Long pgComId) {
        this.pgComId = pgComId;
    }

    public Integer getAval() {
        return aval;
    }

    public void setAval(Integer aval) {
        this.aval = aval;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getCatlogId() {
		return catlogId;
	}

	public void setCatlogId(Long catlogId) {
		this.catlogId = catlogId;
	}
}