package com.stock.dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("stockPriceLowDao")
public class StockPriceLowDaoImpl implements StockPriceLowDao{
 @Autowired
 private HiveContext hiveContext;
	 private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	 /*SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();*/
	/*public List<StockPriceLow> getStockPriceLow() throws SQLException*/
	 public List<Map<String, Object>> getStockPriceLow() throws SQLException{
		
		/*try {

			  Class.forName(driverName);
		  } catch (ClassNotFoundException e) {
		   
		    e.printStackTrace();
		  }
		  
		  Connection con = DriverManager.getConnection("jdbc:hive2://10.10.0.30:10000/kiran", "hive", "");
		  Statement stmt = con.createStatement();
		 
		  String sql= "select stock_price_low,count(*) from stockmarketdata group by stock_price_low ORDER BY stock_price_low ASC limit 5";
		  ResultSet res = stmt.executeQuery(sql);
		  if (res.next()) {
		    System.out.println(res.getString(1));
		  }
		  res = stmt.executeQuery(sql);
		  List<StockPriceLow> stockList = new ArrayList<StockPriceLow>();
		  while (res.next()) {
		   // System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
			  StockPriceLow sps= new StockPriceLow();
				 String emps=String.valueOf(res.getString(1));
				 Integer emp1=Integer.valueOf(res.getString(2));
				   sps.setStock_price_low(emps);
				   sps.setCount(emp1);
					stockList.add(sps);
		  
			  }
			return stockList;
			 */
 //Dataset<Row> sql = ssc.sql("select company,count(stock_price_low) as count,stock_price_low from kiran.stockmarketdata group by stock_price_low,company ORDER BY stock_price_low DESC limit 10");
		 Dataset<Row> sql = hiveContext.sql("select company,stock_price_low from kiran.stockmarketdata DESC limit 10");
		 List<Map<String, Object>> stockList2 = new ArrayList<>();
		  Row[] dataRows = (Row[]) sql.collect();
		 
		  String[] columns = sql.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		        	   }
		    
		        	   stockList2.add(object);
		    }

		return stockList2;
	}
}
