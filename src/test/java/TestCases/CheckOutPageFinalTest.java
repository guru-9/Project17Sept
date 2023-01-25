package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutPage1;
import Pages.CheckOutPageFinal;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class CheckOutPageFinalTest extends TestBase {

	InventoryPage inv;
	LoginPage log;
	CartPage cr;
	CheckOutPage1 ch;
	CheckOutPageFinal cf;

	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();

		log = new LoginPage();
		Thread.sleep(2000);
		log.VerifyLoginInfo();
		 Thread.sleep(5000);
		inv = new InventoryPage();
		inv.addBackPack().click();
		 Thread.sleep(5000);
		inv.addJacket().click();
		 Thread.sleep(5000);
		
		cr= new CartPage();
	    cr.cartContainer().click();
	    Thread.sleep(5000);
	    
	    ch= new CheckOutPage1();
	    ch.CheckoutButton().click();
	    ch.nameTextBox().sendKeys(ReadData.readExcel(0, 0));
	    Thread.sleep(1000);
	    ch.lastNameTextBox().sendKeys(ReadData.readExcel(1, 0));
	    Thread.sleep(1000);
	    ch.postalCodeTb().sendKeys(ReadData.readExcel(2, 0));
	    Thread.sleep(1000);
	    
	    cf = new CheckOutPageFinal();
	    cf.continueButton().click();
	    
		Thread.sleep(5000);
	}

	@Test(enabled=false)
	public void verifyCurrentUrlTest()
	{
		String act=cf.verifyCurrentUrl();
		String exp="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(act, exp);
	}

	@Test (enabled=false)
	public void verifyTextTest() 
	{
		String act = cf.verifytext();
		String exp = "Checkout: Overview";
		Assert.assertEquals(act, exp);
	}

	@Test(priority=1)
	public void verifyFinishFunctionalityTest() throws Exception
	{
		cf.verifyFinishFunctionality().click();
		Thread.sleep(5000);
		Reporter.log("Functionality Tested Properly");
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
