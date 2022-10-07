package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
  int counter =0;
  int retrylimit =4;
  
public boolean retry(ITestResult result) 
{
	if(counter< retrylimit)
	  {
		  counter++;
		  return true;
	  }
	  return false;

}


}
