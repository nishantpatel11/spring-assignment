package com.nishu.jdbc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nishu.jdbc.beans.Department;
import com.nishu.jdbc.beans.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor {

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {

		Employee employee = new Employee();
		employee.setEmpId( rs.getInt(1));
		employee.setEmpName( rs.getString(2));
		employee.setEmpJobId( rs.getString(3));
		employee.setSalary(rs.getDouble(4));
		employee.setEmpHireDate(rs.getTimestamp(5).toLocalDateTime());
		employee.setDept(new Department(rs.getInt(6),rs.getString(7),rs.getInt(8)));
		return employee;
	}

}
