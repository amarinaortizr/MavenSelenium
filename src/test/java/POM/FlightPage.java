package POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import selenium.ClsBrowser;
import selenium.ClsReport;

public class FlightPage extends ClsBrowser{

	//Locators
	By orderBySelector = By.xpath("//select");
	
	By cheapestFlightBtn = By.xpath("(//a[@class='panel-open ng-star-inserted'])[1]");
	By basicCheapestFlightBtn = By.xpath("(//div[@class='d-none d-md-block price ng-star-inserted'])[1]");
	
	By additionalBaggageDialogHeader = By.xpath("//h5[contains(text(),'Agrega 10 kg extra en equipaje de mano')]");
	By confirmBaggageBtn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Confirmar selección')]");
	By totalPriceLocator = By.xpath("(//div[@class='col2'])[5]//child::div[2]");
	
	
	/*
	 * select to order flights by low prices
	 */
	public void selectByLowPrices() {
		ClsReport.fnLog(Status.INFO, "Ordering flights by low prices" , false);
		WaitForElementLong(orderBySelector);
		WebElement objLowPrice = getGetWebElement(orderBySelector);
		Select orderBySelect = new Select(objLowPrice);
		orderBySelect.selectByVisibleText("Precio (más barato)");
	}
	
	/*
	 * select the cheapest going flight 
	 */
	public void selectCheapestGoingFlight() throws InterruptedException {
		WaitForLoad();
		selectByLowPrices();
		
		ClsReport.fnLog(Status.INFO, "Selecting the cheapest going flight" , false);
		WaitForElementClickableLong(cheapestFlightBtn);
		Thread.sleep(2000);
		Click(cheapestFlightBtn);
		
		ClsReport.fnLog(Status.INFO, "Selecting basic for the going flight" , false);
		WaitForElementClickableLong(basicCheapestFlightBtn);
		Thread.sleep(2000);
		Click(basicCheapestFlightBtn);		
		
		
	}
	
	/*
	 * select the cheapest return flight 
	 */
	public void selectCheapestReturnFlight() throws InterruptedException {
		WaitForLoad();
		selectByLowPrices();
		
		ClsReport.fnLog(Status.INFO, "Selecting the cheapest return flight" , false);
		WaitForElementClickable(cheapestFlightBtn);
		Thread.sleep(2000);
		Click(cheapestFlightBtn);
		
		ClsReport.fnLog(Status.INFO, "Selecting basic for the return flight" , false);
		WaitForElementClickableLong(basicCheapestFlightBtn);
		Thread.sleep(2000);
		Click(basicCheapestFlightBtn);
		
		
	}
	
	/*
	 * confirm the type of baggage
	 */
	public void confirmBaggage() {
		ClsReport.fnLog(Status.INFO, "Confirming baggage" , false);
		WaitForElementLong(additionalBaggageDialogHeader);
		WaitForElementClickable(confirmBaggageBtn);
		Click(confirmBaggageBtn);
	}
	
	/*
	 * get the total price and compare to the budget, make the test fail if is not in the budget and pass if is in the budget
	 */
	public void getTotalAndCompareToBudget(JavascriptExecutor js) throws InterruptedException {
		WaitForLoad();
		ClsReport.fnLog(Status.INFO, "Getting the flights total price", false);
		
		WebElement objPrice = objDriver.findElement(totalPriceLocator);
		js.executeScript("arguments[0].scrollIntoView();",objPrice);
		String currentPrice = objPrice.getAttribute("innerText");
		String totalPriceString = "";
		
		ArrayList<Character> lista = new ArrayList<>();
        for(int i = 0; i< currentPrice.length(); i ++)
        {
            if(Character.isDigit(currentPrice.charAt(i))) {
            	totalPriceString=totalPriceString+currentPrice.charAt(i);
            }
            	
        }

        Integer totalPrice = Integer.valueOf(totalPriceString);
		Integer budget = 1500;
        
		ClsReport.fnLog(Status.INFO, "Comparing the total price with the budget", false);
		
		if(totalPrice>budget) {
			ClsReport.fnLog(Status.FAIL, "The test failed because the total of round-trip cheapest flights is superior to the budget ($"+budget+"), the total was $"+totalPrice, true);
		}else {
			ClsReport.fnLog(Status.PASS, "The test passed, the total of round-trip cheapest flights is within budget ($"+budget+"), the total was $"+totalPrice, true);
		}
	}
}
