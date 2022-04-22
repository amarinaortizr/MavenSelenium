package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import POM.AccountCreatePage;
import POM.IndexPage;
import POM.TVPage;
import selenium.ClsBrowser;
import selenium.ClsReport;

public class TestCase3_Exec extends ClsBrowser
{
	@Rule public TestName TC_Name = new TestName();
	public String URL;
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.reportLocation ="C:\\Report\\Exercise3_Scenario3.html";
		ClsReport.fnSetupReport();
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 	
	
	@Test
	public void ThirdTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Scenario 3");
			
			URL = "http://live.guru99.com/index.php/tv.html";
			NavigateToUrl(URL);
			WaitForLoad();
			
			TVPage objHomeTVPage = new TVPage();
			AccountCreatePage objRegisterPage = new AccountCreatePage();
			IndexPage objIndexPage = new IndexPage();
			
			objHomeTVPage.goToAccountCreatePage();
			objRegisterPage.createAccount();
			objIndexPage.verifyRegisteringSuccess();
			objIndexPage.verifySession();
			

			ClsReport.fnLog(Status.PASS, "Account created successfully", true);
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