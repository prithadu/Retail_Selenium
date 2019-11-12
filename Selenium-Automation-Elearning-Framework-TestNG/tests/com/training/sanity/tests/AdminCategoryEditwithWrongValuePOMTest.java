package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdminMultipleCategoryAddComplexPOM;
import com.training.pom.CategoryMediumPOM;
import com.training.pom.LoginRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminCategoryEditwithWrongValuePOMTest {
	
	
	
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private CategoryMediumPOM categoryMediumPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private AdminMultipleCategoryAddComplexPOM adminMultipleCategoryAddComplexPOM;
	private GenericMethods genericMethods; 

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
		adminMultipleCategoryAddComplexPOM=new AdminMultipleCategoryAddComplexPOM(driver);
		genericMethods = new GenericMethods(driver); 
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
	
	
	
	/*@Test
	public void clickcat()
	{
		adminMultipleCategoryAddComplexPOM.clickCategoryicon();
		adminMultipleCategoryAddComplexPOM.clickaddnewicon();
	
	}*/
	
	@Test(dataProvider="excel-inputs", dataProviderClass=LoginDataProviders.class)
	public void senddetailstocategoryTest(String categoryName,String description,String metatag,String metadescription,String product,String prodtitle,String prodcat) {
	
		
		try {
			adminMultipleCategoryAddComplexPOM.clickCategoryicon();
			adminMultipleCategoryAddComplexPOM.clickaddnewicon();
			adminMultipleCategoryAddComplexPOM.sendcategoryName(categoryName);
			adminMultipleCategoryAddComplexPOM.sendcategorydesc(description);
			
			adminMultipleCategoryAddComplexPOM.sendmetatagdescription(metatag);
			adminMultipleCategoryAddComplexPOM.sendcategorydesc(metadescription);
			adminMultipleCategoryAddComplexPOM.clickSave();
			//***** click on Products from category****//
			
			//For product
			adminMultipleCategoryAddComplexPOM.clickonProduct();
			adminMultipleCategoryAddComplexPOM.clickaddnewicon();
			//general tab
			adminMultipleCategoryAddComplexPOM.sendproductName(product);
			//Othr tab and links tab
			adminMultipleCategoryAddComplexPOM.sendmetatagtitleforProduct(prodtitle);
			adminMultipleCategoryAddComplexPOM.clickonLinkTab();
			adminMultipleCategoryAddComplexPOM.clickonothertab();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	
		finally
		{
			System.out.println("Donot give Null Input and give proper input and save your excel");
		}
		
	}
	
	
	

}
