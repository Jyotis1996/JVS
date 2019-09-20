package com.assignment1.bean;

import org.apache.struts.action.ActionForm;

public class UserListBean extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String salutation = null;
	private String firstName = null;
	private String lastName = null;
	private String middleInitial = null;
	private String gender = null;
	private String email = null;
	private String address = null;
	private String userName = null;
	private String password = null;
	private String category = null;
	private String areaOfInterest = "";
	private String otherInterest = "";
	private String birthMonth = null;
	private String birthYear = null;
	private String birthDate = null;


	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	private String fullName = null;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	// Get Salutations
	public String getSalutation() {
		return salutation;
	}

	// set salutations
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	// get first name
	public String getFirstName() {
		return firstName;
	}

	// set first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// get last name
	public String getLastName() {
		return lastName;
	}

	// Set last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// get Middle initial
	public String getMiddleInitial() {
		return middleInitial;
	}

	// Set Middle Initial
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	// Get the Gender
	public String getGender() {
		return gender;
	}

	// Set the Gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	// Get the Email
	public String getEmail() {
		return email;
	}

	// Set the email
	public void setEmail(String email) {
		this.email = email;
	}

	// Get the Address
	public String getAddress() {
		return address;
	}

	// Set the Address
	public void setAddress(String address) {
		this.address = address;
	}

	// Get user name
	public String getUserName() {
		return userName;
	}

	// Set USer Name
	public void setUserName(String userName) {
		this.userName = userName;
	}


	// Get the Password
	public String getPassword() {
		return password;
	}

	// Set the Password
	public void setPassword(String password) {
		this.password = password;
	}

	// get Category
	public String getCategory() {
		return category;
	}

	// set Category
	public void setCategory(String category) {
		this.category = category;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}


	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public String getOtherInterest() {
		return otherInterest;
	}

	public void setOtherInterest(String otherInterest) {
		this.otherInterest = otherInterest;
	}
}
