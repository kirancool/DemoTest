package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stock.bean.StockBean;
import com.stock.bean.StockPriceLow;

public interface StockPriceLowDao {
	//List<StockPriceLow> getStockPriceLow() throws SQLException;
	public List<Map<String, Object>> getStockPriceLow() throws SQLException;

}
