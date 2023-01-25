package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase{
	InventoryPage inv;
	LoginPage log;
	CartPage cr;

	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		
		//		cart();
//				log = new LoginPage();
//				Thread.sleep(2000);
//				log.VerifyLoginInfo();
//				 Thread.sleep(5000);
             	login();
				 
				inv = new InventoryPage();
				inv.addBackPack().click();
				 Thread.sleep(2000);
				inv.addJacket().click();
				 Thread.sleep(2000);
				
	
				cr= new CartPage();
			    cr.cartContainer().click();
			    Thread.sleep(2000);
	}

	@Test(enabled=false)
	public void verifyCurrentUrlTest()
	{
		String act =cr.verifyCurrentUrl();
		String exp ="https://www.saucedemo.com/cart.html";
		Assert.assertEquals(act, exp);
	}

	@Test(enabled=false)
	public void verifyYourCartTest()
	{
		String act = cr.verifyYourCart();
		String exp = "Your Cart";
		Assert.assertEquals(act, exp);
	}
	@Test
	public void verifyRemoveFunctionalityTest() throws Exception
	{
		cr.removeButton().click();
		Thread.sleep(5000);
		String act= inv.cartChanges().getText();
		String exp="1";
		Assert.assertEquals(act, exp);
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}


}
