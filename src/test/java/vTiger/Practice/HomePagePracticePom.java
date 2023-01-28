package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class HomePagePracticePom {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String URL = pObj.getProperty("url");
		driver.get(URL);
		
		WebDriverUtility wUtil=new WebDriverUtility();

		LoginPage lp=new LoginPage(driver);
		 lp.getUsernameEdt().sendKeys("admin");
		 lp.getPasswordEdt().sendKeys("admin");
		 lp.getLoginBtn().click();
		 
		 HomePage hp=new HomePage(driver);
		 hp.getContactsLnk().click();
		 WebElement element = hp.getAdministratorImg();
		 wUtil.mouseHoverAction(driver, element);
		 
		 hp.getSignoutLnk().click();
		 
	}

}
