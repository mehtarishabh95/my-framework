package vTiger.Organizations.TestsScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(vTiger.GenericUtilities.ListenersImplimentationClass.class)
public class CreateOrganizationWithDDTTest {

	@Test(groups = "SmokeSuite")
	public void createOrgWithDDTTest() throws EncryptedDocumentException, IOException
	
	{
		Random ran=new Random();
		int random = ran.nextInt(1000);
		
		//step1 read all the data
		/*read data from property file*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj= new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		/*Read data from Excel sheet*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		 String ORGNAME = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+random;
	
		//step2 launch the browser -Run time polymorphism
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//step3 login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step4 click on organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step5 click on create organization look up
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step6 create organization with mandatory fields
		 driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step7 click on save button
		driver.findElement(By.name("button")).click();
		 
		//step8 validate
		String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println(ORGHEADER+" Pass");
		}
		else {
			System.out.println("Fail");
		}
		//step9 logout of app
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
