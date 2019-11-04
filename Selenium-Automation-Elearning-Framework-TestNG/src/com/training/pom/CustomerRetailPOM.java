package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerRetailPOM {
	
private WebDriver driver; 
	
	public CustomerRetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=" //li[@id='menu-customer']//a[@class='parent']")
	private WebElement custicon; 
	
	@FindBy(linkText="Customers")
	private WebElement customerlink;
	
	@FindBy(id="input-name")
	private WebElement custname; 
	@FindBy(id="input-email")
	private WebElement email; 
	
	//click on the customericon and customer link
	public void clickonCustomer()
	{
		custicon.click();
		System.out.println(customerlink.isEnabled());
		customerlink.click();
		/*Actions act=new Actions(driver);
		
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(customerlink));
		act.click(customerlink).build().perform();*/
	}
	//enter name and email of the customer
	public void EnterdatainCustomerpage()
	{
		custname.sendKeys("somename");
		email.sendKeys("abc@gmail.com");
		  
		
	}
	

	}

	


