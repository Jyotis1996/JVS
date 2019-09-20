
package com.uks.bean;

/**
 * Bean class to get and set username and message
 *
 * @author Jyoti Date-2019/08/30
 *
 */
public class WelcomeBean {

	// Getter and Setter Methods
	private String username, message;

	/**
	 * getUsername() method
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setUsername()
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getMessage
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * setMessage()
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
