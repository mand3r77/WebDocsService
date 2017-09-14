package com.uscs.dao;

import java.util.List;

import com.uscs.model.WarehouseVO;

public interface WarehouseDAO {

	//Returns current warehouse list from the WHSE Table.
	public List<WarehouseVO> getWarehouseList();
}
