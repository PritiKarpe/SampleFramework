package com.crm.SDET13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DymanicWebtable 
{
	@Test
	public void captureOrgNmae()
	{
		
		WebDriver driver=new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         
        // step1:get url
		driver.get("https://localhost:8080/");
         
		//step 2: login to the aplication
         driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
         
         //step 3: navigate to organization
         
         driver.findElement(By.linkText("Organizations")).click();
         
         //step 4:capture all the organization names
         
         driver.findElement(By.xpath("//table[@class='lvtBg']/a[title='organization']"));	
		
	}

}
