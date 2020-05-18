package TestNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerBlog implements ITestListener
{

	public void onFinish(ITestContext context) 
	{
			Reporter.log(" This is on Finish Method "+context.getOutputDirectory());
	}

	public void onStart(ITestContext context) 
	{
		Reporter.log("This is an Start Method "+context.getOutputDirectory());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		Reporter.log("Test Failed But Within Success Percentage "+result.getName(),true);
	}

	public void onTestFailure(ITestResult result)
	{
		Reporter.log("Test failed "+result.getName(),true);
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Test Skipped "+result.getName(),true);
	}

	public void onTestStart(ITestResult result) 
	{
		Reporter.log("New Test started "+result.getName(),true);
	}

	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("Test Successfully "+result.getName(),true);
	}


		

}
