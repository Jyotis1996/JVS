package com.uks.Jyoti.core.day1.assignment2;

/*
 * Class Name :TestAccessMod
 * Description : Access Variables and Method of AccessMod Class
 * Created:Jyoti [19-06-2019]
 */
public class TestAcessMod{
	public static void main(String[] args){
		AccessMod objaccessmod = null;

		try {
			objaccessmod = new AccessMod();// Object initialization
			objaccessmod.printProperties();// Call Method
			System.out.println("****************************************************");
			System.out.println("Value of integer variable:"+objaccessmod.intVariable);
			System.out.println("Value of character variable:"+ objaccessmod.charVariable);
			System.out.println("Value of boolean variable:"+ objaccessmod.flag);
			System.out.println("Value of float variable:"+objaccessmod.floatNumber);
			System.out.println("Value of double variable:"+objaccessmod.doubleNumber);
			System.out.println("Value of long variable:"+ objaccessmod.longNumber);
			// Here We can't print String Variable because of Private Access Modifier
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objaccessmod = null;
		}
	}
}