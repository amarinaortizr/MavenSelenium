package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class CheckoutPage extends ClsBrowser{
	
	//Keys
	static String firstName = "Test";
	static String lastName = "Num";
	static String email = "FinalTest@mail.com";
	static String address = "Hamptons 3210";
	static String city = "Denver";
	static String zip = "80014";
	static String stateProvidence = "Colorado";
	static String telephone = "3032586994";
	static String country = "United States";

	//Locators
	
	//checkout method locators
	By checkoutAsGuestBtn = By.xpath("//label[contains(text(),'Checkout as Guest')]");
	By continueCheckoutMethodBtn = By.xpath("//button[@id='onepage-guest-register-button' and contains(span,'Continue')]");
	
	//billing information locators
	By firstNameLocator = By.xpath("//input[@id='billing:firstname']");
	By lastNameLocator = By.xpath("//input[@id='billing:lastname']");
	By emailAddressLocator = By.xpath("//input[@id='billing:email']");
	By addressLocator = By.xpath("//input[@id='billing:street1']");
	By cityLocator = By.xpath("//input[@id='billing:city']");
	By stateProvidenceSelector = By.xpath("//select[@id='billing:region_id']");
	By zipCodeLocator = By.xpath("//input[@id='billing:postcode']");
	By countrySelector = By.xpath("//select[@id='billing:country_id']");
	By telephoneLocator = By.xpath("//input[@id='billing:telephone']");
	By shipToThisAddressBtn = By.xpath("//input[@id='billing:use_for_shipping_yes']");
	By continueBillingInformationBtn = By.xpath("//button[@onclick='billing.save()' and contains(span,'Continue')]");
	
	//shipping method locators
	By continueShippingMethodBtn = By.xpath("//button[@onclick='shippingMethod.save()' and contains(span,'Continue')]");
	
	//payment information locators
	By checkMoneyOrderBtn = By.xpath("//input[@id='p_method_checkmo']");
	By continuePaymentInformationBtn = By.xpath("//button[@onclick='payment.save()' and contains(span,'Continue')]");
	
	//order review locators
	By placeOrderSubmitBtn = By.xpath("//button[@title='Place Order']");
	
	//Methods
	
	/*
	 * select 'checkout as guest' method
	 */
	public void chooseCheckoutMethod() {
		ClsReport.fnLog(Status.INFO, "Selecting 'checkout as guest'", false);
		
		WaitForElementClickable(checkoutAsGuestBtn);
		Click(checkoutAsGuestBtn);
		WaitForElementClickable(continueCheckoutMethodBtn);
		Click(continueCheckoutMethodBtn);
	}
	
	/*
	 * fill all the fields of billing information
	 */
	public void fillBillingInformation() {
		ClsReport.fnLog(Status.INFO, "Filling the fields of billing information", false);
		
		WaitForElement(firstNameLocator);
		SendKeys(firstNameLocator,firstName);
		WaitForElement(lastNameLocator);
		SendKeys(lastNameLocator,lastName);
		WaitForElement(emailAddressLocator);
		SendKeys(emailAddressLocator,email);
		WaitForElement(addressLocator);
		SendKeys(addressLocator,address);
		WaitForElement(cityLocator);
		SendKeys(cityLocator,city);
		WebElement objStateProvidence = getGetWebElement(stateProvidenceSelector);
		Select stateProvidenceSelect = new Select(objStateProvidence);
		stateProvidenceSelect.selectByVisibleText(stateProvidence);
		WaitForElement(zipCodeLocator);
		SendKeys(zipCodeLocator,zip);
		WebElement objCountry = getGetWebElement(countrySelector);
		Select countrySelect = new Select(objCountry);
		countrySelect.selectByVisibleText(country);
		WaitForElement(telephoneLocator);
		SendKeys(telephoneLocator,telephone);
		WaitForElementClickable(shipToThisAddressBtn);
		Click(shipToThisAddressBtn);
		WaitForElementClickable(continueBillingInformationBtn);
		Click(continueBillingInformationBtn);
	}
	
	/*
	 * click 'continue' to accept the shipping method
	 */
	public void continueShippingMethod() {
		ClsReport.fnLog(Status.INFO, "Accepting the shipping method", false);
		
		WaitForElementClickable(continueShippingMethodBtn);
		Click(continueShippingMethodBtn);
	}
	
	/*
	 * select 'Check/Money order' payment method
	 */
	public void choosePayment() {
		ClsReport.fnLog(Status.INFO, "Selecting 'Check/Money order' payment method", false);
		
		WaitForElementClickable(checkMoneyOrderBtn);
		Click(checkMoneyOrderBtn);
		WaitForElement(continuePaymentInformationBtn);
		Click(continuePaymentInformationBtn);
	}
	
	/*
	 * place the order
	 */
	public void placeOrder() {
		ClsReport.fnLog(Status.INFO, "Placing order", false);
		
		WaitForElementClickable(placeOrderSubmitBtn);
		Click(placeOrderSubmitBtn);
	}
}
