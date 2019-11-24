package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.util.TestUtil;

public class DataDrivenConcept {
	
	
   WebDriver driver;
	
	@BeforeMethod
	 public void setUp() throws InterruptedException
	 {
        System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.kiposcollective.com/#/");  
		
		 driver.findElement(By.xpath("//div[@class='col-lg-4 col-xl-4 col-md-5 col-sm-4 col-8 sign-right order-aline-2 ng-scope']//span[@class='btn btn-login'][contains(text(),'Signup')]")).click();
		 
		   Thread.sleep(5000);

	}
	
	@DataProvider
	
	  public Iterator<Object[]> getData()
	  {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		
		 return testdata.iterator();
		
	  }
	
	@Test(dataProvider="getData")
	 public void signUpKipos(String name, String email, String password, String confirmpassword) throws InterruptedException
	 {
		driver.findElement(By.id("signup-fullname")).sendKeys(name);
		 Thread.sleep(4000);
		
		driver.findElement(By.id("signup-email")).sendKeys(email);
		 Thread.sleep(4000);
		
		driver.findElement(By.id("password")).sendKeys(password);
		 Thread.sleep(4000);
		
		driver.findElement(By.id("changepwd-confirm-password")).sendKeys(confirmpassword);
		 Thread.sleep(4000);
		 
		
	 }
	
    @AfterMethod
      public void tearDown() {
    	driver.quit();
    }

}
