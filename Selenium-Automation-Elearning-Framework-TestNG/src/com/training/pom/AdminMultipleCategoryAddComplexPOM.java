package com.training.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;

public class AdminMultipleCategoryAddComplexPOM {
	
private WebDriver driver; 
	
	public AdminMultipleCategoryAddComplexPOM(WebDriver driver) {
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
	
	@FindBy(linkText="Category Name")
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
	 
	@FindBy(linkText="Links")
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
			System.out.println(catlink.isDisplayed());
			System.out.println(products.isDisplayed());
			System.out.println(recurringprofile.isDisplayed());
			
			}
		
		public void sendcategoryName(String categoryName ) {
			this.categoryname.clear();
			
					this.categoryname.sendKeys(categoryName);
		}
	
		
		public void sendcategorydesc(String description ) {
			this.categorydesc.clear(); 
			this.categorydesc.sendKeys(description); 
		}
		
		public void sendmetatagtitle(String metatag ) {
			this.metatagtitle.clear(); 
			this.metatagtitle.sendKeys(metatag); 
		}
		
		
		public void sendmetatagdescription(String metadescription ) {
			this.metadesc.clear(); 
			this.metadesc.sendKeys(metadescription); 
		}
		
		/*
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}*/
		
		public void clickCategoryicon()
		{
			caticon.click();
			catlink.click();
			//verify
			catname.isDisplayed();
			sortorder.isDisplayed();
		}
		public void clickaddnewicon()
		{
			addnewicon.click();
		}
			
			public void clickSave ()
			{
			
			save.click();
		}
			
			public void clickonProduct()
			{
				caticon.click();
				driver.findElement(By.linkText("Products")).click();
			}
			
			//Setting for producname metatagtitle,product category
			public void sendproductName(String productname ) {
				this.productname.clear();
				this.productname.sendKeys(productname);
			}
			
			public void sendmetatagtitleforProduct(String metatagtitle ) {
				this.metatagtitle.clear(); 
				this.metatagtitle.sendKeys(metatagtitle); 
			}
			
			public void sendcategoryforProduct(String productcategories ) {
				this.productcategories.clear(); 
				this.productcategories.sendKeys(productcategories); 
			}
			
		
		public void addnewlink()
		{
			
			caticon.click();
			products.click();
			
			//verify product page
			String productpageheadertext=productpageheader.getText();
			assertTrue(productpageheadertext.contains("Products"));
			
		
		}
		
		
		//14. Click on Links tab
		public void clickonLinkTab()
		{
			
			linktab.click();
			
		}	
		//Application should display default values in Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab
		public void clickonothertab()
		{
			option.click();
			attribute.click();
			recurring.click();
			discount.click();
			special.click();
			image.click();
			

		}

}
