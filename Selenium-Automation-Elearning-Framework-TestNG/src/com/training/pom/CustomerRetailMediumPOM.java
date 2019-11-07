package com.training.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRetailMediumPOM {

	
private WebDriver driver; 
	
	public CustomerRetailMediumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement custicon; 
	
	@FindBy(linkText="Customers")
	private WebElement customerlink;
	
	@FindBy(xpath="//a[contains(@data-original-title,'Edit')]")
	private WebElement edit;
	
	 @FindBy(xpath="//a[contains(text(),'Address 1')]")
		private WebElement address1;
	 
	
	 @FindBy(id="input-firstname")
		private WebElement firstname;
	 
	 @FindBy(id="input-postcode1")
		private WebElement postcode;
	 
	/* @FindBy(xpath="//li[@class='active']//a[contains(text(),'Reward Points')]")
		private WebElement rewardpointtab;*/
	 
	 
	 @FindBy(linkText="Reward Points")
		private WebElement rewardpoint;
	 
	 @FindBy(id="input-reward-description")
		private WebElement reward_description;
	 @FindBy(id="button-reward")
		private WebElement addreward;
		@FindBy(xpath="//div[@class='alert alert-success']")		
		private WebElement alertbox;
		
		@FindBy(xpath="//h3[@class='panel-title']")		
		private WebElement customerListbox;
		
	 

	public void EditCustomerInfo()
	{
		//click on Customericon and customerlink
		 custicon.click();
		customerlink.click();
		//validation of customer list 
		
	assertTrue((customerListbox.getText()).contains("Customer List"));
		
		 //click on edit
	
			edit.click();
		 //cleark  firstname textbix and enter asita
			firstname.clear();
		
			firstname.sendKeys("Asmita");
		 
		
		 //clcik on address1 tab
		
		address1.click();
		
		 //enter valid postcode
	
		postcode.sendKeys("8796545");
		
		//click on Reward point tab
		rewardpoint.click();
		 
		 //enter description  and point
		 reward_description.clear();
		reward_description.sendKeys("review");
		reward_description.clear();
		rewardpoint.sendKeys("50");
		 //Add reward
		
		addreward.click();
		
		//Assert reward
		String actual=alertbox.getText();
		assertTrue(actual.contains("Success: You have modified customers!"));
	}
	
	

}