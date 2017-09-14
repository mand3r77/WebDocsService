package com.uscs.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.uscs.dao.WarehouseDAO;
import com.uscs.model.WarehouseVO;

@Service
public class WarehouseServiceImpl implements WarehouseService {
	
	
	@Inject
	WarehouseDAO warehouseDAO;
	
	public List<WarehouseVO> getWarehouseList(){
		return warehouseDAO.getWarehouseList();
		
	}

}
