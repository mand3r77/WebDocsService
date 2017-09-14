package com.uscs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.uscs.model.DocumentVO;

import javax.inject.Inject;
import javax.sql.DataSource;

@Component
public class DocumentStatusDAOImpl implements DoctumentStatusDAO {

	//private static final String DB_NAME = "EWMSMIGDEV";
	//private static final String DB_NAME = "EWMRUATDBF";
	//private static final String DB_NAME = "EWMTSKSIT";
	private static final String DB_NAME = "EWMSTUATDB";
	
	
	private static final String GET_MOCK_APPT_NUMBER  ="SELECT MAX(APPT_NUMBER) AS APPT_NUMBER from "+DB_NAME+".APPT";
	
	private static final String INSERT_APPOINTMENT_HEADER = "INSERT INTO "+DB_NAME+".APPT_HEADER (APPT_NUMBER,APPT_I_O_FLAG,CREATE_TS,CREATE_USERID,UPDATE_TS,UPDATE_USERID)"+
			"VALUES(:apptNumber,:apptFlag,CURRENT TIMESTAMP,'APTAPPUSR',CURRENT TIMESTAMP,'APTAPPUSR')";
	
	private static final String INSERT_APPOINTMENT = "INSERT INTO "+DB_NAME+".APPT (APPT_SYSID,APPT_NUMBER,APPT_TS,WHSE_SYSID,CREATE_TS,CREATE_USERID,UPDATE_TS,UPDATE_USERID,TRAILR_SYSID,DOCK_DOOR_SYSID,APPT_STATUS_SYSID,EQP_NUMBER)"+
		    "VALUES(NEXTVAL FOR "+DB_NAME+".APPT_SEQ,:apptNumber,:apptTS,:whseSysId,CURRENT TIMESTAMP,'APTAPPUSR',CURRENT TIMESTAMP,'APTAPPUSR',:trailerSysId,:doorSysId,1941,:recNum)";
	
	private static final String INSERT_OUTBOUND_APPOINTMENT = "INSERT INTO "+DB_NAME+".APPT (APPT_SYSID,APPT_NUMBER,APPT_TS,WHSE_SYSID,CREATE_TS,CREATE_USERID,UPDATE_TS,UPDATE_USERID,TRAILR_SYSID,DOCK_DOOR_SYSID,APPT_STATUS_SYSID,EQP_NUMBER)"+
		    "VALUES(NEXTVAL FOR "+DB_NAME+".APPT_SEQ,:apptNumber,:apptTS,:whseSysId,CURRENT TIMESTAMP,'APTAPPUSR',CURRENT TIMESTAMP,'APTAPPUSR',:trailerSysId,:doorSysId,1941,:equipNumber)";
		
	private static final String GET_APPT_SYSID = "SELECT APPT_SYSID FROM "+DB_NAME+".APPT WHERE APPT_NUMBER =:apptNumber AND WHSE_SYSID =:whseSysId";

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Inject
	public void setDataSource(DataSource utstdb2) {
	    this.namedJdbcTemplate = new NamedParameterJdbcTemplate(utstdb2);
	}
	public long getMockAppointmentNumber(){
		List<Long> apptNum = new ArrayList<Long>();
		
		try {
			
			apptNum =  namedJdbcTemplate.query(GET_MOCK_APPT_NUMBER, new RowMapper<Long>() {
				
				@Override
				public Long mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					return rs.getLong("APPT_NUMBER");
				}
			});		
		}  catch (DataAccessException exp) {
			String message = exp.getMessage();
			String cause = exp.getCause().toString();
			System.out.println("Message: " + message);
			System.out.println("Cause: " + cause);
			exp.printStackTrace();
			return 0l;
		}
		
