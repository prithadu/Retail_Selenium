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
import com.training.pom.AdminOrderChangePOM;
import com.training.pom.AdminCustomerEditlMediumPOM;
import com.training.pom.LoginRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminOrderChangePOMTest {
	

	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private AdminOrderChangePOM adminOrderChangePOM;
	
	
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
		adminOrderChangePOM=new AdminOrderChangePOM (driver);
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
@Test(priority=0)
public void clickonsalesTest()
{
	adminOrderChangePOM.clickonSales();
}
	
	
	@Test(priority=1)
	public void clickonOrdersTest()
	{
		try
		{
		adminOrderChangePOM.clickonOrders();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		screenShot.captureScreenShot("issuefound");
		
	}
	finally
	{
	System.out.println("Log a defect");
	}	
	
	}
		
	

}
