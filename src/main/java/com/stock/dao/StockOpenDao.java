package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StockOpenDao {
	public List<Map<String, Object>> getAllStockPriceOpen(String companyname) throws SQLException;

}
