package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

public class ReturnRetailPOM {
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private CustomerRetailPOM customerRetailPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	public ReturnRetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='menu-sale']")
	private WebElement salesmenu; 
	
	@FindBy(linkText="Returns")
	private WebElement returnlink;
	
	@FindBy(id="input-return-id")
	private WebElement returnid; 
	@FindBy(id="button-filter")
	private WebElement filterbutton; 
	@FindBy(id="input-customer")
	private WebElement customername;
	
	//@FindBy(xpath="//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[4]")
	@FindBy(xpath="//div[@id='container']//tbody//tr[1]//td[4]")
	WebElement name_to_verify;
	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[1]")
	WebElement deletecheckbox;
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	WebElement deleteicon;
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement deleteorderconfirmationbox;
	
	public void clickonReturn () {
		salesmenu.click();
		 System.out.println("click on sales");
		
		Actions action=new Actions(driver);
		//WebDriverWait wait=new  WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(returnlink));
	  		
	  action.moveToElement(returnlink).click().build().perform();
	  //returnlink.click();
	  System.out.println("done");
		
	}
	
	public void deleteReturnid()
	{
		returnid.sendKeys("137");
		filterbutton.click();
		deletecheckbox.click();
		deleteicon.click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		String msg=deleteorderconfirmationbox.getText();
		assertTrue(msg.contains("Success"));
	}
	
	
	public void enterdata()
	{
		returnid.sendKeys("140");
		filterbutton.click();
		returnid.clear();
		customername.sendKeys("Test Retails");
		filterbutton.click();
	/*	String customername=name_to_verify.getText();
	
assertTrue(customername.contains("Test"));*/
	}
	
	}
	

