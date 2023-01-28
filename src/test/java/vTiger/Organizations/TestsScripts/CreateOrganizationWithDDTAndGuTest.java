package vTiger.Organizations.TestsScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplimentationClass.class)
public class CreateOrganizationWithDDTAndGuTest extends BaseClass
{

	@Test
	public void createOrgWithDDtAndGuTest() throws IOException
	{
		//step1 create object of all the required library
		//step2 read all the required data
			//Excel data
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1,2)+jUtil.getRandomNumber();//for random name
		
		//step 3 Launch the browser
		//step4 login to application
		//step5 click on organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step6 click on create organization look up
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step7 create organization with mandatory fields
		 driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step8 click on save button
		driver.findElement(By.name("button")).click();
		 
		//step9 validate
		String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		System.out.println("====organization pass====");
		//step10 logout of app
				
		
		

	}

}
