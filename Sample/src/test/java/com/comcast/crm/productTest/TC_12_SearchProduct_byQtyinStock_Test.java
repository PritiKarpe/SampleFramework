package com.comcast.crm.productTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.commonpomclasses.HomePage;
import com.comcast.crm.productpomclass.CreateProductPage;
import com.comcast.crm.productpomclass.ProductInformationPage;
import com.comcast.crm.productpomclass.ProductPage;
import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;

public class TC_12_SearchProduct_byQtyinStock_Test extends BaseClass
{
	@Test(groups = "smokeTest") 
	public void createProduct() throws Throwable
	{
		String prodName = eUtil.getExcelData("product", 4, 2)+JavaUtility.getRamdonData();
		/* navigate to PRODUCT */
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProductLink();
		
		/* click on create product */
		ProductPage propage=new ProductPage(driver);
		propage.clickOnCreateProduct();
		
		/* create new product */
		CreateProductPage creatprod=new CreateProductPage(driver);
		creatprod.createproduct(prodName);
		
		/* verification */
     	ProductInformationPage infopage=new ProductInformationPage(driver);
		String actualpro = infopage.product(); 
		Assert.assertTrue(actualpro.contains(prodName));
	}
	@Test(groups = "regressionTest")
	public void searchProductByQty_unit() throws Throwable
	{
		String prodName = eUtil.getExcelData("product", 4, 2)+JavaUtility.getRamdonData();
		String searchby = eUtil.getExcelData("product", 4, 3);
		
		/* navigate to PRODUCT */
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProductLink();
		
		/* click on create product */
		ProductPage propage=new ProductPage(driver);
		propage.clickOnCreateProduct();
		
      /* create new product */
		CreateProductPage creatprod=new CreateProductPage(driver);
		creatprod.createproduct(prodName);
		
		/* verification */
		ProductInformationPage infopage=new ProductInformationPage(driver);
		String title = driver.findElement(By.xpath("//td[@id='mouseArea_Qty. in Stock']")).getText();
		String actualpro = infopage.product(); 
		Assert.assertTrue(actualpro.contains(prodName));
		
		homepage.clickOnProductLink();
		
		//search product by Qty/Unit
		propage.searchproduct(title, searchby);
		  
		// validation of created by product
		String prod_title = propage.getproductTitle();
	    Assert.assertNotEquals(title, prod_title, "true");
	
 }
}
