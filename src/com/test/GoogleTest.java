package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	 
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	    
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
	}
	
	@Test
	public void titleTest()
	{
	String title = driver.getTitle();
	
	System.out.println(title);
	}
	 @Test
	 public void searchKeys() throws InterruptedException
	 {
		 driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Testing");
		  Thread.sleep(4000);
		  
		  List<WebElement> suggestion = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
		     System.out.println("The total no of suggestions:"+suggestion.size());
		     
		     for(int i=0;i<suggestion.size();i++)
		     {
		    	 System.out.println(suggestion.get(i).getText());
		    	 
		    	 if(suggestion.get(i).getText().contains("testing jobs"))
		    	 {
		    		 suggestion.get(i).click();
		 	    	break;
		    	 }
		     }
	 }
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
