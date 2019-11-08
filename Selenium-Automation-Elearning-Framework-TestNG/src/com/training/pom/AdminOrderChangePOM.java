package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TC046

public class AdminOrderChangePOM {
	
	private WebDriver driver; 
	public Actions act;
	public Alert alert;
	public LoginRetailPOM loginRetailPOM;


public AdminOrderChangePOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}

//Identify Page element 
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
@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[2]/td[8]/a[2]/i[1] ")
private WebElement editicon;
//product page

@FindBy(xpath="button[@class='btn btn-danger']")
private WebElement remove;
@FindBy(id="input-product")
private WebElement chooseproduct;
@FindBy(id="input-quantity")
private WebElement quantity;

@FindBy(id="button-product-add")
private WebElement addproduct;

@FindBy(xpath="//button[@id='button-cart']")
private WebElement continuebutton;

//Payment page 
@FindBy(id="button-payment-address")
private WebElement paymentcontinue;
//Final page
@FindBy(id="button-save")
private WebElement saveicon;

public void  clickonSales()
{
	salesmenu.click();
	System.out.println(orderslink.isDisplayed());
	System.out.println(recurringProfilelink.isDisplayed());
	System.out.println(returnslink.isDisplayed());
	System.out.println(giftVoucherslink.isDisplayed());
}



public void clickonOrders()
{
salesmenu.click();
orderslink.click();
editicon.click();

JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("document.getElementById('button-customer').click();");

		
		
//click remove icon
remove.click();
chooseproduct.sendKeys("Lorem ipsum dolor sit amet");
	//'input-quantity'
	quantity.sendKeys("1");
	addproduct.click();
	continuebutton.click();
	//payment detais page should get displayed
	//click on Continue
	paymentcontinue.click();
	//click on Save
saveicon.click();
}

}


	