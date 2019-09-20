
package com.uks.logic;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.bean.WelcomeBean;

/**
 * Class to check whether success or error
 *
 * @author Jyoti Date-2019/08/30
 *
 */
public class WelcomeLogic extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// Initializing username and message variables
	public WelcomeBean objbean = new WelcomeBean();

	public String login(String loggedUsername, Map<String, Object> sessionMap) {

		// check if the userName is already stored in the session
		if (!loggedUsername.isEmpty()) {
			sessionMap.put("username", loggedUsername);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
