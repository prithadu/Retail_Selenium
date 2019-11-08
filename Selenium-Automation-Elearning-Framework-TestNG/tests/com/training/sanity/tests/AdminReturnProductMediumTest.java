package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginRetailPOM;
import com.training.pom.OrderRetailPOM;
import com.training.pom.AdminReturnProductMediumPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//tc049
public class AdminReturnProductMediumTest {

	
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private OrderRetailPOM  orderRetailPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private AdminReturnProductMediumPOM  adminReturnProductMediumPOM;
	
	
	
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
		adminReturnProductMediumPOM=new AdminReturnProductMediumPOM (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		loginRetailPOM.Login("admin", "admin@123"); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
@Test(priority=1)
	public void clickonsalesTest() 
	{
		//loginRetailPOM.Login("admin", "admin@123"); 
		adminReturnProductMediumPOM.Clcikonsales();
		
		
	}
	
	@Test(priority=2)
	public void fillInfoTest() 
	{
		//loginRetailPOM.Login("admin", "admin@123"); 
		adminReturnProductMediumPOM.fillInfo();
		
		
	}
	
	@Test(priority=3)
	public void deletetest() 
	{
		try
		{
		adminReturnProductMediumPOM.delete();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		
	}
	
	}
		
	