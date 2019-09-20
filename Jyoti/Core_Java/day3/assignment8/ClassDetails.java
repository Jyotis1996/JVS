package com.uks.jvs.jyoti.day3.assignment8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class name:ClassDetails
 * Description:Class with constructor and methods
 * @author Jyoti
 * @created date [21-06-2019]
 */
public class ClassDetails {

	private Class<?> _class;
    public ClassDetails(){};
	public void showDetail(String nameOfClass, String typeOfInfo)
	{
		try
		{
			this._class = Class.forName(nameOfClass);
		}
		catch(ClassNotFoundException classNotFoundException) // If input class is not found
		{
			System.out.println("Class not found. Please enter valid class name.");
			return;
		}

		if(typeOfInfo.equalsIgnoreCase("F"))
			showFields();  // Command for class's fields only

		else if(typeOfInfo.equalsIgnoreCase("M"))
			showMethods(); // Command for class's methods only

		else if(typeOfInfo.equalsIgnoreCase("All"))
			showAll();     // Command for constructors, fields and methods

		else
		{
			System.out.println("Invalid argument. Please enter valid argument");
			return;
		}
	}

	/**
	 * Lists the names of fields of class
	 */
	public void showFields()
	{
		System.out.println("\nName of the Fields of " + this._class.getName() + " class");

		Field[] fields = this._class.getDeclaredFields();

		for (int i=0; i<fields.length; i++)
			System.out.println(fields[i].getName());
	}

	/**
	 * Lists the names of methods of class
	 */
	public void showMethods()
	{
		System.out.println("\nName of the Methods of " + _class.getName() + " class");

		Method[] methods = this._class.getDeclaredMethods();

		for (int i=0; i<methods.length; i++)
			System.out.println(methods[i].getName());
	}

	/**
	 * Lists the names of fields, constructors and methods of class
	 */
	public void showAll()
	{
		@SuppressWarnings("rawtypes")
		Constructor[] constructors = this._class.getDeclaredConstructors();

		showFields();

		System.out.println("\nName of the Constructors of " + this._class.getName() + " class");

		for (int i=0; i<constructors.length; i++)
			System.out.println(constructors[i].getName());

		showMethods();
	}
}
