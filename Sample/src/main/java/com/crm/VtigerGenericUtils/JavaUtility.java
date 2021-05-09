package com.crm.VtigerGenericUtils;

import java.util.Date;
import java.util.Random;


/**
 * *This class contains java specific generic libraries
 *
 */
public class JavaUtility 
{
	/**
	 * generate random number
	 */
	public static String getRamdonData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	
	/**
	 * Generate current system date
	 */
	
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentdate = date.toString();
		return currentdate;
	}

}
