package testng.practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.VtigerGenericUtils.BaseClass;

//@Listeners(com.crm.VtigerGenericUtils.ListImgClass.class)
public class SampleTest extends BaseClass
{
	@Test
	public void createTest()
	{
		System.out.println("execute current test");
		System.out.println(10/0);
	}
	@Test
	public void createTestwithindustry()
	{
		System.out.println("execute current test");
		System.out.println(10/0);
	}
}
