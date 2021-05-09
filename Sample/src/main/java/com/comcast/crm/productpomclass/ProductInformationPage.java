package com.comcast.crm.productpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage
{
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productInfo;
	
   
	public WebElement getProductInfo() {
		return productInfo;
	}

	public String product()
	{
		return productInfo.getText();
	}
	
	
    
}
