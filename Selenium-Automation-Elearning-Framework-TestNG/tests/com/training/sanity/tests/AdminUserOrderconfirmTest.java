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
import com.training.pom.AdminCustomerEditlMediumPOM;
import com.training.pom.AdminUserOrderconfirmPOM;
import com.training.pom.LoginRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminUserOrderconfirmTest {

	
	

	private WebDriver driver;
	private String userUrl;
	private LoginRetailPOM loginRetailPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private AdminUserOrderconfirmPOM adminUserOrderconfirmPOM;
	
	
	
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
		adminUserOrderconfirmPOM=new AdminUserOrderconfirmPOM(driver);
		userUrl = properties.getProperty("UserURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(userUrl);
		//loginRetailPOM.Login("admin", "admin@123"); 
	}
	
@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void placeanorderTest() 
	{
		
		adminUserOrderconfirmPOM.placeanorder();
		
	}
	
	@Test(priority=2)
	public void adminLogintest() 
	{
		
		adminUserOrderconfirmPOM.adminLogin();
		loginRetailPOM.Login("admin", "admin@123");
		
	}
	
	
	@Test(priority=2)
	public void adminclickonSalesTest() 
	{
		
		adminUserOrderconfirmPOM.AsAdminperformtask();
		
	}
	
	
	}
		
	
	
	


