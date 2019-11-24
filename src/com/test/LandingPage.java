package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LandingPage {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		//Setting the system property 
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		   
		//Creating the instance of WebDriver
		   driver = new ChromeDriver();
		   
		//Maximizing the browser window
		   driver.manage().window().maximize();
		   
		   //Deleting all the cookies for the browser
		     driver.manage().deleteAllCookies();
		     
		     //Setting up time for Max page load 
			   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			   
			   //Setting a time for Implicitly wait 
			     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			     
			     driver.get("https://www.kiposcollective.com/#/"); 
	   } 
		 
		 @BeforeMethod
		 public void Login() throws InterruptedException
		 {
			 WebElement login= driver.findElement(By.xpath("//span[@class='btn btn-sign']"));
		       login.click();
		       Thread.sleep(4000);
		       //explicitWait(driver,login,4000);
		       
		       //Verify the text New Customer
		       
		       String customer = driver.findElement(By.xpath("//h5[contains(text(),'New Customer')]")).getText();
		           System.out.println(customer);
		           
		       // Enter the customer details
		           driver.findElement(By.id("email")).sendKeys("prashanth.burri@srijaytech.com");
		              Thread.sleep(4000);
		           
		           driver.findElement(By.id("password_login")).sendKeys("welcome123");
		              Thread.sleep(4000);
		           
		           driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		              Thread.sleep(4000);
		              
		 }
		 
		 @Test(priority = 1,groups="LandingPage")
		 public void logoTest() throws InterruptedException
		
		 {      
			    boolean logo = driver.findElement(By.xpath("//div[@class='col-lg-3 col-xl-3 col-md-3 col-sm-4 col-4 logo-block navbar-left order-aline-1 ng-scope']//img")).isDisplayed();
				System.out.println(logo);
				
				//Assert condition to verify whether the logo is present or not
				Assert.assertTrue(logo);
		 }
		 
		 @Test(priority = 2,groups="LandingPage",dependsOnMethods="logoTest")
		 public void titleTest() {
			 
			 String title = driver.getTitle();
			   System.out.println(title);
			 
			   //Assert condition to verify the title is correct or not
			   
			  Assert.assertEquals(title, "Kipos Collective");
		 }
		 
		 @Test(priority = 3,groups="Bowls Category" )
		 public void bowlsNameGourmet() {
			 // Verifying the text Bowl category name
			   String categoryText1 = driver.findElement(By.xpath("//section[@class='banner-block container pt-30 ng-scope']//h3[contains(text(),'PROTEIN BOWLS')]")).getText();
			      System.out.println(categoryText1);
			
		 }
		 
		 @Test(priority = 4,groups="Bowls Category" )
		 public void bowlsNameFresh()
		 {
			 // Verifying the text Bowl category name
			   String categoryText2 = driver.findElement(By.xpath("//section[@class='banner-block container pt-30 ng-scope']//h3[contains(text(),'FRESH MEAL')]")).getText();
			      System.out.println(categoryText2);
			
		 }
		 
		 @Test(priority = 5,groups="Bowls Category" )
		 public void bowlsNameGrocer()
		 {
			 // Verifying the text Bowl category name
			   String categoryText3 = driver.findElement(By.xpath("//section[@class='banner-block container pt-30 ng-scope']//h3[contains(text(),'GROCERY')]")).getText();
			      System.out.println(categoryText3);
			
		 }
		 @AfterMethod
		 public void logoutUser() throws InterruptedException {
			 
			 //Click on Username Name
			 
			  driver.findElement(By.xpath("//*[@id=\"myHeader\"]/div[1]/div[1]/div/div[3]/div[1]/span/a")).click();
			    Thread.sleep(4000);
			    
			    // Click on Logout button
			    driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//a[contains(text(),'Logout')]")).click();
			     Thread.sleep(4000);
			 
		 }
		 
		 @AfterTest
		 public void closeBrowser() {
			 driver.quit();
		 }
		 
		 @AfterSuite
		 public void generateReports()
		 {
			 System.out.println(" Generate reports in console");
		 }
		 
		 public static void explicitWait(WebDriver driver, WebElement element, int timeout)
		 {
			 new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
			 .until(ExpectedConditions.elementToBeClickable(element));
			// element.click();
		 }
	} 



