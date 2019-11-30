package com.nagarro.employeemanagement.daoImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.employeemanagement.configuration.HibernateConfiguration;
import com.nagarro.employeemanagement.dao.HRDao;
import com.nagarro.employeemanagement.entity.HR;

/**
 * @author vishalchaudhary01
 *
 */
@Component
public class HRDaoImpl implements HRDao {

	@Autowired
	HibernateConfiguration hc;

	public HR getPassword(String userId) {
		Session session = hc.getSession();
		if (userId != null) {
			return (HR) session.get(HR.class, userId);
		} else {
			return null;
		}
	}

}
