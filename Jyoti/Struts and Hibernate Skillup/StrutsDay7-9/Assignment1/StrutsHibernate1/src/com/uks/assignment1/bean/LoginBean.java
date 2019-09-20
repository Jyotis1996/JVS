package com.uks.assignment1.bean;

/**
 * Login bean class to get and set username,password and category to validate
 *
 * @author Jyoti Date-2019/09/13
 *
 */

public class LoginBean {

	//Getter and Setter Methods
	String username,password,category;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
