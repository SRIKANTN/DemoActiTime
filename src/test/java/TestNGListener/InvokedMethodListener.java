package TestNGListener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class InvokedMethodListener implements IInvokedMethodListener
{

	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		Reporter.log("After Invocation of "+method.getTestMethod().getMethodName()+"Of class "+testResult.getTestClass(),true);
		
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) 
	{
		Reporter.log("Before Invocation of "+method.getTestMethod().getMethodName()+"Of class "+testResult.getTestClass(),true);		
	}

}
