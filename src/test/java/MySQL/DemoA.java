package MySQL;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoA 
{
	static ExtentReports reports;
	static ExtentTest test;
	@BeforeTest
	public void startReports()
	{

		reports = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = reports.startTest("Extent Demo");
	}
	
	
	@Test
	public void testDemo()
	{
		Date time = test.getStartedTime();
		System.out.println(time);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		if(driver.getTitle().equals("Googles"))
		{
			test.log(LogStatus.PASS, "Navigate to specifed url");
		}
		else
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(getScreenShots(driver))+" test failed");
		}
	driver.close();
	}
	
	@Test(dependsOnMethods = "testDemo")
	public void testDemoA()
	{
		test.log(LogStatus.SKIP, "This method is skiped");
	}
	
	@Test
	public void testDemoB()
	{
		test.log(LogStatus.FATAL, "Test method failed");
		Assert.fail();
	}
	public static  String getScreenShots(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./reports/"+System.currentTimeMillis()+".png");
		String efile = dest.getAbsolutePath();
		try 
		{
			Files.copy(src, dest);
		}
		catch (IOException e)
		{
		}
		return efile;
	}
	@AfterTest
	public void endtest()
	{
		reports.endTest(test);
		reports.flush();
	}
}
