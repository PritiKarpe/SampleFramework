package com.crm.VtigerGenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
	 * This class contains webdriver specific generic methods
	 */
public class WebDriverUtility
{
	/**
	 * This method wait for 20 sec for page loading
	 * 
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is visible for the element to be visible
	 * 
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method wait for the element to be clicked
	 * @throws InterruptedException 
	 * 
	 */
	public void waitAndclick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<40)
		{
		try
		{
			element.click();
			break;
		}
		catch(Throwable e)
		{
			Thread.sleep(5000);
			count++;
		}
	  }
   
	}
	
	
/**
 * This method enables user to handle dropdown using visible text
*/
public void selectOption(WebElement element,String option)
{
	Select select=new Select(element);
	select.selectByVisibleText(option);	
}


/**
 * This method enables user to handle dropdown using index
 * 
 */
public void selectOption(WebElement element, int index)
{
	Select select=new Select(element);
	select.selectByIndex(index);	
}

/**
 * This method will perform mouse over action
 */
public void mouseOver(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();			
}


/**
 * This method will perform right click operation
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();			
}



/**
 * This method is used to switch from one window to another
 */

public void switchToWindow(WebDriver driver,String partilWinTitle)
{
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it = window.iterator();
	
	while(it.hasNext())
	{
		String winId = it.next();
		String title = driver.switchTo().window(winId).getTitle();
		
		if(title.contains(partilWinTitle))
		{
			break;
		}
	}
}


/**
 * Accept alert
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}


/**
 * Cancel alert
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}


/**
 * This method used for scrolling action in a webpage
 */
public void scrollToWebEement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollby(0,"+y+")", element);
}


public void switchFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

public void switchFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}


public void switchFrame(WebDriver driver, String idorName)
{
	driver.switchTo().frame(idorName);
}

public void switchmainFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}

public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot/"+screenshotName+".PNG");
	Files.copy(src, dest);
}

public void pressEnterKey(KeyEvent key) throws AWTException
{
	Robot rc=new Robot();
	rc.keyPress(KeyEvent.VK_ENTER);
	rc.keyRelease(KeyEvent.VK_ENTER);
}




}








