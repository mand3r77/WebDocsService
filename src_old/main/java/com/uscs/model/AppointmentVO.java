package com.uscs.model;

import java.util.Date;

public class AppointmentVO {
	
	public Long apptSysId;
	public Long apptNumber;
	public Long whseSysId;
	public Long recNum;
	public Date createTs;
	public Date updateTs;
	public String createUser;
	public String updateUser;
	public boolean saveError;
	public Long getApptSysId() {
		return apptSysId;
	}
	public void setApptSysId(Long apptSysId) {
		this.apptSysId = apptSysId;
	}
	public Long getApptNumber() {
		return apptNumber;
	}
	public void setApptNumber(Long apptNumber) {
		this.apptNumber = apptNumber;
	}
	public Long getWhseSysId() {
		return whseSysId;
	}
	public void setWhseSysId(Long whseSysId) {
		this.whseSysId = whseSysId;
	}
	public Long getRecNum() {
		return recNum;
	}
	public void setRecNum(Long recNum) {
		this.recNum = recNum;
	}
	public Date getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	public Date getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public boolean isSaveError() {
		return saveError;
	}
	public void setSaveError(boolean saveError) {
		this.saveError = saveError;
	}
	@Override
	public String toString() {
		return "AppointmentVO [apptSysId=" + apptSysId + ", apptNumber="
				+ apptNumber + ", whseSysId=" + whseSysId + ", recNum="
				+ recNum + ", createTs=" + createTs + ", updateTs=" + updateTs
				+ ", createUser=" + createUser + ", updateUser=" + updateUser
				+ ", saveError=" + saveError + "]";
	}
	
	
	
	
	
}
