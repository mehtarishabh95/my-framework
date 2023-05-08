package extraPractice;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

public class HandleAutoSuggestionGoogleTest 
{

	@Test
	public void GoogleAutoSuggestionTest()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("nora fatehi new song");
		List<WebElement> eles = driver.findElements(By.xpath("//div[@class='wM6W7d']/descendant::b[contains(text(),'2023')]"));
		for(WebElement ele:eles)
		{
			String text = ele.getText();
			if(text.contains("2023"))
			{
				ele.click();
				break;
			}
		}
		
	}
	
}
