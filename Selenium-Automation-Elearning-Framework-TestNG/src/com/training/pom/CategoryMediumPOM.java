package com.training.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryMediumPOM {
	
	
	
private WebDriver driver; 
	
	public CategoryMediumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		}
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement caticon;
	
	@FindBy(linkText="Categories")
		private WebElement catlink;
	
	@FindBy(linkText="Products")
	private WebElement products;
	@FindBy(linkText="Recurring Profiles")
	private WebElement recurringprofile;
	
	//Element in category page
	@FindBy(linkText="Sort Order")
	private WebElement sortorder;
	
	@FindBy(xpath="//a[@class='asc']")
	private WebElement catname;
	
	@FindBy(xpath="//td[contains(text(),'Action')")
	private WebElement action;
	
	 @FindBy(xpath="//a[@data-original-title='Add New']")
	 private WebElement addnewicon;
	 
	 //After adding addnew
	 @FindBy(id="input-name1")
	 private WebElement categoryname;
	 
	 @FindBy(xpath="//div[@class='note-editable panel-body']")
	 private WebElement categorydesc;
	 @FindBy(id="input-meta-title1")
	 private WebElement metatagtitle;
	 
	 @FindBy(id="input-meta-description1")
	 private WebElement metadesc;
	 
	@FindBy(xpath="//button[@data-original-title='Save']")
	private WebElement save;
	
	//product page
	@FindBy(xpath="//div[@class='page-header']//following::h1")
	private WebElement productpageheader;
	
	 @FindBy(xpath="//input[@id='input-name1']")
	 private WebElement productname;
	
	 //Links tab element
	 
	@FindBy(xpath="//a[contains(text(),'Links')]")
	 private WebElement linktab;
	
	 @FindBy(id="input-category")
	 private WebElement productcategories;
	 
	 @FindBy(linkText="Option")
		private WebElement option;
	 @FindBy(linkText="Attribute")
		private WebElement attribute;
	 
	 @FindBy(linkText="Recurring")
		private WebElement recurring;
	
	 @FindBy(linkText="Discount")
		private WebElement discount;
	 @FindBy(linkText="Special")
		private WebElement special;
	 @FindBy(linkText="Image")
		private WebElement image;
		
		public void clickcatalog()
		{
			caticon.click();
			//verify 
			catlink.isDisplayed();
			products.isDisplayed();
			recurringprofile.isDisplayed();
			
			}
		
		public void clickCategoryicon()
		{
			caticon.click();
			//verify
			catname.isDisplayed();
			action.isDisplayed();
			sortorder.isDisplayed();
			//click on AddNew
			addnewicon.click();
			//click category name
			categoryname.sendKeys("ORNAMENTS");
			categorydesc.sendKeys("ornaments for ladies");
			metatagtitle.sendKeys("ORNAMENTS");
			metadesc.sendKeys("ornaments for ladies");
			save.click();
		}
		
		public void clickProductlink()
		{
			
			caticon.click();
			products.click();
			
			//verify product page
			String productpageheadertext=productpageheader.getText();
			assertTrue(productpageheadertext.contains("Products"));
			addnewicon.click();
			productname.sendKeys("Finger Ring");
			metatagtitle.sendKeys("Finger Ring for ladies");

		}
		
		public void clickonLinks()
		{
			
			linktab.click();
			
			//select category from displayed . Select Category from displayed category list
			
			productcategories.sendKeys("orna");
			//KeyDown(productcategories,Keys.ENTER);
			
			//Application should display default values in Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab
			option.click();
			attribute.click();
			recurring.click();
			discount.click();
			special.click();
			image.click();
			
		}
		
		}


