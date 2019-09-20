/**
 *
 */
package com.uks.jyoti.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.jyoti.struts.day2.a1.bean.FormBean;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;
import com.uks.jyoti.struts.day2.a1.logic.EditLogic;

/**
 * @author jyoti
 *
 */
public class EditAction extends ActionSupport {
	/**
	 * This class is use for Edit user action
	 */
	private static final long serialVersionUID = 1L;
	// creating edit logic class
	EditLogic objedit = new EditLogic();
	UserDataBean listbean;
	FormBean listbean_old = new FormBean();

	String uname, pass;

	// Getter and Setter methods for username and password
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// Getter UserDataBean Getter and setter methods
	public UserDataBean getListbean() {
		return listbean;
	}

	public void setListbean(UserDataBean listbean) {
		this.listbean = listbean;
	}

	// Default execution of the method
	public String execute() throws SQLException, IOException {

		try {
			listbean = objedit.editUser(uname);

			String date = listbean.getDob().toString();
			listbean_old.setDob(date);

			return SUCCESS;
		} catch (HibernateException e) {
			return ERROR;
		}
	}

}
