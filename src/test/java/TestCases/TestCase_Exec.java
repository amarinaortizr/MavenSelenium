package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.Status;
import POM.AmazonLoginPage;
import POM.HomePage;
import POM.PromotionsPage;
import selenium.ClsBrowser;
import selenium.ClsReport;

public class TestCase_Exec extends ClsBrowser
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
	public void FirstTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
			URL = "https://www.amazon.com.mx/";
			NavigateToUrl(URL);
			WaitForLoad();
			HomePage objHomePage = new HomePage();
			AmazonLoginPage objLogin = new AmazonLoginPage();
			PromotionsPage objPromotionsPage = new PromotionsPage();
			JavascriptExecutor js = (JavascriptExecutor)objDriver;
			
			objHomePage.goToLogInPage();
			objLogin.enterCredential();
			objLogin.startSession();
			objLogin.skipAddNumberDialog();
			objHomePage.verifyActiveSession();
			objHomePage.goToPromotionsPage();
			objPromotionsPage.promotionsPageLoaded();
			objPromotionsPage.selectLightningDeals(js);
			objPromotionsPage.ObtainListOfProducts(js);
			ClsReport.fnLog(Status.INFO, "List with all the products in lightning deals provided by Amazon:", false);
			
			for (String s :objPromotionsPage.listOfProducts) {
				ClsReport.fnLog(Status.INFO, s, false);
			}
			ClsReport.fnLog(Status.PASS, "Test ended successfully.", true);

			
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
