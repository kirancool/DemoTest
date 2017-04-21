package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StockLowDao {

	List<Map<String, Object>> getAllStockPriceLow(String companyname)throws SQLException;

}
