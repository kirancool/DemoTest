package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stock.bean.StockPriceHigh;

public interface StockPriceHighDao {

	 //List<StockPriceHigh> getStockPriceHigh() throws SQLException;
	public List<Map<String, Object>> getStockPriceHigh() throws SQLException;

}
