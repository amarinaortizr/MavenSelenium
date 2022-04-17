package POM;

import org.openqa.selenium.By;
import selenium.ClsBrowser;

public class AmazonLoginPage extends ClsBrowser{
	
	//Locators
	String Email = "testintern31@gmail.com";
	String Password = "Newpass!";
	
	By logInHeader = By.xpath("//h1[contains(text(),'Iniciar sesión')]");
	By emailLocator = By.xpath("//input[@type='email']");
	By continueBtn = By.xpath("//input[@id='continue']");
	By passwordLocator = By.xpath("//input[@type='password']");
	By submitBtn = By.xpath("//input[@id='signInSubmit']");
	By addNumberHeader = By.xpath("//h1[contains(text(),'Agregar un número')]");
	By notNowBtn = By.xpath("//a[contains(text(),'Ahora no')]");
	 
	//Methods
	
	/**
	 * enters the email and go to next screen.
	 */
	public void enterCredential() {
		WaitForLoad();
		WaitForElement(logInHeader);
		SendKeys(emailLocator, Email);
		WaitForElementClickable(continueBtn);
		Click(continueBtn);
	}
	
	/**
	 * enters the password, then go to next screen.
	 */
	public void startSession() {
		WaitForLoad();
		WaitForElement(logInHeader);
		SendKeys(passwordLocator, Password);
		WaitForElementClickable(submitBtn);
		Click(submitBtn);
	}
	
	/**
	 * wait for 'add a number to your account' dialog and click on not now
	 */
	public void skipAddNumberDialog() {
		try {
			WaitForLoad();
			WaitForElementShort(addNumberHeader);
			WaitForElementClickableShort(notNowBtn);
			Click(notNowBtn);
			
		} catch (Exception e) {
			System.out.println("The 'add a number to your account' dialog was not displayed this time");
		}
	}
	

}
