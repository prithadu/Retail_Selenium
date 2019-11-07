package com.training.sanity.tests;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CustomerRetailMediumPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.OrderRetailPOM;
import com.training.pom.ReturnRetailInfoFillPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//TC050

public class CustomerRetailMediumTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private CustomerRetailMediumPOM customerRetailMediumPOM;
	
	
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
		customerRetailMediumPOM=new CustomerRetailMediumPOM (driver);
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
	
	
	@Test
	public void EditCustomerInfo() 
	{
		//customerRetailMediumPOM.clickonCustomer();
		customerRetailMediumPOM.EditCustomerInfo();
		
	}
	
	
	
	}
		
	
	
	

