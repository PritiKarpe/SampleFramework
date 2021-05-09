package com.comcast.crm.productTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.commonpomclasses.HomePage;
import com.comcast.crm.productpomclass.CreateProductPage;
import com.comcast.crm.productpomclass.ProductInformationPage;
import com.comcast.crm.productpomclass.ProductPage;
import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;

public class TC_15_DeletetheProduct extends BaseClass
{
	@Test
	public void deleteTheProduct() throws Throwable 
	{
		String prodName = eUtil.getExcelData("product", 13, 2)+JavaUtility.getRamdonData();
		String searchby = eUtil.getExcelData("product", 13, 3);
		
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
		String title = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		String actualpro = infopage.product(); 
		Assert.assertTrue(actualpro.contains(prodName));
		
		homepage.clickOnProductLink();
		
		//search product by Qty/Unit
		propage.searchproduct(title, searchby);
		
	    //delete records
	    propage.deleteRecords(driver);
	   
	    
	
	}
}