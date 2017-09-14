package com.uscs.dao;

import java.util.List;

import com.uscs.model.DocumentVO;

public interface DoctumentStatusDAO {

	public long getMockAppointmentNumber();
	
	public boolean createAppointmentHeader(long apptNumebr,char apptFlag);
	
	public boolean createInboundAppointment(List<DocumentVO> apptList);
	
	public boolean createOutboundAppointment(List<DocumentVO> apptList);
	
	public Long getLastAppointment(List<DocumentVO> apptList);

	public Long getLastAppointmentByAppt(DocumentVO appt);
}
