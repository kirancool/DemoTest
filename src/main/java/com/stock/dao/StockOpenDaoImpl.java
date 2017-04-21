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
@SuppressWarnings("deprecation")
@Repository("stockopendataDao")
public class StockOpenDaoImpl  implements StockOpenDao{
	@Autowired
	private HiveContext hiveContext;
	public List<Map<String, Object>> getAllStockPriceOpen(String companyname) throws SQLException {
		/*SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();
   	 */
			
			  Dataset<Row> sql = hiveContext.sql("select stock_price_open from kiran.stockmarketdata  where stockmarketdata.company=\'"+companyname+"\' limit 10");
			
			  List<Map<String, Object>> stockList = new ArrayList<>();

			 
			  Row[] dataRows = (Row[]) sql.collect();
			 
			  String[] columns = sql.columns();
			 
			    for (Row row : dataRows) {
			    		    		
			    	Map<String, Object> object= new HashMap<String, Object>();
			          
			        	   for(String column : columns)
			        	   {
			        		 
			        		   object.put(column, row.getAs(column));
			        		  
			        
			                 }
			        	   stockList.add(object);
			        	   
			      //     }
			    }
			    
		
			return stockList;
			
				 
			  
		}

		
	}
