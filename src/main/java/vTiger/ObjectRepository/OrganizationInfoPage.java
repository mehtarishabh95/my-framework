package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	//Declaration
	@FindBy(xpath = "//span[contains(text(),'Organization Information')]")
	private WebElement OrgHeaderText;
	
	//initialization
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method will capture the header and return it to caller
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
		
	}

}
