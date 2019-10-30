package com.nishu.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nishu.jdbc.beans.Employee;
import com.nishu.jdbc.dao.EmployeeDao;
import com.nishu.jdbc.dao.mapper.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao{


	private DataSource dataSource;


	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	@Override
	public Integer createEmployee(Employee employee) {

		String query = "insert into employee (emp_id, name) values (?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());
			//			ps.setDouble(3, employee.getSalary());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee saved with id="+employee.getEmpId());
				return out;
			}else System.out.println("Employee save failed with id="+employee.getEmpName());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> select(Integer empId, String name) {

		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select
				.query(
						"select  emp_id, name from employee where emp_id = ? AND name= ?",
						new Object[] {empId, name },
						new EmployeeRowMapper());
	}

	@Override
	public void deleteAll() {

		JdbcTemplate delete = new JdbcTemplate(dataSource);
		delete.update("DELETE from employee");

	}

	@Override
	public Integer delete(Integer empId, String name) {

		JdbcTemplate delete = new JdbcTemplate(dataSource);
		int rowId = delete.update("DELETE from employee where emp_id = ? AND name = ?",
				new Object[] { empId, name });
		return rowId;
	}

	@Override
	public Employee getById(int id) {	

		String query = "select name from employee where emp_id = ?";
		Employee emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				emp = new Employee();
				emp.setEmpId(id);
				emp.setEmpName(rs.getString("name"));
				//			emp.setSalary(rs.getDouble("salary"));
				System.out.println("Employee Found::"+emp);
			}else{
				System.out.println("No Employee found with id="+id);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public Integer update(Employee employee) {

		String query = "update employee set name=? where emp_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getEmpId());
			Integer out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee updated with id="+employee.getEmpId());
				return out;
			}else 
				System.out.println("No Employee found with id="+employee.getEmpId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Integer deleteById(int id) {
		String query = "delete from employee where emp_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee deleted with id="+id);
				return out;
			}else 
				System.out.println("No Employee found with id="+id);
	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeAll() {

		String query = "select emp_id, name from employee";
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				emp.setEmpName(rs.getString("name"));
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

}
