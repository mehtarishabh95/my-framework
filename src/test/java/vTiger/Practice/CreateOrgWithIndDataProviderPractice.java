package vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndDataProviderPractice extends BaseClass
{

	@Test(dataProvider = "org",groups = "smokeSuit")
	public void createNewOrgWithIndTest(String ORGNAME , String INDUSTRY) throws IOException
	{
		//from excel
		//step3 launch browser
	
		//step 4 login to application
	
		//step 5 click on organizations link
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		// step6 click on oraganization look image
		
		OrganizationsPage oP=new OrganizationsPage(driver);
		oP.clickOnCreateOrgLookUpImg();
		
		// step 7 enter details into create new organizations page and save
		
		CreateNewOrgPage newOp=new CreateNewOrgPage(driver);
		newOp.createNewOrg(ORGNAME, INDUSTRY);
		
		//step 8 varify 
		
		OrganizationInfoPage oiP=new OrganizationInfoPage(driver);
		String OrgHeader = oiP.getOrgHeader();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+"--pass");
		}
		else {
			System.out.println("Fail");
		}
		
		//step9 logout of app
		
		
		
		
		
		
	}
	@DataProvider(name="org")
	public Object [][] orgwithinddata()
	{
		Object [][] data=new Object [4][2];
		data [0][0]="Wiprozs"+jUtil.getRandomString(5);
		data [0][1]="Healthcare";
		
		data [1][0]="Crompton"+jUtil.getRandomString(5);
		data [1][1]="Healthcare";
		
		data [2][0]="Bajaj"+jUtil.getRandomString(5);
		data [2][1]="Healthcare";
		
		data [3][0]="hero"+jUtil.getRandomString(5);
		data [3][1]="Healthcare";
		
		return data;
		
		
		
	}


}


