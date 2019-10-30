package com.nishu.jdbc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nishu.jdbc.beans.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor{

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {

		Employee employee = new Employee();
		employee.setEmpId(rs.getInt(0));
		
		return employee;
	}

}
