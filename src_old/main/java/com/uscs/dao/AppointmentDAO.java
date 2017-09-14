package com.uscs.dao;

import java.util.List;

import com.uscs.model.AppointmentVO;

public interface AppointmentDAO {

	public boolean createAppointment(List<AppointmentVO> apptList);
	
	public Long getLastAppointmentByRec(List<AppointmentVO> apptList);
	
	public Long getLastAppointmentByAppt(AppointmentVO appt);
}
