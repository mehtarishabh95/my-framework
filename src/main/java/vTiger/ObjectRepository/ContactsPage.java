package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	// Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	// initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on create new contact lookup image
	 */
	public void clickOncreateContactsLookUpImg()
	{
		createContactLookUpImg.click();
	}
	
	

}
