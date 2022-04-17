package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsBrowser;

public class HomePage extends ClsBrowser{

	//Locators
	String AccountFirstName = "Test";
	String ConcatenatedActiveSessionXpath = "//span[contains(text(), 'Hola " +AccountFirstName+ "')]";
	
	By identifyBtn = By.xpath("//span[contains(text(),'Cuenta y Listas')]");
	By activeSessionLocator = By.xpath(ConcatenatedActiveSessionXpath);
	By promotionsBtn = By.xpath("//a[@href='/deals?ref_=nav_cs_gb']");
	
	
	//Methods
	
	/*
	 * Clicks on the identify button to go to login page
	 */
	public void goToLogInPage() {
		WaitForLoad();
		WaitForElementClickable(identifyBtn);
		Click(identifyBtn);
	}
	
	/*
	 * verify the active session
	 */
	public void verifyActiveSession() {
		WaitForLoad();
		WaitForElement(activeSessionLocator);
		WebElement objTitle = getGetWebElement(activeSessionLocator);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("Hola Test", currentTitle);
	}
	
	/*
	 * Clicks on the promotions button to go promotions page
	 */
	public void goToPromotionsPage() {
		WaitForLoad();
		WaitForElementClickable(promotionsBtn);
		Click(promotionsBtn);
	}
	
	
}
