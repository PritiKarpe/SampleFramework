package com.comcast.crm.contactpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author
 *
 */
public class ContactInformationPage {

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getConatctInfo() {
		return conatctInfo;
	}

	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement conatctInfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement organizationInfo;
	
	public String getContactText() {
		return conatctInfo.getText();
	}
	
	public String getOrganizationText() {
		return organizationInfo.getText();
	}
}
