package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassPractice 
{
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite base class");
	}
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("before class base class");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("after suite base class");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class base class");
		
	}
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method base class");
	}
	@AfterMethod
	public void amConfig()
	{
		System.out.println("after method base class");
	}
	@Test
	public void tConfig()
	{
		System.out.println("test1 base class");
	}
	@Test
	public void tCofig()
	{
		System.out.println("tset2 base class");
	}
	@BeforeTest
	public void bcTest()
	{
		System.out.println("before Test ");
	}
	@AfterTest()
	public void afterTest()
	{
		System.out.println("After test ");
	}

}
