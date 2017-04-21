package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DateDataDao {
	public List<Map<String, Object>> getAllDate(String companyname) throws SQLException;

}
