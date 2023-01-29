package vTiger.Organizations.TestsScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplimentationClass.class)
public class CreateNewOrganizationWithIndustryTest extends BaseClass
{

	@Test(groups ={"SmokeSuite","RegressionSuite"})
	public void createNewOrgWithIndTest() throws IOException
	{
		//step1 create object for all library
		//step2 read all the required data
		//from property file
		//from excel
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber()+jUtil.getRandomString(3);
		String INDUSTRY = eUtil.readDataFromExcel("Organizations", 4, 3);
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
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println("====NewOrganizationWithIndustry PASS====");
		//step9 logout of app
		
		
		
		
		
	}

}
