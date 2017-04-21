package com.stock.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stock.bean.Login;
import com.stock.bean.StockBean;
import com.stock.bean.StockPriceHigh;
import com.stock.bean.StockPriceLow;



public interface StockService {

	
		public List<Map<String, Object>> getStockPriceOpen() throws SQLException ;

		//public List<StockPriceHigh> getStockPriceHigh() throws SQLException;
		public List<Map<String, Object>> getStockPriceHigh() throws SQLException ;
		//public List<StockPriceLow> getStockPriceLow() throws SQLException; 
		public List<Map<String, Object>> getStockPriceLow() throws SQLException ;

		/*public List<Login> getLogin() throws SQLException;*/
		public boolean getLogin(String username, String password) throws SQLException;
		public List<Map<String, Object>> getTableData() throws SQLException;

		public List<Map<String, Object>> getAllDate(String companyname) throws SQLException;

		public List<Map<String, Object>> getAllCompany() throws SQLException;

		public List<Map<String, Object>> getAllStockPriceOpen(String companyname) throws SQLException;

		public List<Map<String, Object>> getAllStockPriceHigh(String companyname) throws SQLException;

		public List<Map<String, Object>> getAllStockPriceLow(String companyname) throws SQLException;

		public void submit(String companyname,String stock_price_open,String stock_price_high,String stock_price_low) throws SQLException;

		public List<Map<String, Object>> getAllPrice() throws SQLException;

	public String createAndLoad(String path, String csvFileName) throws SQLException;

	

		

}
