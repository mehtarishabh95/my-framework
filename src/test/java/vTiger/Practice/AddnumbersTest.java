package vTiger.Practice;

import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

/**
 * @author User
 *
 */
public class AddnumbersTest 
{

	@Test
	public  void addnumbersTest() 
	{
		// TODO Auto-generated method stub
		
		int c =add(10,20);
		System.out.println(c);

	}

public static int add(int a,int b)
		{
			int c=a+b;
			return c;
			
		}}