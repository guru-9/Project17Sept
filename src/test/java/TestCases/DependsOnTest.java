package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class DependsOnTest extends TestBase{
	
	LoginPage login;
	
	@BeforeMethod (alwaysRun=true)
		public void setup() throws Exception
		{
		 initialization();
		 login= new LoginPage();
		}


	@Test /*(priority=2)*/ (groups= {"Sanity","Regression"})
	public void verifyTitleTest() throws Exception
	{
		String expTitle = "Swag Labs";
		 String act = login.verifyTitle();
		 Assert.assertEquals(act, expTitle);
	   
	    
	}

	@Test/*(priority=3)*/ (groups="Sanity")
	public void verifyCurrentUrlTest() throws Exception
	{
		String expUrl = "https://www.saucedemo.com/";
//		String actUrl = login.verifyCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actUrl, expUrl);
		
		
	}

	@Test/*(priority=4)*/ (groups= {"Smoke","Regression"})
	public void verifyLoginLogoTest() throws Exception
	{
		boolean result= login.verifyLoginLogo();
		Assert.assertEquals(result, true);
	}

	@Test/*(priority=-1)*/ (groups="Smoke")
	public void verifyBotLogoTest() throws Exception
	{
		boolean result1= login.verifyBoatLogo();
		Assert.assertEquals(result1, true);
	}
	

	@Test /*(priority=1)/(dependsOnMethods= {"verifyTitleTest","verifyCurrentUrlTest"})*/ (groups="Smoke")
	public void VerifyLoginInfoTest() throws Exception
	{
		login.VerifyLoginInfo();
	}


	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}

	}



