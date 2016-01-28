package com.victor.h5blog.entity;

import java.util.Date;

public class PageTemplateArea {
    private Long pgTplArea;

    private String areaName;

    private Long pgTplId;

    private String createUser;

    private Date createDate;

    private String changeUser;

    private Date changeDate;
    
    private Long comDefId;
    
    private String comName;
    
    private String comDesc;
    
    private String ftlPath;

    public Long getPgTplArea() {
        return pgTplArea;
    }

    public void setPgTplArea(Long pgTplArea) {
        this.pgTplArea = pgTplArea;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Long getPgTplId() {
        return pgTplId;
    }

    public void setPgTplId(Long pgTplId) {
        this.pgTplId = pgTplId;
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

	public Long getComDefId() {
		return comDefId;
	}

	public void setComDefId(Long comDefId) {
		this.comDefId = comDefId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComDesc() {
		return comDesc;
	}

	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}

	public String getFtlPath() {
		return ftlPath;
	}

	public void setFtlPath(String ftlPath) {
		this.ftlPath = ftlPath;
	}
}