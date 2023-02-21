package vTiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintAllMiPhones 
{

	@Test
	
	public void amazonMiphonesPrint()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hmh5l8jr5_e&adgrpid=61764313147&hvpone=&hvptwo=&hvadid=610644605475&hvpos=&hvnetw=g&hvrand=12984642748375515594&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007805&hvtargid=kwd-327061083&hydadcr=14455_2316418&gclid=EAIaIQobChMIpqa8hPCU_QIVlJhmAh2uqA4vEAAYASAAEgK6OvD_BwE");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mi phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> eles = driver.findElements(By.xpath("//span[contains(text(),'Redmi')]"));
		
		for(WebElement b:eles)
		{
			String t = b.getText();
			System.out.println(t);
						
		}
		
	}
}
