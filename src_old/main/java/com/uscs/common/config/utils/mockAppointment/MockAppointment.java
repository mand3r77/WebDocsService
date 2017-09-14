package com.uscs.common.config.utils.mockAppointment;

import java.util.ArrayList;
import java.util.List;

import com.uscs.model.AppointmentVO;
import com.uscs.model.ReceiptVO;

public class MockAppointment {

	private final static String USER = "APTAPPUSR";
	
	public List<AppointmentVO> createMockAppointment(Long whseSysId,List<ReceiptVO> recNum){
		List<AppointmentVO> apptList = new ArrayList<AppointmentVO>();
		
		for(ReceiptVO reciept :recNum){
			
			AppointmentVO appointmentVO = new AppointmentVO();
			
			appointmentVO.setRecNum(reciept.getRecNumber());
			appointmentVO.setWhseSysId(whseSysId);
			appointmentVO.setCreateUser(USER);
			appointmentVO.setUpdateUser(USER);
			
			apptList.add(appointmentVO);
		}
		
	
		return apptList;
	}
}
