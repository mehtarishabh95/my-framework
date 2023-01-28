package vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class LogoutPractice 
{

	@Test
	public void sabs() throws IOException
	{
		//step1 create object for all library
				JavaUtility jUtil=new JavaUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				
				//step2 read all the required data
				//from property file
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				//from excel
				String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
				String INDUSTRY = eUtil.readDataFromExcel("Organizations", 4, 3);
				//step3 launch browser
				WebDriver driver=null;
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("FIREFOX"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid browser");
				}
				
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);
				
				//step 4 login to application
				
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				HomePage hp=new HomePage(driver);
				hp.logoutOfApp(driver);
				System.out.println("test done");
				

	}
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite");
	}
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("before class");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("after suite");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class");
		
	}
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method");
	}
	@AfterMethod
	public void amConfig()
	{
		System.out.println("after method");
	}
	@Test
	public void tConfig()
	{
		System.out.println("test1");
	}
	@Test
	public void tCofig()
	{
		System.out.println("tset2");
	}

}
