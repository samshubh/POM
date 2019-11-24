package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasicExample {

	/*
	Set the system property
	Launch the browser
	Enter the Url
	Login into the application
	Print the title
	Logout from the application
	Delete all the cookies
	Close the browser
	*/
	
	// @Before annotations are all prerequisite condition annotations
	@BeforeSuite
	public void setProperty() {
		System.out.println("Set the system property");
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launch the browser");
	}

	@BeforeClass
	public void enterUrl() {
		System.out.println("Enter the Url");
	}

	@BeforeMethod
	public void loginApp() {
		System.out.println("Login into the application");
	}

	// @Test are all the test annotations
	@Test
	public void getTitle() {
		System.out.println("Print the title");
	}

	
	// @After method are all Post conditions annotations
	@AfterMethod
	public void logoutApp() {
		System.out.println("Logout from the application");
	}

	@AfterClass
	public void deleteCookies() {
		System.out.println("Delete all the cookies");
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("Close the browser");
	}

	@AfterSuite
	public void generateTestReport() {
		System.out.println("Generate test report");
	}
}

