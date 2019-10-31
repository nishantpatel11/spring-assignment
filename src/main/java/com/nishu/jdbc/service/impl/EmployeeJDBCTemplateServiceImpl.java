package com.nishu.jdbc.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nishu.jdbc.beans.Department;
import com.nishu.jdbc.beans.Employee;
import com.nishu.jdbc.dao.EmployeeDao;
import com.nishu.jdbc.service.EmployeeService;

public class EmployeeJDBCTemplateServiceImpl implements EmployeeService{


	private DataSource dataSource;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Integer createEmployee(Employee employee) {
		String query = "insert into employee (emp_id, name, "
				+ "emp_job_id, salary, emp_hire_date, dept_id) "
				+ "values (?,?,?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] {employee.getEmpId(), employee.getEmpName(), 
				employee.getEmpJobId(),employee.getSalary()
				,employee.getEmpHireDate(),employee.getDept()!=null ? employee.getDept().getDeptId():null
		};

		int out = jdbcTemplate.update(query, args);

		if(out !=0){
			System.out.println("Employee saved with id="+employee.getEmpId());
			return out;
		}else 
			System.out.println("Employee save failed with id="+employee.getEmpId());
		return null;
	}

	@Override
	public Employee getById(int id) {
		String query = "select "
				+ "emp_id, name, "
				+ "emp_job_id, "
				+ "salary, "
				+ "emp_hire_date  "
				+ "from employee where emp_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				emp.setEmpName(rs.getString("name"));
				emp.setEmpHireDate(rs.getTimestamp("emp_hire_date")!=null ? rs.getTimestamp("emp_hire_date").toLocalDateTime():null);
				emp.setSalary(rs.getDouble("salary"));
				emp.setEmpJobId(rs.getString("emp_job_id"));
				return emp;
			}});

		return emp;

	}

	@Override
	public Integer update(Employee employee) {

		String query = "update employee set name=?, salary=? where emp_id =?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { employee.getEmpName() 
				,employee.getSalary()
				,employee.getEmpId()
		};

		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getEmpId());
			return out;
		}else 
			System.out.println("No Employee found with id="+employee.getEmpId());

		return null;
	}

	@Override
	public Integer deleteById(int id) {

		String query = "delete from employee where emp_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
			return out;
		}else 
			System.out.println("No Employee found with id="+id);

		return null;
	}

	@Override
	public Employee selectAll(Integer empId, String name) {

		String query = "select "
				+ "emp_id, "
				+ "name, "
				+ "emp_job_id, "
				+ "salary, "
				+ "emp_hire_date,"
				+ "dept.dept_id,"
				+ "dept.dept_name,"
				+ "dept.dept_manager_id "
				+ "from employee emp inner join department dept"
				+ "on dept.dept_id = emp.dept_id"
				+ "where emp.emp_id = ? and emp.name =?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[]{empId,name}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				emp.setEmpName(rs.getString("name"));
				emp.setEmpHireDate(rs.getTimestamp("emp_hire_date")!=null ? rs.getTimestamp("emp_hire_date").toLocalDateTime():null);
				emp.setSalary(rs.getDouble("salary"));
				emp.setEmpJobId(rs.getString("emp_job_id"));
				Department dept = new Department();
				dept.setDeptId(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));
				dept.setManagerId(rs.getInt("dept_manager_id"));
				emp.setDept(dept);
				return emp;
			}});


		return emp;
	}




	@Override
	public List<Employee> getEmployeeAll() {

		String query = "select "
				+ "emp_id, "
				+ "name, "
				+ "emp_job_id, "
				+ "salary, "
				+ "emp_hire_date  "
				+ "from employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);

		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setEmpId(empRow.get("emp_id") != null ? Integer.parseInt(String.valueOf(empRow.get("emp_id"))):null);
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setEmpHireDate(empRow.get("emp_hire_date")!=null ? Timestamp.valueOf(String.valueOf(empRow.get("emp_hire_date"))).toLocalDateTime():null);
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);
			emp.setEmpJobId(String.valueOf(empRow.get("emp_job_id")));

			empList.add(emp);
		}
		return empList;
	}

	@Override
	public Integer deleteAll() {

		String query = "delete from employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer result = jdbcTemplate.update(query);
		return result;
	}

	@Override
	public Integer delete(Integer empId, String name) {

		String query = "delete from employee where emp_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { empId, name};
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee deleted with id="+out);
			return out;
		}else 
			System.out.println("No Employee found with id="+out);

		return out;
	}



	@Override
	public List<Employee> getAllEmployeeByDeptId(Integer deptId) {
		String query = "select "
				+ "emp_id, "
				+ "name, "
				+ "emp_job_id, "
				+ "salary, "
				+ "emp_hire_date,"
				+ "dept.dept_id,"
				+ "dept.dept_name,"
				+ "dept.dept_manager_id "
				+ "from employee emp inner join department dept"
				+ "on dept.dept_id = emp.dept_id"
				+ "where dept.dept_id = ? ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query,new Object[]{ deptId });

		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setEmpId(empRow.get("emp_id") != null ? Integer.parseInt(String.valueOf(empRow.get("emp_id"))):null);
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setEmpHireDate(empRow.get("emp_hire_date")!=null ? Timestamp.valueOf(String.valueOf(empRow.get("emp_hire_date"))).toLocalDateTime():null);
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);
			emp.setEmpJobId(String.valueOf(empRow.get("emp_job_id")));

			Department dept = new Department();
			dept.setDeptId(Integer.parseInt(String.valueOf(empRow.get("dept_id"))));
			dept.setDeptName(String.valueOf(empRow.get("dept_name")));
			dept.setManagerId(Integer.parseInt(String.valueOf(empRow.get("dept_manager_id"))));
			emp.setDept(dept);

			empList.add(emp);
		}
		return empList;
	}

	
	
	

	@Override
	public List<Employee> getEmployeeDepartment(){
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(EmployeeDao.findEmployeeAndDepartment);

		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setEmpId(empRow.get("emp_id") != null ? Integer.parseInt(String.valueOf(empRow.get("emp_id"))):null);
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);

			Department dept = new Department();
			dept.setDeptId(Integer.parseInt(String.valueOf(empRow.get("dept_id"))));
			dept.setDeptName(String.valueOf(empRow.get("dept_name")));
			emp.setDept(dept);

			empList.add(emp);
		}


		return empList;
	}
	
	
	@Override
	public List<Employee> getEmployeeMaxSalaryByDeptId(Integer deptId){
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(EmployeeDao.findEmployeeMaxSalaryByDeptId,new Object[]{ deptId });

		for(Map<String,Object> empRow : empRows){

			Employee emp = new Employee();
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);
			empList.add(emp);
		}


		return empList;
	}
	
	
	@Override
	public List<Employee> getEmployeeMaxSalary(){
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(EmployeeDao.findEmpNameJobIdAndSalary);

		for(Map<String,Object> empRow : empRows){

			Employee emp = new Employee();
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);
			emp.setEmpJobId(String.valueOf(empRow.get("emp_job_id")));
			empList.add(emp);
		}


		return empList;
	}
	
	@Override	
	public List<Employee> getEmployeeDetailsByDeptId(Integer deptId){
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(EmployeeDao.findDetailsOfAllEmployeeByDeptId,new Object[]{ deptId });
		for(Map<String,Object> empRow : empRows){

			Employee emp = new Employee();
			emp.setEmpId(empRow.get("emp_id") != null ? Integer.parseInt(String.valueOf(empRow.get("emp_id"))):null);
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setEmpHireDate(empRow.get("emp_hire_date")!=null ? Timestamp.valueOf(String.valueOf(empRow.get("emp_hire_date"))).toLocalDateTime():null);
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);
			emp.setEmpJobId(String.valueOf(empRow.get("emp_job_id")));

			empList.add(emp);
		}


		return empList;
	}

	
	@Override
	public List<Employee> getEmployeeDetailsByEmpId(Integer empId){
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(EmployeeDao.findAllEmployeeByEmpId,new Object[]{ empId });
		for(Map<String,Object> empRow : empRows){

			Employee emp = new Employee();
			emp.setEmpId(empRow.get("emp_id") != null ? Integer.parseInt(String.valueOf(empRow.get("emp_id"))):null);
			emp.setEmpName(String.valueOf(empRow.get("name")));
			emp.setEmpHireDate(empRow.get("emp_hire_date")!=null ? Timestamp.valueOf(String.valueOf(empRow.get("emp_hire_date"))).toLocalDateTime():null);
			emp.setSalary(empRow.get("salary")!=null ? Double.parseDouble(String.valueOf(empRow.get("salary"))):null);
			emp.setEmpJobId(String.valueOf(empRow.get("emp_job_id")));

			empList.add(emp);
		}


		return empList;
	}

	
	
	
	
	
//
//	public List<Employee> convertToObjectList(List<Object[]> objArrayList, Object object, List<String> excludedFieldNames, List<String> includedFieldNames){
//
//		List<Object>  objectList = null;
//		List<Employee>  employeeList = null;
//		
//		try {
//
//			objectList  =  new Common().convertToObjectList(objArrayList, object, excludedFieldNames, includedFieldNames);
//	
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//
//			e.printStackTrace();
//		}
//		
//
//		return employeeList;
//	}


}
