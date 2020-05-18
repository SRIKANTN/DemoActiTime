package TestNGListener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(TestNGListener.ListenerBlog.class)
public class TestNGListenerTest
{
	@Test
	public void Test1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		String etitle = "OrangeHRM";
		String atitle = driver.getTitle();
		Assert.assertEquals(atitle, etitle);
		driver.close();
		
	}
	
	@Test
	public void Test2()
	{
		Reporter.log("On Test failed",true);
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "Test2")
	public void Test3()
	{
		Reporter.log("On Test Skipped",true);
	}
	private int i =0;
	@Test(successPercentage = 60, invocationCount = 2)
	public void Test4()
	{
		i++;
		Reporter.log("Test Failed But Within Success Percentage Test Method, Invocation :"+ i);
		if(i == 1 || i ==2 )
		{
			Reporter.log("Test4 Failed",true);
			Assert.assertEquals(i, 6);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
