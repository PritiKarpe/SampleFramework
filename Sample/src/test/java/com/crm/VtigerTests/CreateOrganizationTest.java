package com.crm.VtigerTests;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;

public class CreateOrganizationTest extends BaseClass
{
	@Test
	public void createOrganization() throws Throwable
	{
		String orgName = fUtil.getPropertyKeyValue("orgName");
        //step 3: navigate to organization
        driver.findElement(By.linkText("Organizations")).click();
        
        //step 4-create organization
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRamdonData());
        driver.findElement(By.name("button")).click();
       
         //verification
        String exp_data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
         //Assert.assertTrue(exp_data.contains(orgName));
        SoftAssert asrt=new SoftAssert();
        asrt.assertTrue(exp_data.contains(orgName));
         Reporter.log(orgName,true);
    
	}
	
}
