package com.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Repository;

import com.stock.bean.Login;
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	 private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	 boolean status;
	@Override
	public boolean getLogin(String username,String password) throws SQLException {
	try {

			  Class.forName(driverName);
		  } catch (ClassNotFoundException e) {
		   
		    e.printStackTrace();
		  }
		  
		  Connection con = DriverManager.getConnection("jdbc:hive2://10.10.0.30:10000/kiran", "hive", "");
	/*	SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();
		  Dataset<Row> sql = ssc.sql("select * from kiran.login where username=\'"+username+"\' and password=\'"+password+"\'");*/
		  String sql=("Select username,password from kiran.login where username=? and password=?");
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setString(1,username);
		  st.setString(2, password);
		/*  Statement st =((Connection) ssc).createStatement();*/
		  ResultSet rs = st.executeQuery();
		 
		  if (rs.next()) {
              System.out.println("Correct login credentials");
          } 
          else {
              System.out.println("Incorrect login credentials");
          }
      
		return status;
	}
}
	

