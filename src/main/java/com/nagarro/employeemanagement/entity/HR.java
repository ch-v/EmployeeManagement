package com.nagarro.employeemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vishalchaudhary01
 *
 */
@Entity
public class HR {

	@Id
	private String userId;
	private String password;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
