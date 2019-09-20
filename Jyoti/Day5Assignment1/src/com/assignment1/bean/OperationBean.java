package com.assignment1.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.assignment1.logic.UserListLogic;

public class OperationBean extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String salutation = null;
	private String firstName = null;
	private String lastName = null;
	private String middleInitial = null;
	private String gender = "";
	private String email = null;
	private String address = null;
	private String userName = "";
	private String password = "";
	private String category = null;
	private String[] areaOfInterest = null;
	private String otherInterest = "";
	private String birthDate = null;
	private String birthMonth = null;
	private String birthYear = null;

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

	public String[] getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String[] areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public String getOtherInterest() {
		return otherInterest;
	}

	public void setOtherInterest(String otherInterest) {
		this.otherInterest = otherInterest;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		Pattern pattern;
		Matcher matcher;
		ArrayList<UserListBean> objArrayList = new ArrayList<>();
		if (getFirstName().isEmpty()) {
			errors.add("firstName_error", new ActionMessage("firstname.error"));
		}
		if (getLastName().isEmpty()) {
			errors.add("lastName_error", new ActionMessage("lastname.error"));
		}
		if (getGender().equals("")) {
			errors.add("sex_error", new ActionMessage("sex.error"));
		}
		if (getCategory().isEmpty()) {
			errors.add("category_error", new ActionMessage("category.error"));
		}
		if (getBirthDate().isEmpty()) {
			errors.add("birthdate_error", new ActionMessage("birthdate.error"));
		} else if (getBirthMonth().isEmpty()) {
			errors.add("birthdate_error", new ActionMessage("birthmonth.error"));
		} else if (getBirthYear().isEmpty()) {
			errors.add("birthdate_error", new ActionMessage("birthyear.error"));
		} else {
			if (Integer.parseInt(getBirthDate()) >= 29
					&& getBirthMonth().equalsIgnoreCase("2")) {
				if (Integer.parseInt(getBirthDate()) == 29
						&& (Integer.parseInt(getBirthYear()) % 4) == 0) {
				} else {
					errors.add("birthdate_error", new ActionMessage(
							"invalidbirthdate.error"));
				}
			} else {
				if (Integer.parseInt(getBirthDate()) == 31
						&& (Integer.parseInt(getBirthMonth()) % 2) == 0
						&& !getBirthMonth().equalsIgnoreCase("8")) {
					System.out.println((Integer.parseInt(getBirthMonth()) % 2));
					if (Integer.parseInt(getBirthMonth()) < 8) {
						System.out.println(Integer.parseInt(getBirthMonth()));
						errors.add("birthdate_error", new ActionMessage(
								"invalidbirthdate.error"));
					}
				} else if (Integer.parseInt(getBirthDate()) == 31
						&& (Integer.parseInt(getBirthMonth()) % 2) != 0 && Integer.parseInt(getBirthMonth()) > 8 ) {
					errors.add("birthdate_error", new ActionMessage(
							"invalidbirthdate.error"));
				}
			}
		}
		if (getAreaOfInterest() == null) {
			errors.add("areaofinterest_error", new ActionMessage(
					"areaofinterest.error"));
		}
		if (!getEmail().isEmpty()) {
			String a = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			pattern = Pattern.compile(a);
			matcher = pattern.matcher(getEmail());
			if (!matcher.matches()) {
				errors.add("email_error", new ActionMessage("email.error"));
			}
		}
		objArrayList = getList();

		for (int i = 0; i < objArrayList.size(); i++) {
			if (objArrayList.get(i).getUserName()
					.equals(request.getParameter("hiddenUserId"))
					&& objArrayList.get(i).getPassword()
							.equals(request.getParameter("hiddenPassword"))) {
				request.setAttribute("EditList", objArrayList.get(i));
			}
		}

		request.setAttribute("categoryType", request.getParameter("catType"));
		return errors;
	}

	private ArrayList<UserListBean> getList() {
		UserListLogic objListLogic = new UserListLogic();
		ArrayList<UserListBean> objArrayList = new ArrayList<>();
		try {
			objArrayList = objListLogic.getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objArrayList;
	}
}