		if(apptNum.size() > 0){
			return apptNum.get(0)+1;
		}
		return 0l;
	}
	
	public boolean createInboundAppointment(List<DocumentVO> apptList){
	
	
		Map<String, Object> params = new HashMap<String, Object>();
	/*	params.put("apptNumber", apptList.get(0).getApptNumber());
		params.put("whseSysId", apptList.get(0).getWhseSysId());
		params.put("recNum", apptList.get(0).getRecNum());
		params.put("apptTS", apptList.get(0).getApptTS());
		params.put("trailerSysId", apptList.get(0).getTrailerSysId());
		params.put("equipNumber", apptList.get(0).getTrailerNumber());
		params.put("doorSysId", apptList.get(0).getDoorSysid());*/
			
		try {			
			namedJdbcTemplate.update(INSERT_APPOINTMENT, params);
			
		} catch (DataAccessException exp) {
			String message = exp.getMessage();
			String cause = exp.getCause().toString();
			System.out.println("Message: " + message);
			System.out.println("Cause: " + cause);
			exp.printStackTrace();

			return true;
		}	
		return false;
		
	}
	
	public boolean createOutboundAppointment(List<DocumentVO> apptList){
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		/*params.put("apptNumber", apptList.get(0).getApptNumber());
		params.put("whseSysId", apptList.get(0).getWhseSysId());
		params.put("apptTS", apptList.get(0).getApptTS());
		params.put("trailerSysId", apptList.get(0).getTrailerSysId());
		params.put("equipNumber", apptList.get(0).getTrailerNumber());
		params.put("doorSysId", apptList.get(0).getDoorSysid());*/
		
		
		try {			
			namedJdbcTemplate.update(INSERT_OUTBOUND_APPOINTMENT, params);
			
		} catch (DataAccessException exp) {
			String message = exp.getMessage();
			String cause = exp.getCause().toString();
			System.out.println("Message: " + message);
			System.out.println("Cause: " + cause);
			exp.printStackTrace();
			return true;
		}	
		return false;
		
	}

	@Override
	public Long getLastAppointment(List<DocumentVO> apptList) {
		Map<String, Object> params = new HashMap<String, Object>();
		/*params.put("whseSysId", apptList.get(0).getWhseSysId());
		params.put("apptNumber", apptList.get(0).getApptNumber());*/
		
		List<Long> apptNum = new ArrayList<Long>();
		try {
	
			apptNum =  namedJdbcTemplate.query(GET_APPT_SYSID, params, new RowMapper<Long>() {

				@Override
				public Long mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					return rs.getLong("APPT_SYSID");
				}
			});		
		}  catch (DataAccessException exp) {
			String message = exp.getMessage();
			String cause = exp.getCause().toString();
			System.out.println("Message: " + message);
			System.out.println("Cause: " + cause);
			exp.printStackTrace();
			return 0l;
		}
		
		if(apptNum.size() > 0){
			return apptNum.get(0);
		}
		return 0l;
	}
	@Override
	public Long getLastAppointmentByAppt(DocumentVO appt) {
		Map<String, Object> params = new HashMap<String, Object>();
		/*params.put("whseSysId", appt.getWhseSysId());
		params.put("apptNum", appt.getApptNumber());*/
		
		List<Long> apptNum = new ArrayList<Long>();
		try {
	
			apptNum =  namedJdbcTemplate.query(GET_APPT_SYSID, params, new RowMapper<Long>() {

				@Override
				public Long mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					return rs.getLong("APPT_SYSID");
				}
			});		
		} catch (DataAccessException exp) {
			 String message = exp.getMessage();
				String cause = exp.getMostSpecificCause().toString();
				System.out.println("Message: " + message);
				System.out.println("Cause: " + cause);
				exp.printStackTrace();
			return 0l;
		}
		
		if(apptNum.size() > 0){
			return apptNum.get(0);
		}
		return 0l;
	}
	@Override
	public boolean createAppointmentHeader(long apptNumebr,char apptFlag) {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("apptNumber", apptNumebr);
		params.put("apptFlag", apptFlag);
		
		
		try {			
			namedJdbcTemplate.update(INSERT_APPOINTMENT_HEADER, params);
			
		} catch (DataAccessException exp) {
			 String message = exp.getMessage();
				String cause = exp.getMostSpecificCause().toString();
				System.out.println("Message: " + message);
				System.out.println("Cause: " + cause);
				exp.printStackTrace();
			return true;
		}	
		return false;
		
	}
	
}
