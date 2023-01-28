package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplimentation.class)
	public void retryTest()
	{
		System.out.println("executed");
		Assert.fail();
	}
	
	@Test
	public void retryTest2()
	{
		System.out.println("Executed 2");
	}
	
}
