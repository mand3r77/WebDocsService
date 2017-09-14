package com.uscs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uscs.dao.AppointmentDAO;
import com.uscs.model.AppointmentVO;

@Service
public class AppointmentServiceImpl implements AppointmentService {


	
	@Inject
	AppointmentDAO appointmentDAO;
	
	public List<AppointmentVO> createAppointment(List<AppointmentVO> apptList){
		boolean saveHadErrors = appointmentDAO.createAppointment(apptList);
		
		if(!saveHadErrors){
			apptList.get(0).setApptSysId(appointmentDAO.getLastAppointmentByRec(apptList));
			return apptList;
		}
		
		apptList.get(0).setSaveError(true);
		return apptList;
	}
	
	public long getAppointment(AppointmentVO appt){
		
			return appointmentDAO.getLastAppointmentByAppt(appt);
	}
}
