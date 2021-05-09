package com.crm.VtigerTests;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;

public class CreateContactwithOrganizationTest extends BaseClass
{
	@Test
	public void createContactwithOrganization() throws Throwable
	{
		 String orgName = eUtil.getExcelData("contact", 4, 3);
		 String lastName = eUtil.getExcelData("contact", 4, 2)+JavaUtility.getRamdonData();
		/**String orgName = fUtil.getDataFromJson("orgName");
		String lastName = fUtil.getDataFromJson("lastName");*/
		
	  //step 4-click on contact
        driver.findElement(By.linkText("Contacts")).click();
        
        //step 5-create contact
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
        
   	      wUtil.switchToWindow(driver, "Accounts");
   	      driver.findElement(By.id("search_txt")).sendKeys(orgName);
   	      driver.findElement(By.name("search")).click();
   	        
   	      driver.findElement(By.linkText(orgName)).click();
   	   wUtil.switchToWindow(driver, "contacts");
           driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
          
         //verification
           String exp_data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
           SoftAssert asrt=new SoftAssert();
           asrt.assertTrue(exp_data.contains(orgName));
            Reporter.log(exp_data,true);
       
        
	}

}
