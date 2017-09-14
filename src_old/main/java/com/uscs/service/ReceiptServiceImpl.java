package com.uscs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uscs.dao.ReceiptDAO;
import com.uscs.model.AppointmentVO;
import com.uscs.model.ReceiptVO;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Inject
	ReceiptDAO receiptDAO;
	
	public boolean receiptExsists (List<ReceiptVO> recList,long whseSysId){
		
		for (ReceiptVO recNum:recList){
			boolean hasRec = receiptDAO.checkForReceipt(recNum.getRecNumber(), whseSysId);
			if (!hasRec){
				return false;
			}
		}
		
		return true;
	}
	
	
	@Override
	public boolean linkAppointment(List<ReceiptVO> recList, long apptSysId,long whseSysId) {

		
		for(ReceiptVO rec : recList){
			try {
				receiptDAO.linkAppointment(rec.getRecNumber(),apptSysId,whseSysId);
			} catch (DataAccessException exp) {
				return true;
			}	
		}
		return false;
	}

	
	
}
