package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//img[contains(@onclick,'contact_account_address')]")
	private WebElement orgNameSelectLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	//initialization
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrgNameSelectLookUpImg() {
		return orgNameSelectLookUpImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business  Library
	/**
	 * This method will create new contact and save it
	 * @param LastName
	 */
	public void createNewContact(String LastName)
	{
		lastNameEdt.sendKeys(LastName);
		saveBtn.click();	
	}

	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param LastName
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver,String LastName, String ORGNAME)
	{
		lastNameEdt.sendKeys(LastName);
		orgNameSelectLookUpImg.click();
		switchToWindow(driver, "Accounts");//switching window
		searchEdt.sendKeys(ORGNAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click(); /*here xpath is dynamic
		 so we can not find it by using @find annotation and new organization will create every time
		 so before creating new orgnization we can not inspect it .it will happen during runtime*/
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
	
	
	

}
