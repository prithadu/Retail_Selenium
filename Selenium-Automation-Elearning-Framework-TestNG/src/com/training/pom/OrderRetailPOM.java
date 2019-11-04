package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.pom.LoginRetailPOM;

public class OrderRetailPOM {
	
private WebDriver driver; 
public Actions act;
public Alert alert;
public LoginRetailPOM loginRetailPOM;

public OrderRetailPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}

	
@FindBy(xpath="//li[@id='menu-sale']")
		private WebElement menusales;	
	

	@FindBy(xpath="//li[@id='menu-sale']//ul//li//a[contains(text(),'Orders')]")
	private WebElement orderslink;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	; 
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement sales;
	
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement salesicon;
	

	@FindBy(id="input-order-id")
	private WebElement orderid; 
	
	@FindBy(id="button-delete")
	private WebElement delete_button; 
	
	@FindBy(id="button-filter")
	private WebElement filter_button;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[1]//input[1]")
	private WebElement clickcheckbox;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement deleteorderconfirmationbox;
	
	@FindBy(id="input-username")
	private WebElement custicon; 
	
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	private WebElement customer;
	
	@FindBy(id="input-name")
	private WebElement custname; 
	@FindBy(id="input-email")
	private WebElement email; 
	@FindBy(id="input-customer")
	private WebElement cust;
	
	//click on salesicon
	public void clickonSales()
	  {
		menusales.click();
		  
	}
	  //click on order
	  public void clickonOrder()
	  {
		
		  orderslink.click();
			//send order and click on filter
		orderid.sendKeys("68");
			filter_button.click();
			orderid.clear();
		  }  
	  //Enter valid credential in customer checkbox
	  public void enterCustomerdata()
	  {
		  cust.sendKeys("Bhabani Rout");
		  filter_button.click();
		  cust.clear();
		  
		  
	  }
	  
	  public void deleteanorder()
	 
	{	
		  
		//orderid.sendKeys("243");
		filter_button.click();
		clickcheckbox.click();
		 delete_button.click();
		  alert=driver.switchTo().alert();
		 System.out.println(alert.getText());
		  alert.accept();
		  String deleteorderconfirmation=deleteorderconfirmationbox.getText();
		  System.out.println(deleteorderconfirmation);
		  //assertEquals(deleteorderconfirmation, "Success: You have modified orders!");
		 // assertEquals(deleteorderconfirmation,expectedconfirmation);
		  assertTrue(deleteorderconfirmation.contains("Success: You have"));

		  		
}
	  
	


}
