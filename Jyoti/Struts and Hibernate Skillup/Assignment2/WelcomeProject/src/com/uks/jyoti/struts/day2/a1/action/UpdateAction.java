/**
 *
 */
package com.uks.jyoti.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.jyoti.struts.common.util.Constants;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;
import com.uks.jyoti.struts.day2.a1.logic.UpdateLogic;

/**
 * @author jyoti
 *
 */
public class UpdateAction extends ActionSupport {
	/**
	 * This class is use for update action
	 */
	private static final long serialVersionUID = 1L;

	String message, uname;

	// Setter methods for username
	public void setUname(String uname) {
		this.uname = uname;
	}

	UpdateLogic objlogic = new UpdateLogic();
	public UserDataBean listbean;

	// Getter and Setter methods for UserDataBean
	public UserDataBean getListbean() {
		return listbean;
	}

	public void setListbean(UserDataBean listbean) {
		this.listbean = listbean;
	}

	// Default execution method for class
	public String execute() throws SQLException, IOException {
		try {
			// calling method updateuser with parameter as object and return
			// message
			message = objlogic.updateuser(listbean);
			if (!listbean.equals(null)) {
				if (message.equalsIgnoreCase(Constants.updateRecordSucc)) {
					// if records updated then return success and print message
					addActionError("Record is updated");
					return SUCCESS;
				}
			} else {
				// if records not updated then return error and error print
				// message
				addActionError(Constants.updateRecordUnSucc);
				return ERROR;
			}

		} catch (HibernateException e) {
			return ERROR;
		}
		return SUCCESS;
	}
}
