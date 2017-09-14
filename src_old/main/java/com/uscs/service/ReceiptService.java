package com.uscs.service;

import java.util.List;

import com.uscs.model.ReceiptVO;

public interface ReceiptService {

	
	public boolean receiptExsists (List<ReceiptVO> recList,long whseSysId);
	
	public boolean linkAppointment(List<ReceiptVO> recList, long apptSysId,long whseSysId);
}
