package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginRetailPOM;
import com.training.pom.ReturnRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnRetailTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private ReturnRetailPOM returnRetailPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	//testCase19
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginRetailPOM = new LoginRetailPOM(driver); 
		returnRetailPOM=new ReturnRetailPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		loginRetailPOM.Login("admin", "admin@123"); 
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	*/
	/*
	@Test(priority=0)
	public void validLoginTest() {
		driver.get(baseUrl);
		loginRetailPOM.Login("admin", "admin@123"); 
	}*/
	@Test(priority=1)
	public void ReturnDetailsPageTest()
	{
		returnRetailPOM.clickonReturn();
	returnRetailPOM.deleteReturnid();
	//returnRetailPOM.enterdata();
	
	
	}

	
}
	

	
