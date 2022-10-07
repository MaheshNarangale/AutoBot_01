package Test.com;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener  
{
  public void onStart(ITestContext Result) 
  {
	  System.out.println("on Start method invokeed");
  }
  public void onFinish(ITestContext Result)
  {
	  System.out.println("on Finsih method invokeed");
  
  }
  public void onTestFailure(ITestResult Result)
  {
	  System.out.println("Name of test method failed:"+Result.getName());
  }
  public void onTestSkipped(ITestResult Result)
  {
	  System.out.println("Name of test method Skipped:"+Result.getName());
  }
  public void onTestStart(ITestResult Result)
  {
	  System.out.println("Name of test method Start:"+Result.getName());
  }
  public void onTestSuccess(ITestResult Result)
  {
	  System.out.println("Name of test method Sucessfully:"+Result.getName());
  }
  public void onTestFailedButWithinSSuccessPercentage(ITestResult Result)
  {
	 
  }
}
