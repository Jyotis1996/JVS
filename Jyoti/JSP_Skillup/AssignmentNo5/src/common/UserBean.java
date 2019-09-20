package common;

/**
 * Represents the user details
 *
 */
public class UserBean {

	/* User detail fields */
	private String userId;
	private String password;
	private String salutation;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String sex;
	private String emailId;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String birthDate;
	private String address;
	private String[] areaOfInterest;
	private String otherInterests;

	/**
	 * Default constructor to initialize object with blank values
	 */
	public UserBean() {
		this.userId = Constants.STRING_NONE;
		this.password = Constants.STRING_NONE;
		this.salutation = Constants.STRING_NONE;
		this.firstName = Constants.STRING_NONE;
		this.middleInitial = Constants.STRING_NONE;
		this.lastName = Constants.STRING_NONE;
		this.sex = Constants.STRING_NONE;
		this.emailId = Constants.STRING_NONE;
		this.birthDay = Constants.STRING_NONE;
		this.birthMonth = Constants.STRING_NONE;
		this.birthYear = Constants.STRING_NONE;
		this.birthDate = Constants.STRING_NONE;
		this.address = Constants.STRING_NONE;
		this.otherInterests = Constants.STRING_NONE;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return this.salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleInitial
	 */
	public String getMiddleInitial() {
		return this.middleInitial;
	}

	/**
	 * @param middleInitial
	 *            the middleInitial to set
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return this.emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

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

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return this.birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the areaOfInterest
	 */
	public String[] getAreaOfInterest() {
		return this.areaOfInterest;
	}

	/**
	 * @param areaOfInterest
	 *            the areaOfInterest to set
	 */
	public void setAreaOfInterest(String[] areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	/**
	 * @return the otherInterests
	 */
	public String getOtherInterests() {
		return this.otherInterests;
	}

	/**
	 * @param otherInterests
	 *            the otherInterests to set
	 */
	public void setOtherInterests(String otherInterests) {
		this.otherInterests = otherInterests;
	}
}