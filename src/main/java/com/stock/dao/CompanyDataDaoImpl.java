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
@Repository("companydataDao")
public class CompanyDataDaoImpl  implements CompanyDataDao{
	@Autowired
	private HiveContext hiveContext;
	@Override
	public List<Map<String, Object>> getAllCompany() throws SQLException {
		/*SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();
   	 */
			
			  Dataset<Row> sql = hiveContext.sql("select stockmarketdata.company from kiran.stockmarketdata limit 16");
			
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



