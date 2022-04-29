package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.Status;

import POM.FlightPage;
import POM.VolarisPage;
import selenium.ClsBrowser;
import selenium.ClsReport;

public class TestCase_Exec extends ClsBrowser
{
	@Rule public TestName TC_Name = new TestName();
	public String URL;
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.reportLocation ="C:\\Report\\Exercise4.html";
		ClsReport.fnSetupReport();
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 	
	
	@Test
	public void FirstTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Test 1");
			
			URL = "https://www.volaris.com/";
			NavigateToUrl(URL);
			WaitForLoad();
			JavascriptExecutor js = (JavascriptExecutor)objDriver;
			VolarisPage objVolarisPage = new VolarisPage();
			FlightPage objFlightPage = new FlightPage();
			
			
			objVolarisPage.selectTypeOfTrip();
			objVolarisPage.selectOriginAndDestinationCities();
			objVolarisPage.selectGoingAndReturnDates();
			objVolarisPage.searchFlights();
			objFlightPage.selectCheapestGoingFlight();
			objFlightPage.selectCheapestReturnFlight();
			objFlightPage.confirmBaggage();
			objFlightPage.getTotalAndCompareToBudget(js);
			
			
		}
		catch(Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
		
	
	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}

}
