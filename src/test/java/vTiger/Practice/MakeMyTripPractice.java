package vTiger.Practice;

import java.time.Duration;
import java.util.Date;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MakeMyTripPractice 
{
	public WebDriver driver;
	
	
	@Test
	public void selectAnyDateInDOM() throws InterruptedException
	//month ki koi bhi date lelo
	{
System.out.println("start");
		
		driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	
	Thread.sleep(1000);
	/*Actions act = new Actions(driver);//jo ads aa re h unhe htane k liye
	act.moveByOffset(10, 10).click().perform();//day 41 dkh lo
	*/
	driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
	
		
		
	System.out.println("1 start");
	driver.findElement(By.xpath("//span[text()='From']")).click();
	WebElement from = driver.findElement(By.xpath("//input[@autocomplete='off']"));
	from.sendKeys("mumbai");
	driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
	
	driver.findElement(By.xpath("//span[text()='To']")).click();
	WebElement to = driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']"));
	to.sendKeys("chennai");
	driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
	
	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	
	driver.findElement(By.xpath("//p[text()='17']")).click();
	Thread.sleep(5000); //dkh lo kaam bhi kiya ya nhi
	
	driver.close();
	System.out.println("1 pass");
	
	}
	
	@Test
	public void selectCurrentDateOfMonth() throws InterruptedException
	//system date capture krni pdegi
	{
System.out.println("start");
		
		driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	
	Thread.sleep(1000);
	/*Actions act = new Actions(driver);//jo ads aa re h unhe htane k liye
	act.moveByOffset(10, 10).click().perform();//day 41 dkh lo
	*/
	driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
	
		
		
		System.out.println("2 start");
		//to capture system date
		Date d=new Date();
		String dArr = d.toString();
		System.out.println(dArr);//format pta chl jayega
		
		String[] arr = dArr.split(" ");
		//inspect krne k baad div me date ka format check krna day month date year hai wha see xpath
		//ab format me jmao us format me convert krne k liye taki xpath likh ske
		String day = arr[0];
		String month = arr[1];
		String date = arr[2];
		String year = arr[5];
		
		String travelDate = day+" "+month+" "+date+" "+year;
		
		System.out.println("2 continue");
		
		driver.findElement(By.xpath("//span[text()='From']")).click();	
		WebElement from = driver.findElement(By.xpath("//input[@autocomplete='off']"));
		from.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		WebElement to = driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']"));
		to.sendKeys("chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		//ab dynamic xpath me jayenge or xpath me 1 tag uper chlenge kuki date dynamic h
		
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		Thread.sleep(5000); //dkh lo kaam bhi kiya ya nhi
		driver.close();
		System.out.println("2 passed");
		}
	
		@Test
		public void selectFutureDate() throws InterruptedException
		{
			System.out.println("start");
			
			driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(1000);
		/*Actions act = new Actions(driver);//jo ads aa re h unhe htane k liye
		act.moveByOffset(10, 10).click().perform();//day 41 dkh lo
		*/
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		
			
			
			
			driver.findElement(By.xpath("//span[text()='From']")).click();
			WebElement from = driver.findElement(By.xpath("//input[@autocomplete='off']"));
			from.sendKeys("mumbai");
			driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
			
			driver.findElement(By.xpath("//span[text()='To']")).click();
			WebElement to = driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']"));
			to.sendKeys("chennai");
			driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
			
			driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
			
			//now taking help of infinite for loop
			//infinite while loop bhi le skte h
			for(;;)
			{
				try
				{
					
					driver.findElement(By.xpath("//div[@aria-label='Sat Dec 02 2023']")).click();
					break;
				}
				catch (Exception e)
				 
				{

					driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
					//next month ka xpath likha ism y date check krega.....jb tk try krega tb tk mil n jaye

				}
			}
			
		}
	
}
