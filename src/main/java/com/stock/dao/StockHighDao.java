package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StockHighDao {

	List<Map<String, Object>> getAllStockPriceHigh(String companyname) throws SQLException;

}
