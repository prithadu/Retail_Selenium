package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

public class AdminReturnProductMediumPOM {
	
	//TC049:admin to return product of customer & delete from return list
	
	
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	Alert alert;

	public AdminReturnProductMediumPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

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
	@FindBy(xpath="//a[contains(@data-original-title,'Add New')]")
	private WebElement addnew;
@FindBy(id="input-order-id")
private WebElement orderid; 
@FindBy(id="input-customer")
private WebElement customerid;
@FindBy(id="input-firstname")
private WebElement firstname;
@FindBy(id="input-lastname")
private WebElement lastname;
@FindBy(id="input-telephone")
private WebElement telephone;
@FindBy(id="input-email")
private WebElement email;
@FindBy(id="input-product")
private WebElement product;

@FindBy(id="input-model")
private WebElement model;


@FindBy(xpath="//button[@data-original-title='Save']")
private WebElement save;

@FindBy(xpath="//div[@class='alert alert-success']")
private WebElement alertbox;

@FindBy(xpath="//div[@id='container']//tbody//tr[1]//td[1]")
private WebElement checkbox_of_first_element;

//click on delete
@FindBy(xpath="//button[@class='btn btn-danger']")
private WebElement deleteicon;





	
	public void Clcikonsales()

	  {
		  //click on sales
	 
		salesmenu.click();
		//Validation
		System.out.println((orderslink.isDisplayed()));
		System.out.println((recurringProfilelink.isDisplayed()));
		System.out.println((returnslink.isDisplayed()));
		System.out.println((giftVoucherslink.isDisplayed()));
		
}
	
	
	 public void fillInfo()
	  {
		 
			
			salesmenu.click();
				System.out.println(" menu clicked");
				
			Actions action=new Actions(driver);
				
		action.moveToElement(salesmenu).moveToElement(returnslink).click().build().perform();
			  
			  //3. click on Add new icon
		addnew.click();
		System.out.println("clicked");
		//verify header
		String Addnewheader=driver.findElement(By.xpath("//h1[contains(text(),'Product Returns')]")).getText();

assertEquals(Addnewheader,"Product Returns");
		
		

		//enter order id
		orderid.sendKeys("90");
		customerid.sendKeys("Sooman");
		firstname.sendKeys("Sooman");
	
		lastname.sendKeys("Bose");
		email.sendKeys("sbose@abc.com");
		telephone.sendKeys("9876543210");
	
		product.sendKeys("Integer vitae iaculis massa");
		product.sendKeys("KEYS.Enter");
		model.sendKeys("SKU-003");
		save.click();
		
		System.out.println("Done");
		//validate 

		String actual=alertbox.getText();
		assertTrue(actual.contains("returns!"));
	  } 
	 
	 
public void delete()
{//identify first checkbox
	
	salesmenu.click();
	System.out.println(" menu clicked");
	
Actions action=new Actions(driver);
action.moveToElement(salesmenu).moveToElement(returnslink).click().build().perform();
//click 
		checkbox_of_first_element.click();
		//click on delete
		deleteicon.click();
		//gettinng alert
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		wait.pollingEvery(1, TimeUnit.MICROSECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		
		 alert=driver.switchTo().alert();
		alert.accept();
		//WebElement msg1=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String actualone=alert.getText();
		assertTrue(actualone.contains(" Success: You have modified returns! "));
				
		  
	  }
	  

}
