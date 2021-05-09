package com.crm.VtigerGenericUtils;

import org.junit.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int counter=0;
	int retrylimit=4;
	public boolean retry(ITestResult result) {
		if(counter<retrylimit)
		{
			counter++;
			return true;
		}
		return false;
	}
	
    @Test(retryAnalyzer=com.crm.VtigerGenericUtils.RetryAnalyzer.class)
	public void test() {
		Assert.assertTrue(false);
	}
    
}
