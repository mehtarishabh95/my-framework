package extraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InterviewQuestiionEststerTest {

	public static void main(String[] args) 
	{
		
				WebDriver driver=new ChromeDriver();
				//enter the url
				
				driver.manage().window().maximize();
				driver.get("https://estater.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement element = driver.findElement(By.xpath("//div[@class='item item_1']"));
				JavascriptExecutor js=(JavascriptExecutor) driver;
				int x=element.getLocation().getX();
				int y=element.getLocation().getY();
				js.executeScript("window.scrollBy("+x+","+y+")",element);
				driver.findElement(By.xpath(" //li[text()=' Kuwait']")).click();
				WebElement element1 = driver.findElement(By.xpath("//span[text()='Show All']"));
				js.executeScript("window.scrollBy(0,500)","");
				element1.click();
				driver.findElement(By.xpath("//a[text()='Dasma']")).click();
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1");
				driver.findElement(By.xpath("//span[@class='item1']")).click();
				driver.findElement(By.xpath("//div[@class='proItem top']")).click();
				String text = driver.findElement(By.xpath("//h1[text()='Dasma, Block 1, Parcel 80, House No 7']")).getText();
				Assert.assertTrue(text.contains("House No 7"));
				System.out.println("test case passed");
				driver.close();
	}

}
