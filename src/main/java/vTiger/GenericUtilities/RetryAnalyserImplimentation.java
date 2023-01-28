package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class will provide implimentation to the retryanalyser interface of testNG
 * @author User
 *
 */
public class RetryAnalyserImplimentation implements IRetryAnalyzer
{
	int count=0;
	int retryCount=3;

	public boolean retry(ITestResult result) 
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		
		return false;
	}

}
