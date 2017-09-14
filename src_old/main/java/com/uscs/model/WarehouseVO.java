package com.uscs.model;

public class WarehouseVO {
	
	private Long whseSysId;
	private String whseName;
	public Long getWhseSysId() {
		return whseSysId;
	}
	public void setWhseSysId(Long whseSysId) {
		this.whseSysId = whseSysId;
	}
	public String getWhseName() {
		return whseName;
	}
	public void setWhseName(String whseName) {
		this.whseName = whseName;
	}
	@Override
	public String toString() {
		return "WarehouseVO [whseSysId=" + whseSysId + ", whseName=" + whseName
				+ "]";
	}
	
	

}
