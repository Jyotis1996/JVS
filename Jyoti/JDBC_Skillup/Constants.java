package com.uks.jvs.Jyoti;

/*
 * Class Name:Constants
 * Description:contents all constant values
 */
public class Constants {

	//Day1
	public static final String strtype1driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	public static final String strconnectionStringtype1 = "jdbc:odbc:JVS";
	public static final String strconnectionStringtype4 = "jdbc:mysql://172.16.1.15:3306/northwind_jyoti?useSSL=false";
	public static final String Username = "jyoti";
	public static final String Password = "jyoti@741";
	public static final String strConnectionOpen = "Connection Open";
	public static final String strQuery_Ass1= "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees";
	public static final String strQuery_Ass2= "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees";
	public static final String strQuery_Ass3= "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees";
	public static final String Seperator = "==============================================================================================================================================================";
	public static final String strQUERY2_Ass2= "SELECT EmployeeID, concat(FirstName,' ', LastName) as EmployeeName,Title,concat(Address ,city ,country) as FullAddress,HomePhone FROM employees WHERE EmployeeId=";
	public static final String NORecord =" No Record Found";
	public static final String strSettingsPropertyfile = "D:\\JVS_WS\\JDBC_Skillup\\src\\com\\uks\\jvs\\Jyoti\\Day1\\Assignment3\\settings.properties";

	// Day2
	public static final String strQuery_Ass2_1 = "SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees";
	public static final String Choice = "Enter \n 1) N for NextPage \n 2) P for PreviousPage \n 3) X to Stop the Process";
	public static final String InvalidChoice = "Invalid Choice Please select option from above ";
	public static final String NoRecord = "No Records is there";
	public static final String NoOfRows = "Enter how many rows to display:";
	public static final String Category = "Enter catagory name (Seafood or produce)";
	public static final String Year = "Enter year(1996)";
	public static final String Proper_Input = "Enter proper input";
	public static final String Exit = "You are exited from window";
	public static final String Proper_Option = "Enter proper option or try again";
	public static final String Procedure_call = "{ call SalesByCategory(?,?) }";
	public static final String no_data = "no more data";
	public static final String PageNoZero ="Invalid page number.. Zero cannot be entered as page number";
	public static final String TotalPages="Total pages present: ";
	public static final String Coice_PageNo = "\nEnter 1 : To display data as per page number entered  \nEnter 2 : display all data using next and previous command ";
	public static final String EnterPageNo = "Enter Page number to display data";

	//Day 3
	public static final String Query = "SELECT EmployeeID, FirstName, LastName,Title,date(BirthDate) as DateOfBirth FROM employees";
	public static final String Query1 = "SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees";
	public static final String Choice_Ass1 = "Enter the input 1 for Cached or 2 for XML ";
	public static final String Wrong_Input = "Entered wroung input";
	public static final String Query_ResultSet = "Select * from employees";
	public static final String Before_Inserting = "Before Adding new record";
	public static final String Inserting = "Inserting new Records in Database";
	public static final String New_Record = "New Records added";
	public static final String After_Inserting = "After Adding new record";
	public static final String EmployeeID = "Employee Id is auto incremented so no need to enter employee id";
	public static final String FirstName = "First Name to Insert";
	public static final String LastName = "Last Name to Insert";
	public static final String BirthDate = "Birthdate to Insert";
	public static final String Title = "Title to Insert";
	public static final String EmployeeDetails = "Enter Employee details:";


	//Day 4
	public static final String strconnectionString = "jdbc:mysql://172.16.1.15:3306/northwind_jyoti?useSSL=false";
	public static final String strseparatorline = "**********************************************************************************";
	public static final String strDatabaseMetadata = "Database MetaData:\n";
	public static final String strResultSetMetadata = "ResultSet MetaData:\n";
	public static final String Update_Choice = "Do You want to Update any record?";
	public static final String Command = "SELECT EmployeeID, LastName, FirstName, Title from Employees";
	public static final String Title_Head = "ID \t | FirstName \t | LastName \t | Designation \n";
	public static final String Update = "Enter Employee ID where you want to update:";
	public static final String Enter_Name = "Enter First Name";
	public static final String Enter_lastname = "Enter Last Name";
	public static final String Enter_designation = "Enter Designation";
	public static final String Data_updated = "Data Updated Successfully";
	public static final String No_Record = "Sorry, No Record Found for this EmployeeID...";
	public static final String DriverName = "Driver Name :";
	public static final String DriverVersion ="Driver Version: ";
	public static final String UserName = "UserName: " ;
	public static final String DatabaseName = "Database Product Name: ";
	public static final String DatabaseVersion ="Database Product Version: ";
	public static final String Query_Ass4_2 = "SELECT * FROM Employees";
	public static final String TotalColumns ="Total columns: ";
	public static final String ColumnName ="Column Name of 1st column: ";
	public static final String ColumnType ="Column Type Name of 1st column: ";
}
