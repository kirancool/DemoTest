package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StockAllPriceDao {
	public List<Map<String, Object>> getAllPrice() throws SQLException;

}
