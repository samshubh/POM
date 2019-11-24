package com.test;

import org.testng.annotations.Test;

public class InvocationCountExample {
	
    // Here if we want to execute the same test case multiple times, we have method called invocationCount 
	
	@Test(invocationCount=2)
      public void add()
      {
		int a=10;
		int b=20;
		int c= a*b;
		
		System.out.println(c);
		}
    /*
       @Test(invocationTimeOut=2000)
       public void infinteLoop()
       {
    	   int i= 1;
    	   while(i==1)
    	   {
    		   System.out.println(i);
    	   }
       }
       */
	
	   // Here in this example we are handling the test case with exceptions with exception name.class
	
	  @Test(invocationTimeOut=2,expectedExceptions=NumberFormatException.class)
	  public void test1()
	  {
		  String x ="100A";
		  Integer.parseInt(x);
	  }
}
