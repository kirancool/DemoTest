package com.stock.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Repository;
@Repository("submitDao")
public class SubmitDaoImpl implements SubmitDao{

	@Override
	public void submit(String company,String stock_price_open,String stock_price_high,String stock_price_low) throws SQLException {
		
		SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();
	   	 
				
				  Dataset<Row> sql = ssc.sql("insert into table kiran.result values(\'"+company+"\',"+stock_price_open+","+stock_price_high+","+stock_price_low+")");
				
				    }
			
		}
