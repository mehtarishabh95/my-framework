package vTiger.Practice;

import java.io.IOException;


import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException
	{
		JavaUtility jUtil = new JavaUtility();
		String dt = jUtil.getSystemDate();
		System.out.println(dt);
		
		String dtif = jUtil.getSystemDateInFormat();
		System.out.println(dtif);
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2);
		System.out.println(ORGNAME);
		
		

	}


}
