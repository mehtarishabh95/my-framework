package vTiger.Organizations.TestsScripts;

import org.testng.annotations.Test;





import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplimentationClass.class)
public class CreateMultipleOrgTest extends BaseClass
{
		
	@Test(dataProvider = "readDataFromExcel")
	public void createmultiorgTest(String ORG, String INDUSTRY) throws IOException
	{
		String ORGNAME = ORG+jUtil.getRandomString(4);
		//Step1 read all data from external file
		// Step2 launch browser
		//Step3 login to browser
		//Step4 click on orgnizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		//step5 click on orglookup image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step6 create org with ind and save it
		CreateNewOrgPage cnp=new CreateNewOrgPage(driver);
		cnp.createNewOrg(ORGNAME,INDUSTRY);
		//Step7 varify
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrgHeader();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		System.out.println("====ORGNIZATIONS CREATED SUCCESSFULLY====");
		
		//Step8 logout
		
	}
	
	@DataProvider
	public Object [][] readDataFromExcel() throws EncryptedDocumentException, IOException
	{
		
		 Object[][] data = eUtil.readMultipleData("MultipleOrg");
		return data;
	}
}
