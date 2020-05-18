package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoC 
{
	@Test
	public void TestA() throws SQLException, InterruptedException
	{
		String url = "jdbc:mysql://localhost:3306/demoA";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement statement = con.createStatement();
		ResultSet resulte = statement.executeQuery("select * from data");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		while(resulte.next())
		{
			String un = resulte.getString("username");
			String pw = resulte.getString("password");
			Reporter.log("username "+un,true);
			driver.findElement(By.id("txtUsername")).sendKeys(un);
			 Reporter.log("password "+pw,true);
			driver.findElement(By.id("txtPassword")).sendKeys(pw);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			Reporter.log("===================",true);
		}
		Thread.sleep(4000);
		driver.close();
	}

}
