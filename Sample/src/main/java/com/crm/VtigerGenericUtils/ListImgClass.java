package com.crm.VtigerGenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Date;


public class ListImgClass implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{
		String currentDate = new Date().toString().replace(":","_").replace(" ","_");
		String failedTestName = result.getMethod().getMethodName();
		EventFiringWebDriver ed=new EventFiringWebDriver(BaseClass.sdriver);
		File src = ed.getScreenshotAs(OutputType.FILE);
		
		File destImg = new File("./screenshot/"+failedTestName+"_"+currentDate+".png");
		
		try {
		FileUtils.copyFile(src, destImg);
		}
		catch(IOException e)
		{
		}
		
	}

}
