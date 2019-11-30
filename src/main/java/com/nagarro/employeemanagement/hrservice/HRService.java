package com.nagarro.employeemanagement.hrservice;

import java.util.List;
import java.util.Map;

import com.nagarro.employeemanagement.entity.Employee;
import com.nagarro.employeemanagement.entity.HR;

/**
 * @author vishalchaudhary01
 *
 */
public interface HRService {

	public HR getHR(String userId);

	public List<Employee> getService();

	public Employee postService(Employee emp);

	public void putService(Employee emp, Map<String, String> params);

}
