package com.stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TableDataDao {
	public List<Map<String, Object>> getTableData() throws SQLException;

}
