package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class IndexPage extends ClsBrowser{

	//Locators
	String expectedHeader = "Thank you for registering with Main Website Store.";
	By registeredAccountHeader = By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]");
	By activeSessionLocator = By.xpath("//p[contains(text(),'Welcome')]");
	String concatenatedActiveSessionXpath = "WELCOME, "+AccountCreatePage.firstName.toUpperCase()+" "+AccountCreatePage.lastName.toUpperCase()+"!";
	
	
	//Methods
	
	/*
	 * verify 'Thank you for registering with Main Website Store.' header
	 */
	public void verifyRegisteringSuccess() {
		ClsReport.fnLog(Status.INFO, "Verifying 'Thank you for registering with Main Website Store.'", false);
		
		WaitForLoad();
		WaitForElement(registeredAccountHeader);
		WebElement objTitle = getGetWebElement(registeredAccountHeader);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals(expectedHeader, currentTitle);
	}
	
	/*
	 * verify the current session header with the one registered
	 */
	public void verifySession() {
		ClsReport.fnLog(Status.INFO, "Verifying the current session header with the one registered", false);
		
		WaitForLoad();
		WaitForElement(activeSessionLocator);
		WebElement objTitle = getGetWebElement(activeSessionLocator);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals(concatenatedActiveSessionXpath, currentTitle);
	}
	
	
}
