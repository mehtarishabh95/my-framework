package extraPractice;

import java.io.IOException;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class CreateContactTest
{
	@Test
	public void createContact() throws IOException
	{
		//step1 read data
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String BROWSER =pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME= pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		eUtil.readDataFromExcel("Contacts", 1, 2);
		
		//Launch  browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase(BROWSER))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
		}
		//enter url and wait maxmize......
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		//click on create contacts lookup img
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//enter necessary fields
		
		
	}
	
}
