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
import com.training.pom.CategoryMediumPOM;
import com.training.pom.CustomerRetailPOM;
import com.training.pom.LoginRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CategoryMediumPOMTest {

	
	
	
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private CategoryMediumPOM categoryMediumPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	//Testcase 048
	
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
		categoryMediumPOM=new CategoryMediumPOM(driver);
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
	public void clickcatalogTest()
	{
		categoryMediumPOM.clickcatalog();
	
	}
	@Test(priority=2)
	public void clickCategoryiconTest()
{
		categoryMediumPOM.clickCategoryicon();
	}
	@Test(priority=3)
	public void clickProductlinkTest()

	{
		categoryMediumPOM.clickProductlink();
	}
	
	}
	

