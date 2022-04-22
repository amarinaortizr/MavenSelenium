package POM;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class TVPage extends ClsBrowser{

	//Locators
	String expectedHeader ="TV";
	By TVPageHeader = By.xpath("//div[contains(h1,'TV')]");
	public By LGLCDAddToCartBtn = By.xpath("//button[contains(@onclick,'/product/4')]");
	public By samsungLCDAddToCartBtn = By.xpath("//button[contains(@onclick,'/product/5')]");
	By accountBtn = By.xpath("//span[@class='label' and contains(text(),'Account')]");
	By registerBtn = By.xpath("//a[@title='Register']");
	
	//Methods
	
	/*
	 * add an item to the cart
	 */
	public void addItemToCart(By item) {
		ClsReport.fnLog(Status.INFO, "Clicking 'add to cart'", false);
		
		WaitForElementClickable(item);
		Click(item);
	}
	
	/*
	 * go to account create page
	 */
	public void goToAccountCreatePage() {
		ClsReport.fnLog(Status.INFO, "Clicking 'account->register'", false);
		
		WaitForElementClickable(accountBtn);
		Click(accountBtn);
		WaitForElementClickable(registerBtn);
		Click(registerBtn);
	}
}
