package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	//initialization
	
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getOrgName() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	/**
	 * This method will create new organization and save it
	 * @param OrgName
	 */
	public void createNewOrg(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create Organization with Industry and save it
	 * @param OrgName
	 */
	public void createNewOrg(String OrgName, String industry)
	{
		orgNameEdt.sendKeys(OrgName);
		handleDropDown(industryDropDown, industry);;
		saveBtn.click();
	}
	
	
	
}
