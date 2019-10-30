package com.nishu.jdbc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nishu.jdbc.beans.Department;
import com.nishu.jdbc.beans.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor{

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {

		Employee employee = new Employee();
		employee.setEmpId(rs.getFetchSize()>0 ? rs.getInt(1):null);
		employee.setEmpName(rs.getFetchSize()>1 ? rs.getString(2):null);
		employee.setEmpJobId(rs.getFetchSize()>2 ? rs.getString(3):null);
		employee.setSalary(rs.getFetchSize()>3 ? rs.getDouble(4):null);
		employee.setEmpHireDate(rs.getFetchSize()>4 ? rs.getTimestamp(5)!=null ? rs.getTimestamp(5).toLocalDateTime():null:null);
		employee.setDept(rs.getFetchSize()>5 ? (Department) rs.getObject(6):null);
		
		return employee;
	}

}
