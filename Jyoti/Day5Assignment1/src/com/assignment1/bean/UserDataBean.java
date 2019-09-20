package com.assignment1.bean;
/**
 *  setter and getter methods for user data
 *  @author Jyoti Date-2019/09/04
 *
 */
public class UserDataBean {


	String firstName;
	String middleName;
	String lastName;
	String sex;
	String emailId;
	String birthDay;
	String birthMonth;
	String birthYear;
	String birthdate;
	String address;


	/**
	 * @return the birthDay
	 */
	public String getBirthDay() {
		return this.birthDay;
	}

	/**
	 * @param birthDay
	 *            the birthDay to set
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return the birthMonth
	 */
	public String getBirthMonth() {
		return this.birthMonth;
	}

	/**
	 * @param birthMonth
	 *            the birthMonth to set
	 */
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	/**
	 * @return the birthYear
	 */
	public String getBirthYear() {
		return this.birthYear;
	}

	/**
	 * @param birthYear
	 *            the birthYear to set
	 */
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}


	public String getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(String BirthDate) {
		this.birthdate = BirthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String FirstName) {
		firstName = FirstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String MiddleName) {
		middleName = MiddleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String LastName) {
		lastName = LastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String Sex) {
		sex = Sex;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String EmailId) {
		emailId = EmailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}





}
