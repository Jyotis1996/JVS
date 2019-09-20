package com.uks.jvs.jyoti.day9.assignment1;

/**
 * Class Name : UserInfo Description : get and set userinformation
 *
 * @author Jyoti [02-07-2019]
 *
 */
public class UserInfo {
	private int userId = 0;
	private String name = null;
	private String Address = null;
	private String city = null;
	private long BasicSalary = 0;
	private long telNumber = 0;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @param userId
	 * @param name
	 * @param address
	 * @param city
	 * @param basicSalary
	 * @param telNumber
	 */
	public UserInfo(int userId, String name, String address, String city, long basicSalary, long telNumber) {
		this.userId = userId;
		this.name = name;
		Address = address;
		this.city = city;
		BasicSalary = basicSalary;
		this.telNumber = telNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the basicSalary
	 */
	public long getBasicSalary() {
		return BasicSalary;
	}

	/**
	 * @param basicSalary
	 *            the basicSalary to set
	 */
	public void setBasicSalary(long basicSalary) {
		BasicSalary = basicSalary;
	}

	/**
	 * @return the telNumber
	 */
	public long getTelNumber() {
		return telNumber;
	}

	/**
	 * @param telNumber
	 *            the telNumber to set
	 */
	public void setTelNumber(long telNumber) {
		this.telNumber = telNumber;
	}

}
