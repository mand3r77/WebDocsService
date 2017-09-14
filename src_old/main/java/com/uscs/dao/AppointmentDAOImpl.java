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

import com.uscs.model.AppointmentVO;

import javax.inject.Inject;
import javax.sql.DataSource;

@Component
public class AppointmentDAOImpl implements AppointmentDAO {
	
	
	private static final String INSERT_APPOINTMENT = "INSERT INTO EWMSF1DBF.APPT (APPT_SYSID,APPT_NUMBER,WHSE_SYSID,CREATE_TS,CREATE_USERID,UPDATE_TS,UPDATE_USERID,EQP_NUMBER)"+
		    "VALUES(NEXTVAL FOR EWMSF1DBF.APPT_SEQ,(SELECT MAX(APPT_NUMBER)+1 from EWMSF1DBF.APPT),:whseSysId,CURRENT TIMESTAMP,'APTAPPUSR',CURRENT TIMESTAMP,'APTAPPUSR',:recNum)";
	
	private static final String GET_APPT_SYSID_BY_REC = "SELECT APPT_SYSID FROM EWMSF1DBF.APPT WHERE EQP_NUMBER =:recNum AND WHSE_SYSID =:whseSysId";
	
	private static final String GET_APPT_SYSID_BY_APPT = "SELECT APPT_SYSID FROM EWMSF1DBF.APPT WHERE APPT_NUMBER =:apptNum AND WHSE_SYSID =:whseSysId";
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Inject
	public void setDataSource(DataSource uatDataSource) {
	    this.namedJdbcTemplate = new NamedParameterJdbcTemplate(uatDataSource);
	}
	
	
	public boolean createAppointment(List<AppointmentVO> apptList){
	
	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("whseSysId", apptList.get(0).getWhseSysId());
		params.put("recNum", apptList.get(0).getRecNum());
		
		try {			
			namedJdbcTemplate.update(INSERT_APPOINTMENT, params);
			
		} catch (DataAccessException exp) {
			return true;
		}	
		return false;
		
	}


	@Override
	public Long getLastAppointmentByRec(List<AppointmentVO> apptList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("whseSysId", apptList.get(0).getWhseSysId());
		params.put("recNum", apptList.get(0).getRecNum().toString());
		
		List<Long> apptNum = new ArrayList<Long>();
		try {
	
			apptNum =  namedJdbcTemplate.query(GET_APPT_SYSID_BY_REC, params, new RowMapper<Long>() {

				@Override
				public Long mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					return rs.getLong("APPT_SYSID");
				}
			});		
		}  catch (DataAccessException exp) {
			return 0l;
		}
		
		if(apptNum.size() > 0){
			return apptNum.get(0);
		}
		return 0l;
	}
	@Override
	public Long getLastAppointmentByAppt(AppointmentVO appt) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("whseSysId", appt.getWhseSysId());
		params.put("apptNum", appt.getApptNumber());
		
		List<Long> apptNum = new ArrayList<Long>();
		try {
	
			apptNum =  namedJdbcTemplate.query(GET_APPT_SYSID_BY_APPT, params, new RowMapper<Long>() {

				@Override
				public Long mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					return rs.getLong("APPT_SYSID");
				}
			});		
		} catch (DataAccessException exp) {
			return 0l;
		}
		
		if(apptNum.size() > 0){
			return apptNum.get(0);
		}
		return 0l;
	}
}
