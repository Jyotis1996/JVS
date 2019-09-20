/**
 *
 */
package Assignment2.Login.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import Assignment2.Login.bean.LoginBean;
import Assignment2.Login.bean.UserDataBean;
import Assignment2.Login.logic.LoginLogic;
import common.util.Constants;

/**
 * To check login details are valid or not or their category user or admin
 *
 * @author Jyoti Date-2019/09/04
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	// Creating object
	UserDataAction objFetch = new UserDataAction();
	LoginLogic objLogic = new LoginLogic();

	public UserDataBean objuser;
	public LoginBean objbean;
	public Map<String, Object> session;

	// array list of UserDataBean class

	public ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// Getter and Setter method for UserDataBean and LoginBean
	public UserDataBean getObjuser() {
		return objuser;
	}

	public void setObjuser(UserDataBean objuser) {
		this.objuser = objuser;
	}

	public LoginBean getObjbean() {
		return objbean;
	}

	public void setObjbean(LoginBean objbean) {
		this.objbean = objbean;
	}

	public String logOut() {
		session.remove("loggedInUser");
		addActionMessage("You Have Been Successfully Logged Out");
		return SUCCESS;
	}

	public String execute() {
		if (objbean.getPassword().length() == 0 && objbean.getUsername().length() == 0) {
			addActionError(Constants.ERRORIUP);
		}

		else if (objbean.getPassword().length() == 0) {
			addActionError(Constants.PASSOWORDREQUIRED);
		}

		else if (objbean.getUsername().length() == 0) {
			addActionError(Constants.USERNAMEREQUIRED);
		}

		else if (!objbean.equals(null)) {

			String category;
			try {
				category = objLogic.validateUser(objbean);
				System.out.println(Constants.CATEGORY + category);
				if (objbean.getCategory() != null) {
					if (objbean.getPassword().equalsIgnoreCase(Constants.ADMIN)
							&& objbean.getUsername().equalsIgnoreCase(Constants.ADMIN)) {

						// fetch single user data
						objuser = objFetch.fetchUserData(objbean.getUsername());

						// fetch all user data and store to list
						list = objFetch.fetchAllUserData();
						return Constants.SUCCESS;
					} else {
						// fetch single user data
						objuser = objFetch.fetchUserData(objbean.getUsername());
						// Returning the list of objects
						return Constants.SUCCESS;
					}

				} else {
					System.out.println("In else");
					addActionError(Constants.INVALIDUSERNAMEPASSWORD);
				}
			} catch (SQLException | IOException e) {
				// e.printStackTrace();
				System.out.println(e);
				return Constants.ERROR1;
			}
		}

		return Constants.LOGIN;
	}
}
