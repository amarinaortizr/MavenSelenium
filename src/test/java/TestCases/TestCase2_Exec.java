package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import POM.CartPage;
import POM.CheckoutPage;
import POM.CheckoutSucsessPage;
import POM.TVPage;
import selenium.ClsBrowser;
import selenium.ClsReport;

public class TestCase2_Exec extends ClsBrowser
{
	@Rule public TestName TC_Name = new TestName();
	public String URL;
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport();
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 	
	
	@Test
	public void SecondTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Scenario 2");
			
			URL = "http://live.guru99.com/index.php/tv.html";
			NavigateToUrl(URL);
			WaitForLoad();
			
			TVPage objHomeTVPage = new TVPage();
			CartPage objCartPage = new CartPage();
			CheckoutPage objCheckoutPage = new CheckoutPage();
			CheckoutSucsessPage objCheckoutSucsessPage = new CheckoutSucsessPage();
					
			
			objHomeTVPage.addItemToCart(objHomeTVPage.samsungLCDAddToCartBtn);
			objCartPage.verifyItemAddedToCart(objCartPage.samsungLCDLocator, objCartPage.samsungLCDString);
			objCartPage.proceedToCheckout();
			objCheckoutPage.chooseCheckoutMethod();
			objCheckoutPage.fillBillingInformation();
			objCheckoutPage.continueShippingMethod();
			objCheckoutPage.choosePayment();
			objCheckoutPage.placeOrder();
			objCheckoutSucsessPage.verifyCheckoutSuccess();
			objCheckoutSucsessPage.getOrderNumber();
			
			
			ClsReport.fnLog(Status.PASS, "Shopping completed successfully", true);

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
