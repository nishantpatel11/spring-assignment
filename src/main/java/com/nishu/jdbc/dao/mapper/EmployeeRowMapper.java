package com.nishu.jdbc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper<T> implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeResultSetExtractor extractor = new EmployeeResultSetExtractor();
		return extractor.extractData(rs);
	}
}
