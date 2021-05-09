package com.comcast.crm.organizationtest;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.commonpomclasses.HomePage;
import com.comcast.crm.organizationpomclass.CreateOrganizationPage;
import com.comcast.crm.organizationpomclass.OrganizationInformationPage;
import com.comcast.crm.organizationpomclass.OrganizationPage;
import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;


public class CreateOrganizationTest extends BaseClass

{
	@Test(groups = "smokeTest")  
	public void createOrganization() throws Throwable
	{
		String orgName = eUtil.getExcelData("org", 1, 2)+JavaUtility.getRamdonData();
		
        /* navigate to organization   */
		HomePage homepage=new HomePage(driver);
        homepage.clickOnOrganizationLink();
        
        /*click on create organization */
        OrganizationPage orgpage=new OrganizationPage(driver);
        orgpage.clickOnCreateOrganizationIMG();
       
        /* create organization*/
        CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
        createorgpage.createOrganization(orgName);
        
         //verification
        OrganizationInformationPage orginfoPage=new OrganizationInformationPage(driver);
        String actualOrg = orginfoPage.getOrganizationText();
        Assert.assertTrue(actualOrg.contains(orgName));
     }
	
	@Test(groups = "regressionTest" )
	public void createOrganizationwithIndustry() throws Throwable
	{
		String orgName = eUtil.getExcelData("org", 4, 2)+JavaUtility.getRamdonData();
		String industries = eUtil.getExcelData("org", 4, 3);
		/* navigate to organization   */
		HomePage homepage=new HomePage(driver);
        homepage.clickOnOrganizationLink();
        
        /*click on create organization */
        OrganizationPage orgpage=new OrganizationPage(driver);
        orgpage.clickOnCreateOrganizationIMG();
       
        /* create organization*/
        CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
        createorgpage.createOrganization(orgName, industries);
        
         //verification
        OrganizationInformationPage orginfoPage=new OrganizationInformationPage(driver);
        String actualIndustry = orginfoPage.getIndustryText();
        Assert.assertTrue(actualIndustry.contains(industries));
	}
	
	
}