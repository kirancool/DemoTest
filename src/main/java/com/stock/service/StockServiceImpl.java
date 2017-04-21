package com.stock.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.CompanyDataDao;
import com.stock.dao.DateDataDao;
import com.stock.dao.LoginDao;
import com.stock.dao.StockAllPriceDao;
import com.stock.dao.StockHighDao;
import com.stock.dao.StockLowDao;
import com.stock.dao.StockOpenDao;
import com.stock.dao.StockPriceDao;
import com.stock.dao.StockPriceHighDao;
import com.stock.dao.StockPriceLowDao;
import com.stock.dao.SubmitDao;
import com.stock.dao.TableDataDao;

import scala.collection.Seq;
@Service("stockService")
public class StockServiceImpl implements StockService{

	@Autowired
	private StockPriceDao stockPriceDao;
	@Autowired
	private StockPriceHighDao stockPriceHighDao;
	@Autowired
	private StockPriceLowDao stockPriceLowDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private TableDataDao tabledataDao;
	@Autowired
	private DateDataDao datedataDao;
	@Autowired
	private CompanyDataDao companydataDao;
	@Autowired
	private StockOpenDao stockopendataDao;
	@Autowired
	private StockHighDao stockhighdataDao;
	@Autowired
	private StockLowDao stocklowdataDao;
	@Autowired
	StockAllPriceDao stockallpriceDao;
	@Autowired
	private SubmitDao submitDao;
	@Autowired
	private HiveContext hiveContext;
	
	
	public List<Map<String, Object>> getStockPriceOpen() throws SQLException {
		 
		List<Map<String, Object>> sb = stockPriceDao.getStockPriceOpen();
			  return sb;
		
	}
/*public List<StockPriceHigh> getStockPriceHigh() throws SQLException {
		List<StockPriceHigh> sb1 = stockPriceHighDao.getStockPriceHigh();
		return sb1;
	}*/

	public List<Map<String, Object>> getStockPriceHigh() throws SQLException {
		 
		List<Map<String, Object>> sb1 = stockPriceHighDao.getStockPriceHigh();
			  return sb1;
		
	}
	
	/*public List<StockPriceLow> getStockPriceLow() throws SQLException {
		List<StockPriceLow> sb2 = stockPriceLowDao.getStockPriceLow();
		return sb2;
	}
*/
	public List<Map<String, Object>> getStockPriceLow() throws SQLException {
		 
		List<Map<String, Object>> sb2 = stockPriceLowDao.getStockPriceLow();
			  return sb2;
	
	}
public boolean getLogin(String username ,String password) throws SQLException {
		boolean sb2 = loginDao.getLogin(username,password);
		return sb2;
	}

	@Override
	public List<Map<String, Object>> getTableData() throws SQLException {
		List<Map<String, Object>> sb3= tabledataDao.getTableData();
		  return sb3;
	}
/*@Override
public boolean getLogin(String username, String password) throws SQLException {
	boolean sb2 = loginDao.getLogin(username,password);
	return sb2;
}*/

	@Override
	public List<Map<String, Object>> getAllDate(String companyname) throws SQLException {
		List<Map<String, Object>> sb4= datedataDao.getAllDate(companyname);
		return sb4;
	}

	@Override
	public List<Map<String, Object>> getAllCompany() throws SQLException {
		List<Map<String, Object>> sb5= companydataDao.getAllCompany();
		return sb5;
	}

	@Override
	public List<Map<String, Object>> getAllStockPriceOpen(String companyname) throws SQLException {
		List<Map<String, Object>> sb6= stockopendataDao.getAllStockPriceOpen(companyname);
		return sb6;
	}

	@Override
	public List<Map<String, Object>> getAllStockPriceHigh(String companyname) throws SQLException {
		List<Map<String, Object>> sb7= stockhighdataDao.getAllStockPriceHigh(companyname);
		return sb7;
	}

	@Override
	public List<Map<String, Object>> getAllStockPriceLow(String companyname) throws SQLException {
		List<Map<String, Object>> sb8= stocklowdataDao.getAllStockPriceLow(companyname);
		return sb8;
	}

	@Override
	public void submit(String company,String stock_price_open,String stock_price_high,String stock_price_low) throws SQLException {
		 submitDao.submit(company,stock_price_open,stock_price_high,stock_price_low);
		 }

	@Override
	public List<Map<String, Object>> getAllPrice() throws SQLException {
		List<Map<String, Object>> sb9= stockallpriceDao.getAllPrice();
		return sb9;
	} 

@Override
	public String createAndLoad(String path,String csvFileName) throws SQLException {
		Dataset<Row> df = hiveContext.read().format("com.databricks.spark.csv").option("inferSchema", "true")
				.option("header", "true").load(csvFileName);	
		return null;
		
	}
}