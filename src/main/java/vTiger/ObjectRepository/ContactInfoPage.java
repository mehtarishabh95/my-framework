package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[contains(text(),' Contact Information')]")
	private WebElement contactHeaderText;
	
	//initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getContactHeader1() {
		return contactHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture the contact header and return the value
	 * @return
	 */
	public String getContactHeader()
	{
		return contactHeaderText.getText();
	}
	
	

}
