package com.crm.VtigerTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;
public class CreateOrganizationwithIndustry extends BaseClass
{
	@Test
	public void createOrganizationwithIndustry() throws Throwable
	{
	    String orgName = fUtil.getPropertyKeyValue("orgName");
        //step 3: navigate to organization
        driver.findElement(By.linkText("Organizations")).click();

      //step 4-create organization
      
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRamdonData());
        
        //select education from industry dropdown
        WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
       wUtil.selectOption(industry, fUtil.getDataFromJson("dropName"));
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
      //verification
        String exp_data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        SoftAssert asrt=new SoftAssert();
        asrt.assertTrue(exp_data.contains(orgName));
         Reporter.log(orgName,true);
        
	}
}