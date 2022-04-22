package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class CartPage extends ClsBrowser{

	//Locators
	public String lGLCDString = "LG LCD";
	public String samsungLCDString = "SAMSUNG LCD";	
	public By lGLCDNameLocator = By.xpath("//h2[@class='product-name' and contains(a,'LG LCD')]");
	public By samsungLCDLocator = By.xpath("//h2[@class='product-name' and contains(a,'Samsung LCD')]");
	By proceedToCheckoutBtn = By.xpath("(//span[contains(text(),'Proceed to Checkout')])[2]");
	
	
	//Methods
	
	/*
	 * verify if the item was added to the cart
	 */
	public void verifyItemAddedToCart(By itemLocator, String itemName) {
		ClsReport.fnLog(Status.INFO, "Verifying if the item was added", false);
		
		WaitForElement(itemLocator);
		WebElement objTitle = getGetWebElement(itemLocator);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals(itemName, currentTitle);
	}
	
	/*
	 * click on 'proceed to checkout' button
	 */
	public void proceedToCheckout() {
		ClsReport.fnLog(Status.INFO, "Clicking 'proceed to checkout'", false);
		
		WaitForElementClickable(proceedToCheckoutBtn);
		Click(proceedToCheckoutBtn);
	}
}