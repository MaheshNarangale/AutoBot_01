package ExtentReportDemo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class basicExtentReport 
 {
	//private static final String ITResult = null;
	ExtentSparkReporter htmlReporter;
    ExtentReports report;
    ExtentTest test;
    
    @BeforeTest
    public void startReport()
     {
       htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
       report = new ExtentReports();
       report.attachReporter(htmlReporter);
       
       // add envrionment details
       report.setSystemInfo("Machine" ,"testpc1");
       report.setSystemInfo("OS" ,"Window 11");
       report.setSystemInfo("user" ,"Mahesh");
       report.setSystemInfo("Browser" ,"chrome");
       
       // configuration to change look and feel
       
      htmlReporter.config().setDocumentTitle("Extent Report Demo");
      htmlReporter.config().setReportName("Test Report ");
      htmlReporter.config().setTheme(Theme.STANDARD);
      htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a'('zzz')'");

     }

@Test
public void LaunchBrowserAndOpenURL()
  {
       test= report.createTest("Launch browser and open url");
       Assert.assertTrue(false);
  }
@Test
public void VerifyTitle()
  {
       test= report.createTest("Verify Title ");
       Assert.assertTrue(false);
  }
@Test
public void VerifyLogo()
  {
       test= report.createTest("Verify logo");
       Assert.assertTrue(true);
  }
@Test
public void VerifyEmail()
  {
       test= report.createTest("Launch browser and open url");
       throw new SkipException("skipping this test case with exception");
  }
@Test
public void VerifyUserName()
  {
       test= report.createTest("Verify Username");
       Assert.assertTrue(true);
  }

@AfterMethod

public void getTestResult(ITestResult result)
 {
   if(result.getStatus()==ITestResult.FAILURE)
    {
      test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"FAIL",ExtentColor.RED));
      test.fail(result.getThrowable());
    }
   else if(result.getStatus()==ITestResult.SUCCESS)
    {
      test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"PASS" ,ExtentColor.GREEN));
    }
   else if(result.getStatus()==ITestResult.SKIP) 
    {
      test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"SKIP" ,ExtentColor.YELLOW));   
    }
 }

@AfterTest()

public void tearDown()
   {
     report.flush();
   }

}

