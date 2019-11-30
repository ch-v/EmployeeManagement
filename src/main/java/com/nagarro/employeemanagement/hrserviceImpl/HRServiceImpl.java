package com.nagarro.employeemanagement.hrserviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagement.constant.Constant;
import com.nagarro.employeemanagement.dao.HRDao;
import com.nagarro.employeemanagement.entity.Employee;
import com.nagarro.employeemanagement.entity.HR;
import com.nagarro.employeemanagement.hrservice.HRService;

/**
 * @author vishalchaudhary01
 *
 */
@Component
public class HRServiceImpl implements HRService {

	@Autowired
	HRDao hrdao;

	public HR getHR(String userId) {
		HR hr = hrdao.getPassword(userId);
		return hr;
	}

	public List<Employee> getService() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Employee>> res = restTemplate.exchange(Constant.GET_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		List<Employee> lists = res.getBody();
		return lists;
	}

	public Employee postService(Employee emp) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(Constant.POST_URI, emp, Employee.class);
	}

	public void putService(Employee emp, Map<String, String> params) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(Constant.PUT_URI, emp, params);
	}
}
