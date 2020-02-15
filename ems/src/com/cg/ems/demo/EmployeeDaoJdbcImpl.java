package com.cg.ems.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.DBUtil;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
	int id=0;
		try
		 {
		 Connection connection=DBUtil.getConnection();
		 String cmd="select empid,empname,empsal from employee_tbl where empid(?) ";
		 PreparedStatement pstmt=connection.prepareStatement(cmd);
		 pstmt.setInt(1, employee.getEmployeeId());
		 pstmt.setString(2,employee.getEmployeeName() );
		 pstmt.setDouble(3,employee.getSalary() );
		 pstmt.executeUpdate();
		 ResultSet rst=pstmt.executeQuery();
		 if(rst.next())
		 {
			 int Id = rst.getInt("empid");
			 String name=rst.getString("empname");
			 double sal=rst.getDouble("empSal");
			 employee.setEmployeeId(id);
			 employee.setSalary(sal);
		 }
		 else
		 {
			 throw new EmployeeException("id not found");
		 }
		 connection.close();
	 } catch(Exception e)
	 {
		 throw new EmployeeException(e.getMessage());
	 }
	 
	 return id;
	}


	

	@Override
	public Employee deleteEmployeeById(int employeeId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
