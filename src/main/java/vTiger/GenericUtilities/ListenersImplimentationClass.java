package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentationClass implements ITestListener
{
	
	ExtentReports report;//making it global so we can use inside multiple methods
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		 String methodName = result.getMethod().getMethodName();//want to take name of the method
		 //System.out.println("----"+methodName+" --Execution started----"); log use kr rhe h to no need
		 test=report.createTest(methodName);
		 test.log(Status.INFO, "Execution Started-"+methodName);
		 
		 
	}

	public void onTestSuccess(ITestResult result) 
	{
		 String methodName = result.getMethod().getMethodName();//want to take name of the method 
		 //System.out.println("----"+methodName+" --Test script passed----");
		 test.log(Status.PASS, "Test Script Passed-"+methodName);
	}

	public void onTestFailure(ITestResult result)
	{
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		 String methodName = result.getMethod().getMethodName();//want to take name of the method 
		// System.out.println("----"+methodName+" --Test script failed----");
		// System.out.println(result.getThrowable());//to print what exception it throws for failure
		 test.log(Status.FAIL, "Test Script Failed-"+methodName);
		 test.log(Status.FAIL, result.getThrowable());
		 
		 String screenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
		 try {
			String path = wUtil.takeScreenshot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path); //it will atach screenshot to the path
			/* kuki screenshot report me attach krna h pr jvm to dot(.) ka mtlb janta h pr extent
			 * report external tool h isliye ki wo path ko shi s smjhe uske liye path likha
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	public void onTestSkipped(ITestResult result) 
	{
		 String methodName = result.getMethod().getMethodName();//want to take name of the method 
		// System.out.println("----"+methodName+" --Test script skipped----");
		//System.out.println(result.getThrowable());//to print what exception it throws for skipped
		 test.log(Status.SKIP, "Test Script Skipped-"+methodName);
		 test.log(Status.SKIP,result.getThrowable());//kis wjh se fail hua wo dega
		 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	 
	}

	public void onStart(ITestContext context) //this interface gives status of suite
	{
		System.out.println("----Suite Execution Started------");
		/*extentReports in folder 
		 * report.html in name of file
		 * in between report and html system is appended
		 * */
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Vtiger ExecutionReport");
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Os", "Windows");
		report.setSystemInfo("Reporter name","Rishabh");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("-------Suite Execution finished-------"); 
		report.flush();//it will tell extentReports that execution is complete generate report
	}

}
