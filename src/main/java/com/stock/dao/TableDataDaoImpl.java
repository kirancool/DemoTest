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
@Repository("tabledataDao")
public class TableDataDaoImpl implements TableDataDao{
	@SuppressWarnings("deprecation")
	@Autowired
	private HiveContext  hiveContext;
	 /*SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();*/
		 public List<Map<String, Object>> getTableData() throws SQLException{
	
	 Dataset<Row> sql = hiveContext.sql("select * from kiran.stockmarketdata limit 100");
			 sql.show();
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