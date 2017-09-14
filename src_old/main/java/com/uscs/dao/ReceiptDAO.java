package com.uscs.dao;

public interface ReceiptDAO {

	
	public boolean checkForReceipt(long recNum,long whseSysId);
	public boolean linkAppointment(long recNum,long apptSysId,long whseSysId);
}
