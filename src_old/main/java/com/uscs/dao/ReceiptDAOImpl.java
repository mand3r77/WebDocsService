package com.uscs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.uscs.model.ReceiptVO;



@Component
public class ReceiptDAOImpl implements ReceiptDAO {

	private static final String LINK_APPT = "UPDATE EWMSF1DBF.REC SET APPT_SYSID =:apptSysId WHERE REC_NUMBER =:recNum AND WHSE_SYSID =:whseSysId";
	private static final String CHECK_REC= "SELECT REC_NUMBER_SYSID FROM EWMSF1DBF.REC WHERE REC_NUMBER =:recNum AND WHSE_SYSID =:whseSysId ";	
	
	//Instance of the NamedParameterJdbcTemplate
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	//Injection of the data source 
	@Inject
	public void setDataSource(DataSource uatDataSource) {
	    this.namedJdbcTemplate = new NamedParameterJdbcTemplate(uatDataSource);
	}
	
	
	public boolean linkAppointment(long recNum,long apptSysId,long whseSysId) {
		
		Map<String, Long> parms = new HashMap<String, Long>();
		parms.put("apptSysId", apptSysId);
		parms.put("whseSysId", whseSysId);
		parms.put("recNum",recNum);
		
		try {
			
			namedJdbcTemplate.update(LINK_APPT, parms);
			
		} catch (Exception e) {
			return true;
		}
		
		return false;
	}


	@Override
	public boolean checkForReceipt(long recNum,long whseSysId) {
		
		List<ReceiptVO> receipts = new ArrayList<ReceiptVO>();
		
		
		Map<String, Long> parms = new HashMap<String, Long>();
		
		parms.put("whseSysId", whseSysId);
		parms.put("recNum",recNum);
		
		try {
			
			receipts = namedJdbcTemplate.query(CHECK_REC, parms, new RowMapper<ReceiptVO>() {

				@Override
				public ReceiptVO mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ReceiptVO receiptVO = new ReceiptVO();
					receiptVO.recSysId = rs.getLong("REC_NUMBER_SYSID");
					return receiptVO;
				}
			});
			
		} catch (Exception exp) {
			return false;
		}
		
		if (receipts.size() > 0){
			return true;
		}
		return false;
	}

}
