package com.uks.jyoti.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;
import com.uks.jyoti.struts.day2.a1.logic.UserListLogic;

/**
 * Action class that shows the list of all users as well as provide search
 * criteria to perform filtering of users only by the admin access
 *
 * @author jyoti
 *
 */
public class UserListAction extends ActionSupport {
	/**
	 * This class is use for User list action
	 */
	private static final long serialVersionUID = 1L;

	// define array list of checkbox value storing
	List<UserDataBean> list;

	// Getter methods for ArrayList
	public List<UserDataBean> getList() {
		return list;
	}

	// Getter and Setter methods for UserDataBean
	public UserDataBean listbean;
	UserListLogic objlogic = new UserListLogic();

	public UserDataBean getListbean() {
		return listbean;
	}

	// Getter and Setter methods for ListBean
	public void setListbean(UserDataBean listbean) {
		this.listbean = listbean;
	}

	String uname, category, fname, address, sex, email;

	// Getter and Setter methods for uname,category,fname,address,sex,email
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// default method for start of execution
	public String execute() throws SQLException, IOException {

		try{
		// calling getUserList of UserListLogic class with parametres and
		// returing the arraylist
		list = objlogic.getUserList(uname, category, fname, address, sex, email);
		return SUCCESS;
		}catch(HibernateException e){
			return ERROR;
		}

	}

}
