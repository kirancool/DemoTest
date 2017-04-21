package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CompanyDataDao {
	public List<Map<String, Object>> getAllCompany() throws SQLException;
}
