/*package com.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository("csvDao")
public class CSVDaoImpl implements CSVDao{
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	@Override
	public String createAndLoad(String path,String csvFileName) throws SQLException {
		try {

			  Class.forName(driverName);
		  } catch (ClassNotFoundException e) {
		   
		    e.printStackTrace();
		  }
		  
		  Connection con = DriverManager.getConnection("jdbc:hive2://10.10.0.30:10000/kiran", "hive", "");
		     
	            Statement stmt;
	            try {
	                stmt = con.createStatement();
	                String sql = "LOAD DATA LOCAL INPATH 'file:/"+path+ "' OVERWRITE INTO TABLE "+csvFileName+"";
	                System.out.println("Load Data into  successful"+sql);
	                stmt.execute("LOAD DATA LOCAL INPATH 'file:/"+path+ "' OVERWRITE INTO TABLE "+csvFileName+"");
	                con.close();
	            } catch (SQLException e) 
	            {
	            	e.printStackTrace();
	            }
				return csvFileName;
	                
	               
			
	}
}*/