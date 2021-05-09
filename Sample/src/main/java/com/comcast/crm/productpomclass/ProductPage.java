package com.comcast.crm.productpomclass;

import java.awt.Checkbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.VtigerGenericUtils.WebDriverUtility;

public class ProductPage extends WebDriverUtility
{
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTf;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement searchDropdown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchoption;
	
	@FindBy(xpath="//a[@title='Products']")
	private WebElement productTitle;
	
	
	@FindBy(name="selected_id")
	private WebElement clickOnCheckbox;
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;
	
	public WebElement getClickOnCheckbox() {
		return clickOnCheckbox;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getProductTitle() {
		return productTitle;
	}

	public WebElement getSearchoption() {
		return searchoption;
	}

	public WebElement getSearchTf() {
		return searchTf;
	}

	public WebElement getCreateProduct() {
		return createProduct;
	}

	public WebElement getSearchDropdown() {
		return searchDropdown;
	}

	public void clickOnCreateProduct()
	{
		createProduct.click();
	}
	
	public void getSearchTf(String title)
	{
		searchTf.sendKeys(title);
	}
	
	public void searchproduct(String Productname,String dropdown) throws InterruptedException
	{
		searchTf.sendKeys(Productname);
		selectOption(searchDropdown, dropdown);
		searchoption.click();
		Thread.sleep(6000);
	}
	
	public String getproductTitle()
	{
		return productTitle.getText();
	}
	
	public void deleteRecords(WebDriver driver) 
	{
		
	    clickOnCheckbox.click();
		deleteBtn.click();
		acceptAlert(driver);
	}
}
