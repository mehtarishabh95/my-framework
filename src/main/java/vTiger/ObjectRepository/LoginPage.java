package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule1 create pom class for every webPage
						// Rule2 class name should be title of page and ending with "Page"
{
	//Rule3 Identify the webelement using @FindBy , @FindAll ,@FindBys annotations
	@FindBy(name="user_name") private WebElement usernameEdt;
	
	@FindBy(name="user_password") private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule4 Create a constructor to initialize the variables/webElements
	public LoginPage(WebDriver driver) //it will take updated driver reference during performing a task
	{
		PageFactory.initElements(driver, this);
	}
	
	
//Rule5 provide getters to access the web elements
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business library-like generic but only for vTiger
	/**
	 * This method will login to vTiger
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME , String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);;
		loginBtn.click();
	}
	
	

	
	

}
