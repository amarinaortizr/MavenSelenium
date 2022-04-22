package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class CheckoutSucsessPage extends ClsBrowser{

	//Locators
	String expectedHeader = "YOUR ORDER HAS BEEN RECEIVED.";
	By checkoutSuccessPageHeader = By.xpath("//h1[contains(text(),'Your order has been received.')]");
	By orderNumberLocator = By.xpath("//p[contains(text(),'Your order # is:')]");
	String currentOrderNumber = null;
	
	//Methods
	
	/*
	 * verify 'your order has been received' header
	 */
	public void verifyCheckoutSuccess() {
		ClsReport.fnLog(Status.INFO, "Verifying 'your order has been received' header", false);
		
		WaitForLoad();
		WaitForElement(checkoutSuccessPageHeader);
		WebElement objTitle = getGetWebElement(checkoutSuccessPageHeader);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals(expectedHeader, currentTitle);
		
	}
	
	/*
	 * get the order number
	 */
	public void getOrderNumber() {
		ClsReport.fnLog(Status.INFO, "Getting the order number", false);
		
		WaitForElement(orderNumberLocator);
		WebElement objTitle = getGetWebElement(orderNumberLocator);
		currentOrderNumber = objTitle.getAttribute("innerText");
		
		ClsReport.fnLog(Status.INFO, currentOrderNumber, false);
	}
}
