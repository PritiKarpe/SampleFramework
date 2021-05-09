package testng.practice;

import org.testng.annotations.Test;

public class Sample 
{
	@Test(retryAnalyzer = com.crm.VtigerGenericUtils.RetryAnalyzer.class)
	public void test()
	{
		System.out.println("test execute");
		System.out.println(10/0);
	}

}
