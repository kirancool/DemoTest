package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stock.bean.StockBean;



public interface StockPriceDao {
	public List<Map<String, Object>> getStockPriceOpen() throws SQLException;



	

}
