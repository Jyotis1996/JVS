package com.assignment1.common;

/**
 * Represents the messages including label, string, path

 */
public class Constants {


	//Connection variables
		public static final String DB_DriverName = "DBname";
		public static final String DB_URL="URL";
		public static final String DB_username  = "Username" ;
		public static final String Db_password = "Password";
		public static final String PATH="com.assignment1.common.database";
		public static final String CONNECTION="Database Connected !!!!";
		public static final String DISCONNECTION="Database Disonnected !!!!";

		public static final String RECORD_DELETE = "Records Deleted Successfully...";
		public static final String RECORD_ADDED = "Record added Successfully...";
		public static final String RECORD_ERROR = "Some problem occured please check registration details";
		public static final String RECORD_UPDATE = "Updated Successfully...";


		public static final String INSERT_QUERY = "insert into UserDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public static final String SELECT_QUERY="select * from userdetails";
		public static final String UPDATE_QUERY = "update userdetails set salutation=?, FirstName=?,MiddleInitial=?, LastName=?, Sex=?,EmailId=?,Birthdate=?,Address=?,AreaOfInterest=?,OtherInterest=?,Category=? where UserId=? and Password=?";
		public static final String DELETE_QUERY ="delete from userdetails where USERID='";
		public static final String USERLIST_QUERY = "select * from userdetails Order BY USERID ASC";



}