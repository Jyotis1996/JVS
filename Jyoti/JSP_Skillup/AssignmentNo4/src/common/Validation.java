package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * Represents the validations for the user details input
 *
 */
public class Validation {

	/* Specific input error message */
	private String errorMessage;

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Checks whether the user details have been valid or not.
	 *
	 * @param userBean
	 *            The bean containing the user details.
	 * @return boolean True if user details is valid, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValid(UserBean userBean) throws Exception {
		/* Retrieve user details from bean to local variables */
		String userId = userBean.getUserId();
		String password = userBean.getPassword();
		String salutation = userBean.getSalutation();
		String firstName = userBean.getFirstName();
		String middleInitial = userBean.getMiddleInitial();
		String lastName = userBean.getLastName();
		String sex = userBean.getSex();
		String emailId = userBean.getEmailId();
		String birthday = userBean.getBirthDay();
		String birthmonth = userBean.getBirthMonth();
		String birthyear = userBean.getBirthYear();
		String[] interest = userBean.getAreaOfInterest();
		String otherInterest = userBean.getOtherInterests();

		/* Are UserName, MiddleInitial and LastName valid? */
		boolean flag = false;

		if (this.isEmptyInput(firstName)) {
			this.setErrorMessage(Constants.NO_FIRSTNAME);
		} else if (!this.isValidName(firstName)) {
			this.setErrorMessage(Constants.INVALID_FIRSTNAME);
		} else {
			flag = true;
		}

		if (flag == true) {
			if (this.isEmptyInput(middleInitial)) {
				flag = true;
			} else if (!this.isValidName(middleInitial)) {
				this.setErrorMessage(Constants.INVALID_MIDDLE_INITIAL);
				flag = false;
			}

			if (flag == true) {
				if (this.isEmptyInput(lastName)) {
					this.setErrorMessage(Constants.NO_LASTNAME);
					flag = false;
				} else if (!this.isValidName(lastName)) {
					this.setErrorMessage(Constants.INVALID_LASTNAME);
					flag = false;
				} else {
					flag = true;
				}
			}
		}

		/* Check for all details validation? */
		boolean isValid = this.isValidUserId(userId) && this.isValidPassword(password) && flag
				&& this.isValidSex(sex, salutation) && this.isValidEmailId(emailId)
				&& this.isValidBirthDate(birthday, birthmonth, birthyear, userBean)
				&& this.isValidInterest(interest, otherInterest) && this.isSubmitEmpty(userId, password, salutation, firstName, middleInitial, lastName, sex, emailId, birthday, birthmonth, birthyear, interest, otherInterest);

		return isValid;
	}

	/**
	 * Check whether the userId is valid or not.
	 *
	 * @param userId
	 *            UserId
	 * @return boolean True if userId is valid, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidUserId(String userId) throws Exception {
		boolean isValid = true;
		/* Is userId empty? */
		if (this.isEmptyInput(userId)) {
			this.setErrorMessage(Constants.NO_USERID);
			isValid = false;
		}
		/* Is invalid userId? */
		else if (!this.isValidInput(userId, Constants.REGEX_USERID)) {
			this.setErrorMessage(Constants.INVALID_USERID);
			isValid = false;
		}
		/* Is UserId too short? */
		else if (userId.length() < 6) {
			this.setErrorMessage(Constants.SHORT_USERID);
			isValid = false;
		}

