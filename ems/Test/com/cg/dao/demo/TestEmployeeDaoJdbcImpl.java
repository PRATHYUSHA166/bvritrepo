package com.cg.dao.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.demo.EmployeeDaoJdbcImpl;
import com.cg.ems.exception.EmployeeException;

class TestEmployeeDaoJdbcImpl {

	@Test
	public void testFindEmployeeByIdExist() throws Exception
	{
		EmployeeDao dao=new EmployeeDaoJdbcImpl();
		Employee employee=dao.findEmployeeById(1056);
		assertEquals(1056,employee.getEmployeeId());
		
	}
	@Test
	public void testEmployeeByIdNotExist()
	{
		EmployeeDao dao=new EmployeeDaoJdbcImpl();
		assertThrows(EmployeeException.class, ()->dao.findEmployeeById(9000));
		
		
		
		
	}

}
