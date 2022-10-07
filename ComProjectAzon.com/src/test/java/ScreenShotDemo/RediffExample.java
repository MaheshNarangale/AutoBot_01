package ScreenShotDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RediffExample 
{
	
	WebDriver driver;
	@BeforeTest // PreCondition
	public void beforTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace2\\ComProjectAzon.com\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public void TitleTest()
	{
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		String actual = driver.getTitle();
		Assert.assertEquals(actual, "Rediffmail");
	}
	@Test(priority=2)
	public void remeberMeTest()
	{
	    boolean actualStatus = driver.findElement(By.xpath("//input[@id=\"remember\"]")).isSelected();
	    Assert.assertEquals(actualStatus, false);
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception
	{
		//System.out.println("Hi");
		if(result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot tc = (TakesScreenshot)driver; // convert driver to takeScreenShot type
			File src= tc.getScreenshotAs(OutputType.FILE);// it will take ScreenShot but will store into Java's.
		    File  target	=new File(result.getName()+".png");
			FileHandler.copy(src,target );
		}
		
	}
	@org.testng.annotations.AfterTest // Post Condition
	public void AfterTest()
	{
		driver.manage().timeouts().implicitlyWait(800,TimeUnit.SECONDS);
		//driver.close();
	}

}
