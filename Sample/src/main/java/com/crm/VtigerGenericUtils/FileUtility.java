package com.crm.VtigerGenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mysql.cj.xdevapi.JsonParser;

public class FileUtility 

{
	/**
	 * This method used to read data from properties and return the value based on key specified
	 * 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	
	/**
	 * This method will return json value based on json key
	 * 
	 */
	public String getDataFromJson(String jsonKey) throws Throwable {
		  FileReader reader=new FileReader(IpathConstant.JESONFILEPATH);
		  JSONParser parser=new JSONParser();
		  Object object = parser.parse(reader);
		  JSONObject jsonObject = (JSONObject)object;
		  String value=jsonObject.get(jsonKey).toString();
		  return value;
		 }



}
