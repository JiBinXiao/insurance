package com.cr.insurance.common.entity;

import java.util.Date;

public class BaseEntity {
	
	private int id;
	
	private String createby;
	
	private Date createdate;
	
	private String updateby;
	
	private Date updatedate;
	
	private boolean isNewRecord = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public boolean isNewRecord() {
		return isNewRecord;
	}

	public void setNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
	
	public void preinsert() {
		if(isNewRecord) {
			this.createdate=new Date();
			this.updatedate=new Date();
		}else {
			
			this.updatedate=new Date();
		}
	}


	
	
	
	
	
}