		return isValid;
	}

	/**
	 * Check whether the password is empty or not.
	 *
	 * @param password
	 *            Password
	 * @return boolean True if password is empty, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidPassword(String password) throws Exception {
		boolean isValid = true;
		/* Is password empty? */
		if (this.isEmptyInput(password)) {
			this.setErrorMessage(Constants.NO_PASSWORD);
			isValid = false;
		}
		/* Is UserId too short? */
		else if (password.length() < 6) {
			this.setErrorMessage(Constants.SHORT_PASSWORD);
			isValid = false;
		}

		return isValid;
	}

	/**
	 * Check whether the FirstName, Middle Initial or LastName is valid or not.
	 *
	 * @param name
	 *            FirstName, Middle Initial or LastName
	 * @param order
	 *            order of FirstName, Middle Initial and LastName is 1,2 and 3
	 *            respectively.
	 * @return boolean True if FirstName, Middle Initial or LastName is valid,
	 *         otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidName(String name) throws Exception {

		boolean isValid = (!this.isEmptyInput(name)) && (this.isValidInput(name, Constants.REGEX_NAME));

		return isValid;
	}

	/**
	 * Checks whether the sex is selected or not
	 *
	 * @param sex
	 *            Male or Female
	 * @param salutation
	 *            Mr., Ms., Mrs. or Dr.
	 * @return boolean True if sex is selected and specific salutation is
	 *         selected for it, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidSex(String sex, String salutation) throws Exception {
		/* Is no sex is selected? */
		if (sex == null)
			sex = Constants.STRING_NONE;

		/* Is sex is empty? (No sex is selected) */
		if (this.isEmptyInput(sex)) {
			this.setErrorMessage(Constants.NO_SEX_SELECTED);
			return false;
		}
		/* Is no salutation (Not Mandatory field) is selected? */
		else if (this.isEmptyInput(salutation)) {
			return true;
		} else {
			/* Check for valid salutation for respective sex */
			boolean isValid = (sex.equals(Constants.STRING_MALE)
					&& Pattern.matches(Constants.REGEX_MALE_SALUTATION, salutation))
					|| (sex.equals(Constants.STRING_FEMALE)
							&& Pattern.matches(Constants.REGEX_FEMALE_SALUTATION, salutation));

			/* Is salutation valid for respective sex? */
			if (!isValid) {
				this.setErrorMessage(Constants.INVALID_SALUTATION_FOR_SEX);
			}

			return isValid;
		}
	}

	/**
	 * Checks whether the emailId is valid or not
	 *
	 * @param emailId
	 *            Email Id
	 * @return boolean True if the emailId is valid, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidEmailId(String emailId) throws Exception {
		/* Check for not empty and valid Email Id */
		boolean isNotValid = !this.isEmptyInput(emailId) && !this.isValidInput(emailId, Constants.REGEX_EMAILID);

		/* Is valid Email Id */
		if (isNotValid) {
			this.setErrorMessage(Constants.INVALID_EMAILID);
		}

		return !isNotValid;
	}

	/**
	 * Checks whether the BirthDate is valid or not
	 *
	 * @param birthDay
	 *            Day of Month
	 * @param birthMonth
	 *            Month
	 * @param birthYear
	 *            Year
	 * @param userBean
	 *            The bean containing the user details
	 * @return boolean True if valid BirthDate is selected, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidBirthDate(String birthDay, String birthMonth, String birthYear, UserBean userBean)
			throws Exception {
		boolean isValid = false;
		/* Is no day of month selected? */
		if (birthDay.equalsIgnoreCase(Constants.STRING_DAY)) {
			this.setErrorMessage(Constants.NO_DAY_SELECTED);
		}
		/* Is no month selected? */
		else if (birthMonth.equalsIgnoreCase(Constants.STRING_MONTH)) {
			this.setErrorMessage(Constants.NO_MONTH_SELECTED);
		}
		/* Is no year selected? */
		else if (birthYear.equalsIgnoreCase(Constants.STRING_YEAR)) {
			this.setErrorMessage(Constants.NO_YEAR_SELECTED);
		} else {
			/* To parse BirthDate in dd MMM yyyy format. */
			SimpleDateFormat birthDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);

			/*
			 * Remove lenient to check for invalid date such as 30 February,
			 * etc..
			 */
			birthDateFormat.setLenient(false);

			try {
				/* Parse the day of month, month and year into BirthDate */
				StringBuilder birthDate = new StringBuilder(birthDay);
				birthDate.append(Constants.STRING_SPACE);
				birthDate.append(birthMonth);
				birthDate.append(Constants.STRING_SPACE);
				birthDate.append(birthYear);

				birthDateFormat.parse(birthDate.toString());
				userBean.setBirthDate(birthDate.toString());

				isValid = true;
			}
			/* For Invalid BirthDate */
			catch (ParseException parseException) {
				this.setErrorMessage(Constants.INVALID_BIRTHDATE);
			} finally {
				/* Make null, when no more needed */
				birthDateFormat = null;
			}
		}

		return isValid;
	}

	/**
	 * Check whether the interest(s) is selected or other interest is specified
	 * or not
	 *
	 * @param interests
	 *            Interests
	 * @param otherInterest
	 *            Other Interests
	 * @return boolean True if atlast an interest(s) is selected or other
	 *         interest(s) is specified.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidInterest(String[] interests, String otherInterest) throws Exception {
		/* Check for valid interest(s) */
		boolean isNotValid = interests == null && this.isEmptyInput(otherInterest);

		/* Is not valid interest? */
		if (isNotValid) {
			this.setErrorMessage(Constants.NO_INTEREST);
		}

		return !isNotValid;
	}

	public boolean isSubmitEmpty(String userId,String password,String salutation,String firstName,String middleInitial,String lastName,String sex,String emailId,String birthday,String birthmonth,String birthyear,String[] interest,String otherInterest ) throws Exception {

	     boolean isSubmit = this.equals(userId)&& this.isEmptyInput(password)&&this.isEmptyInput(salutation)&&this.isEmptyInput(firstName)&&this.isEmptyInput(middleInitial)&&this.isEmptyInput(lastName)&&this.isEmptyInput(sex)&&this.isEmptyInput(emailId) && birthday == "Day" &&
	    		 birthmonth == "Month"  && birthyear == "Year"  && interest == null && this.isEmptyInput(otherInterest);

	     if(isSubmit){
	    	 this.setErrorMessage("Please fill all the fields");
	     }

	     return !isSubmit;

		}
	/**
	 * Checks whether the input string is empty or not.
	 *
	 * @param stringInput
	 *            String of input
	 * @return boolean True if stringInput is empty or null, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isEmptyInput(String stringInput) throws Exception {
		/* Is input is null or empty? */
		boolean isEmpty = (stringInput == null || (stringInput.trim()).equals(Constants.STRING_NONE));

		return isEmpty;
	}

	/**
	 * Checks whether the stringInput is valid or not.
	 *
	 * @param stringInput
	 *            String input
	 * @param stringRegex
	 *            criteria for stringInput
	 * @return boolean True if stringInput meets the criteria, otherwise false.
	 * @throws Exception
	 *             If any error occurs
	 */
	public boolean isValidInput(String stringInput, String stringRegex) throws Exception {
		/* Does the String input meets the criteria? */
		return (Pattern.matches(stringRegex, stringInput));
	}
}