package com.uscs.service;

import java.util.List;

import com.uscs.model.AppointmentVO;

public interface AppointmentService {

	
	public List<AppointmentVO> createAppointment(List<AppointmentVO> apptList);
	
	public long getAppointment(AppointmentVO appt);
}
