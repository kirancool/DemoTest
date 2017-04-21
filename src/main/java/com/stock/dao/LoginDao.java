package com.stock.dao;

import java.sql.SQLException;
import java.util.List;

import com.stock.bean.Login;

public interface LoginDao {

	//public boolean getLogin(String username, String password) throws SQLException;

public boolean getLogin(String username,String password) throws SQLException;

}
