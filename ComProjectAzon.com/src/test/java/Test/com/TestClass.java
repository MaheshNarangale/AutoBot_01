package Test.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass 
{

	WebDriver driver;
	
	@BeforeMethod
    public void SetUp()
    {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace2\\ComProjectAzon.com\\driver\\chromedriver.exe");   
		 driver =  new ChromeDriver();
   	     driver.manage().window().maximize();
   	     driver.manage().deleteAllCookies();
   	     driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
   	     driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
   	     driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
    }
    @Test
    public void Login()
    {
    	driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Xyz");
		 driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("abcd");
		 driver.findElement(By.xpath("//input[@name=\"reg_email__\"]")).sendKeys("Xyz1996@gmail.com");
		 driver.findElement(By.xpath("//input[@name=\"reg_email_confirmation__\"]")).sendKeys("Xyz1996@gmail.com");
		 driver.findElement(By.xpath("//input[@name=\"reg_passwd__\"]")).sendKeys("123456");
		 driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		 WebElement element =driver.findElement(By.xpath("//select[@id='day']"));
		 Select sel  = new Select(element) ;
		 sel.selectByIndex(5);
		 WebElement element2 = driver.findElement(By.xpath("//select[@id='month']"));
		 Select sele = new Select(element2);
		 sele.selectByVisibleText("May");
		 driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		 WebElement element3 = driver.findElement(By.xpath("//select[@name=\"birthday_year\"]"));
		 Select selen = new Select(element3);
		 selen.selectByVisibleText("2019");
		 driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@value=\"2\"]")).click();
    }
   
  	  
}
