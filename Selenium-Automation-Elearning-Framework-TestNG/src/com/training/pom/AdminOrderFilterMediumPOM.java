package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdminOrderFilterMediumPOM {

	//TC047:To Verify whether application allows admin to filter details of order placed by the user
	
	private WebDriver driver; 
	public Actions act;
	public Alert alert;
	public LoginRetailPOM loginRetailPOM;

	public AdminOrderFilterMediumPOM(WebDriver driver) {
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

	@FindBy(id="input-order-id")
	private WebElement orderid;
	@FindBy(id="button-filter")
	private WebElement filter;
	
	@FindBy(id="input-order-status")
	private WebElement selectele;
	
	@FindBy(id="input-date-added")
	private WebElement inputdate;
	
	@FindBy(id="input-customer")
	private WebElement customer;

	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-total")
	private WebElement total;
	
	@FindBy(id="input-date-modified")
	private WebElement modifieddate;
	
	/*
	@FindBy(xpath="table[@class='table table-bordered table-hover']/tbody/tr[1]/td[2]")
	private WebElement ordertobechecked;
		*/
	
	
	  public void clickonsales()
		{
		  //click on sales
		  salesmenu.click();
			//Validation
			System.out.println((orderslink.isDisplayed()));
			System.out.println((recurringProfilelink.isDisplayed()));
			try
			{
			System.out.println((returnslink.isDisplayed()));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		finally
		{
			System.out.println((giftVoucherslink.isDisplayed()));

		}	
	}
	
	  //Fetch current date
	  public String getTodaysDate()
	  {
		  
		  
		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		    String curdate=(formatter.format(date));  
		    return curdate;
	  }

		 public void clickonOrdertoedit() 
		 {
			 salesmenu.click();
			 orderslink.click();
				orderid.sendKeys("144");
				//click on filter 
			filter.click();
				//validation?
			//assertEquals((ordertobechecked.getText()),"144");
			//WebElement orderidtobechecked=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[1]"));
			
				orderid.clear();
			
			//select order status as pending
				
				Select se=new Select(selectele);
				se.selectByVisibleText("Pending");
				//click on filter
				filter.click();
				//validation?
				
				System.out.println("Going to deselect");
				//se.deselectByValue("Pending");
				new Select(driver.findElement(By.id("input-order-status"))).selectByValue("*");
				
				
				
				//7. Click on Date icon of Date Added list box
				
				inputdate.sendKeys(getTodaysDate());
				filter.click();
				inputdate.clear();
				
				
				//10. Enter Valid credentials in Customer textbox
				customer.sendKeys("Manzoor");
				filter.click();
			customer.clear();
				
				
				//Select quantity 
				
				driver.findElement(By.id("input-total")).sendKeys("5");
				filter.click();
				driver.findElement(By.id("input-total")).clear();
				
				
				//select data modified
				getTodaysDate();
				modifieddate.sendKeys(getTodaysDate());
				filter.click();
				modifieddate.clear();
		
				
				
		 }
		 
		 
		 
		 

	}
	

