package com.uscs.model;

public class ReceiptVO {

	public Long recNumber;
	public Long recSysId;
	
	public Long getRecNumber() {
		return recNumber;
	}

	public void setRecNumber(Long recNumber) {
		this.recNumber = recNumber;
	}
	
	public Long getRecSysId(){
		return recSysId;
	}
	
	public void setRecSysId(Long recSysId){
		this.recSysId = recSysId;
	}

	@Override
	public String toString() {
		return "ReceiptVO [recNumber=" + recNumber + ", recSysId=" + recSysId
				+ "]";
	}
	
	
	
	
}
