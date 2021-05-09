package com.comcast.crm.productpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.VtigerGenericUtils.JavaUtility;

public class CreateProductPage 
{
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prodNameTf;
	
	@FindBy(id="qty_per_unit")
	private WebElement qtyPerUnitTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getProdNameTF() {
		return prodNameTf;
	}

	public WebElement getQtyPerUnitTF() {
		return qtyPerUnitTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * this method create new product
	 * 
	 */
  public void createproduct(String productName)
  {
	  prodNameTf.sendKeys(productName);
	  qtyPerUnitTF.sendKeys(JavaUtility.getRamdonData());
	  saveBtn.click();
  }
  
}
