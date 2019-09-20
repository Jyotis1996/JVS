
package com.uks.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.bean.WelcomeBean;
import com.uks.logic.WelcomeLogic;

/**
 * Welcome action class to take action and call bean and logic class
 *
 * @author Jyoti Date-2019/08/30
 */
public class WelcomeAction extends ActionSupport implements SessionAware {


	private static final long serialVersionUID = 1L;

	public Map<String, Object> sessionMap;
	// Initializing username and message variables
	public WelcomeBean objbean = new WelcomeBean();
	public WelcomeLogic objLogic = new WelcomeLogic();

	// String method of the class
	public String execute() {
		String Username = objbean.getUsername();;
		objLogic.login(Username,sessionMap);

		if(Username.equals("")){
			objbean.setMessage("Please Enter Username");
		} else {
		objbean.setMessage("Hello " + Username);
		}
		String str = Username;
		if (!str.isEmpty())
			return "success";
		else
			return "error";
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
