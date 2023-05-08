package extraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScenarioTest {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable--notification");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("9782045063");
		driver.findElement(By.name("pass")).sendKeys("kamesh22");
		driver.findElement(By.name("login")).click();
		Reporter.log("login successful",true);
		
		String text = driver.findElement(By.xpath("//span[text()='Rishabh Mehta']")).getText();
		Assert.assertTrue(text.equals("Rishabh Mehta"));
		
		Reporter.log("----login succesfull----",true);
		driver.close();
		

	}

}
