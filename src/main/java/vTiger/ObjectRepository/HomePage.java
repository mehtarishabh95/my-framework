package vTiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Identify the elements using @findby , @findall , @findbys annotations
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
	@FindBy(xpath = "//img[contains(@style,'width:16p')]")
	private WebElement homeImg;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Create a constructor to initialize variables
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//provide getters to access webelements
	
	
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getHomeImg() {
		return homeImg;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//Business library
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganisationLink()
	{
		organizationLnk.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactLink()
	{
		contactsLnk.click();
	}
	
	/**
	 * This method will logout of application
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		 mouseHoverAction(driver, administratorImg);
		 signoutLnk.click();
	}
	
	
	
	
		
}
