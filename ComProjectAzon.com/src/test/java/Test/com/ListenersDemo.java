package Test.com;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenersClass.class)
public class ListenersDemo 
{
	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace2\\ComProjectAzon.com\\driver\\chromedriver.exe");   
		WebDriver  driver =  new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys("9860279749");
		driver.findElement(By.id("pass")).sendKeys("Mahesh@1995");
		driver.findElement(By.xpath("//button[@id=\"loginbutton\"]")).submit();
		String title= driver.getTitle();
		System.out.println(title);
	    AssertJUnit.assertEquals(driver.getTitle(), "");
	}
	@Test
	public void testFail()
    {
    	System.out.println("Failed Test case");
    	Assert.assertTrue(false);
    }
	@Test
	public void testSkip()
    {
    	System.out.println("Skip Test case");
        throw new SkipException("skip exception Thrown.....");
    }
    		
	
}
