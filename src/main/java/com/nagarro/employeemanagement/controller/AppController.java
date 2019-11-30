package com.nagarro.employeemanagement.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.employeemanagement.entity.Employee;
import com.nagarro.employeemanagement.entity.HR;
import com.nagarro.employeemanagement.hrserviceImpl.HRServiceImpl;

/**
 * @author vishalchaudhary01
 *
 */
@Controller
public class AppController {

	@Autowired
	HRServiceImpl hrservice;
	@Autowired
	Employee emp;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("userId") String userId, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		HR hrDetails = hrservice.getHR(userId);
		if (hrDetails != null) {
			if (hrDetails.getPassword().equals(password)) {
				mv.addObject("userId", userId);
				mv.addObject("username", hrDetails.getUsername());
				List<Employee> lists = hrservice.getService();
				mv.addObject("lists", lists);
				mv.setViewName("dashboard");

			} else {
				mv.setViewName("login");
			}
		}

		return mv;

	}

	@RequestMapping(value = "/employeeDetails")
	public ModelAndView employeeDetails(@RequestParam("empcode") String empcode,
			@RequestParam("empname") String empname, @RequestParam("location") String location,
			@RequestParam("email") String email, @RequestParam("dob") String dob, HttpServletRequest request,
			HttpServletResponse response) throws JsonProcessingException {

		ModelAndView mv = new ModelAndView();
		ObjectMapper mapp = new ObjectMapper();
		emp.setDob(dob);
		emp.setEmail(email);
		emp.setEmpCode(empcode);
		emp.setEmpName(empname);
		emp.setLocation(location);
		String jsonData = mapp.writeValueAsString(emp);
		System.out.println(jsonData);
		hrservice.postService(emp);
		List<Employee> lists = hrservice.getService();
		mv.addObject("lists", lists);
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/employeeUpdate")
	public ModelAndView employeeUpdate(@RequestParam("empid") String empid, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("empid", empid);
		mv.setViewName("employeeDetails");
		mv.addObject("controller", "put");
		return mv;

	}

	@RequestMapping("/upload")
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("controller", "employeeDetails");
		mv.setViewName("employeeDetails");
		return mv;
	}

	@RequestMapping("/put")
	public ModelAndView edit(@RequestParam("empcode") String empcode, @RequestParam("empname") String empname,
			@RequestParam("location") String location, @RequestParam("email") String email,
			@RequestParam("dob") String dob, HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {

		ModelAndView mv = new ModelAndView();
		Map<String, String> params = new HashMap<String, String>();
		params.put("empcode", empcode);
		emp.setDob(dob);
		emp.setEmail(email);
		emp.setEmpCode(empcode);
		emp.setEmpName(empname);
		emp.setLocation(location);
		hrservice.putService(emp, params);
		List<Employee> lists = hrservice.getService();
		mv.addObject("lists", lists);
		mv.setViewName("dashboard");
		return mv;
	}

}
