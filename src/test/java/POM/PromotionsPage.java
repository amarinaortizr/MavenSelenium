package POM;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import selenium.ClsBrowser;

public class PromotionsPage extends ClsBrowser{

	//Locators
	By promotionsHeader = By.xpath("//span[contains(text(),'Promociones')]");
	By lightningDealsBtn = By.xpath("//span[contains(text(),'Oferta relámpago')]");
	By lightningDealsFilterAppliedLocator = By.xpath("//span[@class='a-text-bold' and contains(text(),'Oferta relámpago')]");//If this xpath is present, then the filter was applicated
	By NumberOfPagesInLightningDealsLocator = By.xpath("(//li[@class='a-disabled'])[last()]");//Xpath to locate the current number of pages
	String namesOfTheProductsStringXpath = ("(//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW'])");//xpath of the name of each product, it will be iterated as an array
	By nextPageBtn = By.xpath("(//li[@class='a-last'])");
	Integer numberOfProductsPerPage = 60;
	
	public List<String> listOfProducts = new ArrayList<String>();
	
	//Methods
	
	/*
	 * verify promotions page was loaded as expected
	 */
	public void promotionsPageLoaded() {
		WaitForLoad();
		WaitForElement(promotionsHeader);
		WebElement objTitle = getGetWebElement(promotionsHeader);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("Promociones", currentTitle);
	}
	
	/*
	 * selects the lightning deals and wait to apply the filter, also verify the filter was applied
	 */
	public void selectLightningDeals(JavascriptExecutor js){
		WebElement findLightningDealsBtn = objDriver.findElement(lightningDealsBtn);
		js.executeScript("arguments[0].scrollIntoView();",findLightningDealsBtn);
		Click(lightningDealsBtn);
		
		try {
			WaitForLoad();
			WebElement lightningDealsFilter = objDriver.findElement(lightningDealsFilterAppliedLocator);
			js.executeScript("arguments[0].scrollIntoView();", lightningDealsFilter);
			WaitForElement(lightningDealsFilterAppliedLocator);
			System.out.println("The lightning deals filter was applied");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			System.out.println("the lightning deals filter was not applied");
		}
		
		
	}
	
	/*
	 * obtains a list with all the products provided by Amazon in each page of lightning deals and put each in a list.
	 */
	public void obtainListOfProducts(JavascriptExecutor js){
		WaitForLoad();
		WebElement NumberOfPagesInLightningDeals = objDriver.findElement(NumberOfPagesInLightningDealsLocator);
		js.executeScript("arguments[0].scrollIntoView();",NumberOfPagesInLightningDeals);
		String numberOfPagesString = NumberOfPagesInLightningDeals.getAttribute("textContent");
		Integer numberOfPages = Integer.valueOf(numberOfPagesString);
		System.out.println("The number of pages in lightning deals is "+numberOfPages);
		
		
		for(int i=0; i<numberOfPages; i++) { //goes through all the pages of lightning deals
			WaitForLoad();
			
			for(int j = 1; j<=numberOfProductsPerPage; j++) { //goes through all the products in each page
				WaitForLoad();
				String ConcatenatedNameOfCurrentProductXpath = (namesOfTheProductsStringXpath+"["+j+"]");
				By nameOfCurrentProductLocator = By.xpath(ConcatenatedNameOfCurrentProductXpath);
				
				try {
					
					WebElement NameOfProduct = objDriver.findElement(nameOfCurrentProductLocator);
					js.executeScript("arguments[0].scrollIntoView();",NameOfProduct);
					WaitForElement(nameOfCurrentProductLocator);
					String nameOfCurrentProduct = NameOfProduct.getAttribute("textContent");
					listOfProducts.add(nameOfCurrentProduct);
					
					
				} catch (Exception e) {
					System.out.println("There seems no more products, must be the end of the lightning deals.");
					j=numberOfProductsPerPage;
				}
				
			}
				
			if(i!=numberOfPages-1) {	//clicks on the 'next page button' only if its not the last page
				WebElement findNextPageBtn = objDriver.findElement(nextPageBtn);
				js.executeScript("arguments[0].scrollIntoView();",findNextPageBtn);
				Click(nextPageBtn);
			}
			
		}
		
		
	}
}
