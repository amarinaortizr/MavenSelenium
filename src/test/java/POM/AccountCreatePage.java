package POM;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class AccountCreatePage extends ClsBrowser{

	//keys
	static String firstName = "Test";
	static String lastName = "Num";
	static String email = "Testingfinal@mail.com";
	static String password = "password!";
	
	//Locators
	By firstNameLocator = By.xpath("//input[@id='firstname']");
	By lastNameLocator = By.xpath("//input[@id='lastname']");
	By emailLocator = By.xpath("//input[@id='email_address']");
	By passwordLocator = By.xpath("//input[@id='password']");
	By passwordConfirmationLocator = By.xpath("//input[@id='confirmation']");
	By submitRegisterBtn = By.xpath("//button[@title='Register']");

	//Methods
	
	/*
	 * fill all the fields to create an account
	 */
	public void createAccount() {
		ClsReport.fnLog(Status.INFO, "Filling the fields of register information", false);
		
		WaitForElement(firstNameLocator);
		SendKeys(firstNameLocator,firstName);
		WaitForElement(lastNameLocator);
		SendKeys(lastNameLocator,lastName);
		WaitForElement(emailLocator);
		SendKeys(emailLocator,email);
		WaitForElement(passwordLocator);
		SendKeys(passwordLocator,password);
		WaitForElement(passwordConfirmationLocator);
		SendKeys(passwordConfirmationLocator,password);
		WaitForElementClickable(submitRegisterBtn);
		Click(submitRegisterBtn);
	}
}
