package com.uscs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.uscs.model.WarehouseVO;

@Component
public class WarehouseDAOImpl implements WarehouseDAO {


	private static final String WAREHOUSE_QRY = "SELECT WHSE_SYSID,WHSE_NAME  FROM EWMSF1DBF.WHSE";
	
	//Instance of the NamedParameterJdbcTemplate
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	//Injection of the data source 
	@Inject
	public void setDataSource(DataSource uatDataSource) {
	    this.namedJdbcTemplate = new NamedParameterJdbcTemplate(uatDataSource);
	}
	
	//Returns current warehouse list from the WHSE Table.
	public List<WarehouseVO> getWarehouseList() {
		List<WarehouseVO> warehouseList =  new ArrayList<WarehouseVO>();
		
		try {
			warehouseList = namedJdbcTemplate.query(WAREHOUSE_QRY, new RowMapper<WarehouseVO>() {

				@Override
				public WarehouseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					WarehouseVO warehouseVO = new WarehouseVO();
					
					warehouseVO.setWhseName(rs.getString("WHSE_NAME"));
					warehouseVO.setWhseSysId(rs.getLong("WHSE_SYSID"));
					
					
					return warehouseVO;
				}
			});
		} catch (DataAccessException exp) {
			//:TODO create error handling
		}
		
		return warehouseList;
	}

}
