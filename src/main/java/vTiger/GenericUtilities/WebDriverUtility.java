package vTiger.GenericUtilities;


import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consists of generic methods related to webDriver actions
 * @author User
 *
 */
public class WebDriverUtility 
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for 20 seconds for all the elements to get loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This method will wait until a particular element becomes visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver , WebElement element)
	{	//for example we want to do mouseHover so in that case visibility needed we can use it there
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait until a particular element becomes click able
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element)
	{	//in the case of clicking sending data we need that element to be clicked so we can use it 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element)); 
	}
	/**
	 * This method will handle drop down by using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index); 
	}
	/**
	 * This method will handle drop down by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) 
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will handle drop down by using text
	 * @param element
	 * @param text
	 */
	public void handleDropDown( String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse Hover action on a specified element
	 * @param driver
	 * @param element
	 */
	
	/*Basically mouse se job bhi actions ho skte h wo apn actions class se krenge
	 * jaise ki right click , double click drag and drop , mouse hover
	 */
	public void mouseHoverAction(WebDriver driver , WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();            
		
	}
	/**
	 * This method will double click anywhere on web page
	 * @param driver
	 * @param element
	 */
	public void doubleClicAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will double click on a specified element on web page
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver , WebElement element)
	{
		Actions act =new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will right click anywhere on web page
	 * @param driver
	 */
	 public void rightClickAction(WebDriver driver)
	 {
		 Actions act =new Actions(driver);
		 act.contextClick().perform();
	 }
	 /**
	  * This method will right click on specified element on web page
	  * @param driver
	  * @param element
	  */
	 public void rightClickAction(WebDriver driver , WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	  /**
	   * This method will drag and drop a element from source to destination
	   * @param driver
	   * @param src
	   * @param dest
	   */
	 public void dragAndDropAction(WebDriver driver , WebElement src , WebElement dest)
	 {
		 Actions act = new Actions(driver);
		 act.dragAndDrop(src, dest).perform();
	 }
	 /**
	  * This method will switch to frame based on index
	  * @param driver
	  * @param frameIndex
	  */
	 public void switchToFrame(WebDriver driver , int frameIndex)
	 {
		 driver.switchTo().frame(frameIndex);
	 }
	/**
	 * This method will switch to frame based on frame name or frame Id
	 * @param driver
	 * @param frameIdOrName
	 */
	public void switchToFrame(WebDriver driver , String frameIdOrName)
	{
		driver.switchTo().frame(frameIdOrName);
	}
	/**
	 * This method will switch to frame based on Web element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver , WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will switch back to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver )
	{
		driver.switchTo().parentFrame();
	}
	/**.
	 * This method will switch back to default frame
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver )
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will get the text of alert pop up and return it to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will switch to the window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver , String partialWinTitle)
	{
		//step1 capture all the window ids
		Set<String> winIds = driver.getWindowHandles();
		//step2 extract individual window Id
		for(String winId : winIds)
		{
			//step3 capture the current window title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			//step4 compare the current window title with required window title
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
		
		
	}
	/**
	 * This method will take screenshot and store into a folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver ,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;	//Up-casting
		File src = ts.getScreenshotAs(OutputType.FILE); //getter method
		File dest=new File(".\\ScreenShots\\"+screenShotName+".png");
		FileUtils.copyFile(src, dest); //from commons io dependency
		
		return dest.getAbsolutePath(); // for extent report(report me attach krenge screenshot k sath)
	
	}
	/**
	 * This method will scroll downwards randomly
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll downward until the specific element found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy("+x+","+y+")",element);
	}
}


