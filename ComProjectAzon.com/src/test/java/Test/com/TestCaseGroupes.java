package Test.com;

import org.testng.annotations.Test;

public class TestCaseGroupes
{
   @Test(groups = {"smoke"})
   public void TC1()
   {
	System.out.println("This is T1 Logic");
   }
   @Test(groups= {"Sanity"})
   public void TC2()
   {
	   System.out.println("This is T2 Logic");
   }
   @Test(groups= {"Sanity","smoke"})
   public void TC3()
   {
	   System.out.println("This is T3 Logic");
   }
   @Test(groups= {"Regression"})
   public void TC4()
   {
	   System.out.println("This is T4 Logic");
   }
   @Test(groups= {"Sanity","Regression"})
   public void TC5()
   {
	   System.out.println("This is T5 Logic");
   }
	
}
