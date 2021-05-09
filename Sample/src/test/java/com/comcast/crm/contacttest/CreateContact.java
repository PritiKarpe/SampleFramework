package com.comcast.crm.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.commonpomclasses.HomePage;
import com.comcast.crm.contactpomclass.ContactInformationPage;
import com.comcast.crm.contactpomclass.ContactPage;
import com.comcast.crm.contactpomclass.CreateContactPage;
import com.comcast.crm.organizationpomclass.CreateOrganizationPage;
import com.comcast.crm.organizationpomclass.OrganizationInformationPage;
import com.comcast.crm.organizationpomclass.OrganizationPage;
import com.crm.VtigerGenericUtils.BaseClass;
import com.crm.VtigerGenericUtils.JavaUtility;



public class CreateContact extends BaseClass{

	@Test(groups = "smokeTest")  
	public void createContact() throws Throwable
	{
		
		String lastName=eUtil.getExcelData("contact", 1, 2)+"_"+JavaUtility.getRamdonData();
		//Navigate to contacts
		HomePage homePage =new HomePage(driver);
		homePage.clickOnContactLink();
		
		//Create Contact with organization
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnCreateContactIMG();
		// navigate to create contact page
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.createContact(lastName);
		//verify
		ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
		String actualContactText=contactInfoPage.getContactText();
		Assert.assertTrue(actualContactText.contains(lastName));
		
	}

	
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 1, 2)+"_"+JavaUtility.getRamdonData();

		//Navigate to organizations
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganizationLink();

		//create organization
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnCreateOrganizationIMG();

		//create organization
		CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(orgName);


		//verification
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
		Assert.assertTrue(actualOrgName.contains(orgName));
		
		String lastName=eUtil.getExcelData("contact", 4, 2)+"_"+JavaUtility.getRamdonData();
		
		
		//Navigate to contacts
		HomePage homepage =new HomePage(driver);
		homepage.clickOnContactLink();
		
		//Create Contact with organization
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnCreateContactIMG();
		
		//create contact with organizationName
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.createContactWithOrganization(lastName, 
				orgName, "Accounts", "Contacts");
		//verification
		ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
		String actualContactText=contactInfoPage.getContactText();
		Assert.assertTrue(actualContactText.contains(lastName));
		String actualOrgNameInContact=contactInfoPage.getOrganizationText();
		Assert.assertEquals(actualOrgNameInContact, orgName);
		
	}

}
