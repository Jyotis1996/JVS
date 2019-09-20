package com.uks.jyoti.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;
import com.uks.jyoti.struts.day2.a1.logic.DetailLogic;

/**
 * @author jyoti
 *
 */
public class DetailAction extends ActionSupport {

	/**
	 * This class is use for details of user action
	 */
	private static final long serialVersionUID = 1L;

	// creating object
	DetailLogic objdetail = new DetailLogic();
	String uname;

	// Getter and Setter methods
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public UserDataBean listbean;

	public UserDataBean getListbean() {
		return listbean;
	}

	public void setListbean(UserDataBean listbean) {
		this.listbean = listbean;
	}

	// execution starts from here
	public String execute() throws SQLException, IOException {
		try {
			listbean = objdetail.detailUser(uname);
			if (!listbean.equals(null)) {
				return SUCCESS;
			} else {
				addActionError("Something went wrong please contact admin");
			}
		} catch (HibernateException e) {
			return ERROR;
		}
		return SUCCESS;
	}
}
