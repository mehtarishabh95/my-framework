package vTiger.Contacts.TestsScripts;



import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.CreatingNewContactPage;
import vTiger.ObjectRepository.HomePage;

import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplimentationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {
@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContactWithOrgTest() throws IOException 
	{
		//step1 create objects of generic utilities
		//sb base class me gyi
		
		// Read data from excel file
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();
			
		//create an organization and save
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisationLink();
		Reporter.log("--Clicked on organization link",true);//this will print in log also
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("--clicked on create new organization lookup img");
		
		CreateNewOrgPage cno=new CreateNewOrgPage(driver);
		cno.createNewOrg(ORGNAME);
		Reporter.log("--Organization created"+ORGNAME);
		//varify organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headertext = oip.getOrgHeader();
		
		Assert.assertTrue(headertext.contains(ORGNAME));
		
		//step5 click on contacts link
		
		hp.clickOnContactLink();
		//step6 click on contacts lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOncreateContactsLookUpImg();
		
		Reporter.log("--clicked on contact link");
		
		//step7 enter details and select organization and save
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.createNewContact(driver, LASTNAME, ORGNAME);
		Reporter.log("--Contact created"+LASTNAME);
		
		//step8 varify
		ContactInfoPage cip=new ContactInfoPage(driver);
		String header = cip.getContactHeader();
		
		
		Assert.assertTrue(header.contains(LASTNAME));
		System.out.println("====cONTACT CREATED SUCCESSFULLY====");
		
		
	
}}
