package com.cr.insurance.common.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.cr.insurance.user.entity.User;

public class BaseEntity {
	
	private int id;
	
	private String createby;
	
	private java.sql.Timestamp createdate;
	
	private String updateby;
	
	private java.sql.Timestamp updatedate;
	
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

	
	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}



	public java.sql.Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.sql.Timestamp createdate) {
		this.createdate = createdate;
	}

	public java.sql.Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(java.sql.Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public boolean isNewRecord() {
		return isNewRecord;
	}

	public void setNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
	
	public void preinsert(User user) {
		if(isNewRecord) {
			this.createby = user.getRealname();
			this.updateby = user.getRealname();
			this.createdate= new Timestamp(System.currentTimeMillis()); 
			this.updatedate=new Timestamp(System.currentTimeMillis()); 
		}else {
			this.updateby = user.getRealname();
			this.updatedate=new Timestamp(System.currentTimeMillis()); 
		}
	}
	
	public void preinsert() {
		if(isNewRecord) {
		
			this.createdate=new Timestamp(System.currentTimeMillis()); 
			this.updatedate=new Timestamp(System.currentTimeMillis()); 
		}else {
			
			this.updatedate=new Timestamp(System.currentTimeMillis()); 
		}
	}


	
	
	
	
	
}
