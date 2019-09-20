package com.uks.Jyoti.core.day3.assignment8;

/**
 * Class Name:Class Info
 * Description:View the fields, methods and constructors of ClassDetail class
 * @author Jyoti
 *
 */

public class ClassInfo {

	public static void main(String[] args)
	{
		try
		{
			if(args.length != 2) // If neither class name nor type of info is passed
			{
				System.out.println("Please enter the name of class and type of info as arguments.");
				return;
			}

			ClassDetails classDetail = new ClassDetails();
			classDetail.showDetail(args[0],args[1]);

		}
		catch(NullPointerException nullPointerException)
		{
			System.out.println("Nothing was found in argument.");
		}
	}

}
