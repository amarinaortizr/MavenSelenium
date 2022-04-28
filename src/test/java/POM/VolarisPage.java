package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class VolarisPage extends ClsBrowser{

	
	String originCity = "guadalajara";
	String destinationCity = "cancun";
	String goingMonth = "octubre";
	String returnMonth = "noviembre";
	String goingDay = "29";
	String returnDay = "04";
	String goingDate = "10/29/2022";
	String returnDate = "11/04/2022";
	
	//Locators
	By roundTripBtn = By.xpath("//div[@class='mat-button-toggle-label-content' and contains(text(),'redondo')]");
	
	By originCityBtn = By.xpath("//span[contains(text(),'Origen')]");
	By searchOriginCityLocator = By.xpath("//input[@id='fnameOrigin']");
	By selectOriginCityBtn = By.xpath("//div[@class='col-10 left-align' and contains(text(),'Guadalajara')]");
	
	//By destinationCityBtn = By.xpath("//span[contains(text(),'Destino')]");
	By searchDestinationCityLocator = By.xpath("//input[@id='fnameDestination']");
	By selectDestinationCityBtn = By.xpath("//div[@class='col-10 left-align' and contains(text(),'Cancún')]");
	
	//By goingDateFlightBtn = By.xpath("(//div[@class='mat-form-field-infix'])[1]");
	By goingMonthSelector = By.xpath("(//select[@class='monthselect'])[1]");
	By goingDayBtn = By.xpath("//td[@class='weekend datecell-20221029 customfare available']");
	//try click
	
	//By returnDateFlightBtn = By.xpath("(//div[@class='mat-form-field-infix'])[2]");
	By returnMonthSelector = By.xpath("(//select[@class='monthselect'])[2]");
	By returnDayBtn = By.xpath("(//td[contains (@class,'datecell-20221104') and contains (@class,'available')])[2]");
	//try click maybe is not available
	By submitDatesBtn = By.xpath("(//span[@class='mat-button-wrapper' and contains(text(),'Hecho')])[2]");
	
	By searchFlightsBtn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Buscar vuelos')]"); 
	
	/*
	 * select the type of trip as round-trip
	 */
	public void selectTypeOfTrip() {
		WaitForLoad();
		ClsReport.fnLog(Status.INFO, "Selecting round-trip flight", false);
		
		WaitForElementClickable(roundTripBtn);
		Click(roundTripBtn);
	}
	
	/*
	 * select origin(guadalajara) and destination(cancun) cities
	 */
	public void selectOriginAndDestinationCities() throws InterruptedException {
		WaitForElementClickable(originCityBtn);
		Click(originCityBtn);
		
		ClsReport.fnLog(Status.INFO, "Selecting origin city as "+"'"+ originCity +"'", false);
		Thread.sleep(2000);
		SendKeys(searchOriginCityLocator, originCity);
		WaitForElement(selectOriginCityBtn);
		WaitForElementClickableLong(selectOriginCityBtn);
		Click(selectOriginCityBtn);
		
		ClsReport.fnLog(Status.INFO, "Selecting destination city as "+"'"+ destinationCity +"'", false);
		//WaitForElementClickable(destinationCityBtn);
		//Click(destinationCityBtn);
		SendKeys(searchDestinationCityLocator, destinationCity);
		WaitForElement(selectDestinationCityBtn);
		WaitForElementClickableLong(selectDestinationCityBtn);
		Click(selectDestinationCityBtn);
	}
	
	/*
	 * select going and return dates
	 */
	public void selectGoingAndReturnDates() {
		
		ClsReport.fnLog(Status.INFO, "Selecting going month as "+ goingMonth, false);
		WebElement objgoingMonth = getGetWebElement(goingMonthSelector);
		Select goingMonthSelect = new Select(objgoingMonth);
		goingMonthSelect.selectByVisibleText(goingMonth);
		
		ClsReport.fnLog(Status.INFO, "Selecting return month as " + returnMonth, false);
		WebElement objReturnMonth = getGetWebElement(returnMonthSelector);
		Select returnMonthSelect = new Select(objReturnMonth);
		returnMonthSelect.selectByVisibleText(returnMonth);
		
		try {
			ClsReport.fnLog(Status.INFO, "Selecting going day as "+ goingDay, false);
			WaitForElementClickableLong(goingDayBtn);
			Click(goingDayBtn);
		} catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "Couldn't select the going day as"+ goingDay +" because was not available", false);
		}
		
		try {
			ClsReport.fnLog(Status.INFO, "Selecting return day as "+ returnDay, false);
			WaitForElementClickableLong(returnDayBtn);
			Click(returnDayBtn);
		} catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "Couldn't select the return day as"+ returnDay +" because was not available", false);
		}
		
		WaitForElementClickable(submitDatesBtn);
		Click(submitDatesBtn);
		ClsReport.fnLog(Status.INFO, "The selected going date was "+ goingDate, false);
		ClsReport.fnLog(Status.INFO, "The selected return date was "+ returnDate, false);
	}
	
	/*
	 * click on the button to search flights
	 */
	public void searchFlights() {
		WaitForElementClickable(searchFlightsBtn);
		Click(searchFlightsBtn);
		ClsReport.fnLog(Status.INFO, "Searching flights", true);
	}
}
