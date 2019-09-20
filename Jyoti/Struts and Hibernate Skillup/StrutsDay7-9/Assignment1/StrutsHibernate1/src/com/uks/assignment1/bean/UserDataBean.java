package com.uks.assignment1.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserData bean class to integrate userdetails table with project and get and set data from all the fields
 *
 * @author Jyoti date-2019/09/13
 *
 */
@Entity
@Table(name = "userdetails")
public class UserDataBean {

	/**
	 * Create hibernate data base by creating master class and integrate table with master class
	 */

	@Id
	@GeneratedValue
	@Column(name = "uid", insertable=true, updatable=true, nullable=false)
	private int uid;

	@Column(name = "userid",insertable=true, updatable=true, nullable=false)
	private String userid;

	@Column(name = "password",insertable=true, updatable=true, nullable=false)
	private String password;

	@Column(name = "salulation",insertable=true, updatable=true, nullable=true)
	private String salutation;

	@Column(name = "firstname",insertable=true, updatable=true, nullable=false)
	private String firstName;

	@Column(name = "middleinitial",insertable=true, updatable=true, nullable=true)
	private String middleName;

	@Column(name = "lastname",insertable=true, updatable=true, nullable=false)
	private String lastName;

	@Column(name = "sex",insertable=true, updatable=true, nullable=false)
	private String gender;

	@Column(name = "emailid",insertable=true, updatable=true, nullable=true)
	private String emailId;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate",insertable=true, updatable=true, nullable=false)
	private Date dob;

	@Column(name = "address",insertable=true, updatable=true, nullable=true)
	private String address;

	@Column(name = "areaofinterest",insertable=true, updatable=true, nullable=false)
	private String areaofinterest;

	@Column(name = "otherinterest",insertable=true, updatable=true, nullable=true)
	private String otherinterest;

	@Column(name = "category",insertable=true, updatable=true, nullable=false)
	private String category;

	/**
	 * Get and set methods to get and set data from table
	 * @return
	 */
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

	public String getGender() {
		return gender;
	}

	public void setGender(String Gender) {
		gender = Gender;
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

	public void setAddress(String Address) {
		address = Address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAreaofinterest() {
		return areaofinterest;
	}

	public void setAreaofinterest(String areaofinterest) {
		this.areaofinterest = areaofinterest;
	}

	public String getOtherinterest() {
		return otherinterest;
	}

	public void setOtherinterest(String otherinterest) {
		this.otherinterest = otherinterest;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
