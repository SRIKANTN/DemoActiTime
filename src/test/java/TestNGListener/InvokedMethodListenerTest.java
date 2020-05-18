package TestNGListener;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(value =InvokedMethodListener.class )
public class InvokedMethodListenerTest 
{
	@Test
	public void test1()
	{
		Reporter.log("My first test",true);
	}
	
	@Test
	public void test2()
	{
		Reporter.log("My second test",true);
	}
	@BeforeClass
	public void setUp()
	{
		Reporter.log("Before class method",true);
	}
	@AfterClass
	public void cleanUp()
	{
		Reporter.log("After class method",true);
	}
	
}
