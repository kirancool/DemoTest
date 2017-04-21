package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SubmitDao {
	public void submit(String company,String stock_price_open,String stock_price_high,String stock_price_low) throws SQLException;

}
