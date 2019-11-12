package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserOrderconfirmPOM {
	
private WebDriver driver; 

	public AdminUserOrderconfirmPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement homeicon; 
	
	//a[contains(text(),'Finger Ring')]
	
	@FindBy(xpath="//a[contains(text(),'Finger Ring')]")
	private WebElement fingerring; 
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addtocart; 
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement shopbag; 
	@FindBy(xpath="//a[contains(text(),'View Cart')]")
	private WebElement viewcart; 
	
	
	@FindBy(xpath="//td[contains(text(),'Product Name')]")
	private WebElement productname; 
	@FindBy(xpath="//td[contains(text(),'Model')]")
	private WebElement model; 
	@FindBy(xpath="//td[contains(text(),'Quantity')]")
	private WebElement quantity; 
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement checkout; 
	@FindBy(partialLinkText="Step 2: Billing Deta")
	private WebElement BillingDetails; 
	

	@FindBy(xpath="//input[@id='button-payment-address']")
	private WebElement firstcontinue; 

	@FindBy(partialLinkText="Step 3: Delivery Det")
	private WebElement deliverydetails; 
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	private WebElement checkoutcontinue; 
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email; 
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password; 
	
	@FindBy(xpath="//input[@id='button-login']")
	private WebElement loginbutton; 
	
	
	
	
	
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement textarea; 
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement shippingmehodcontinue; 
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement iagree; 
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement iagreecontinue; 
	
	@FindBy(id="button-confirm")
	private WebElement confirmorder; 
	
	//Admin Page element
	
	@FindBy(xpath="//li[@id='menu-sale']")
	private WebElement salesmenu; 
	@FindBy(linkText="Orders")
	private WebElement orderslink;
	@FindBy(linkText="Recurring Profiles")
	private WebElement recurringProfilelink;
	@FindBy(linkText="Returns")
	private WebElement returnslink;
	@FindBy(linkText="Gift Vouchers")
	private WebElement giftVoucherslink;
	
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[8]/a[1]")
	private WebElement view;
	
	//add order history
	
	@FindBy(xpath="//select[@id='input-order-status']")
	private WebElement orderstatus; 
	
	@FindBy(xpath="//button[@id='button-history']")
	private WebElement addhistory;
	
public void placeanorder()
{
	homeicon.click();
	driver.findElement(By.linkText("Finger Ring")).click();
	addtocart.click();
	Actions action=new Actions(driver);
	action.moveToElement(shopbag).build().perform();
	viewcart.isDisplayed();
	viewcart.click();
	productname.isDisplayed();
	model.isDisplayed();
	quantity.isDisplayed();
	checkout.click();
	//login to application 
	email.sendKeys("revasharma011@gmail.com");
	password.sendKeys("reva123");
	
	loginbutton.click();
	//BillingDetails.isDisplayed();
	firstcontinue.click();
	//deliverydetails.isDisplayed();
	checkoutcontinue.click();
	textarea.sendKeys("This is very nice");
	shippingmehodcontinue.click();
	iagree.click();
	iagreecontinue.click();
	confirmorder.click();
	}

public void adminLogin()
{
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	driver.get("http://retailm1.upskills.in/admin/");
}



public void AsAdminperformtask()

  {
	  //click on sales
 
	salesmenu.click();
	//Validation
	System.out.println((orderslink.isDisplayed()));
	System.out.println((recurringProfilelink.isDisplayed()));
	System.out.println((returnslink.isDisplayed()));
	System.out.println((giftVoucherslink.isDisplayed()));
	orderslink.click();
	//click view
	view.click();
	Select se=new Select(orderstatus);
	int n=se.getOptions().size();

	se.selectByVisibleText("Complete");
	addhistory.click();
	
}
}

