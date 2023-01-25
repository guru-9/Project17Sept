package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage login;
	
	@BeforeMethod
		public void setup() throws Exception
		{
		 initialization();
		 login= new LoginPage();
		}


	@Test
	public void verifyTitleTest() throws Exception
	{
		String expTitle = "Swag Labs";
		 String act = login.verifyTitle();
		 Assert.assertEquals(act, expTitle);
	   
	    
	}

	@Test
	public void verifyCurrentUrlTest() throws Exception
	{
		String expUrl = "https://www.saucedemo.com/";
//		String actUrl = login.verifyCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actUrl, expUrl);
		
		
	}

	@Test
	public void verifyLoginLogoTest() throws Exception
	{
		boolean result= login.verifyLoginLogo();
		Assert.assertEquals(result, true);
	}

	@Test
	public void verifyBotLogoTest() throws Exception
	{
		boolean result1= login.verifyBoatLogo();
		Assert.assertEquals(result1, true);
	}

	@Test
	public void VerifyLoginInfoTest() throws Exception
	{
		login.VerifyLoginInfo();
	}


	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

	}

