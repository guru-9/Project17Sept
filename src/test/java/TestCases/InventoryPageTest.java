package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;

public class InventoryPageTest extends TestBase {
	LoginPage log ;
	InventoryPage inv;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
//		log = new LoginPage();
//		Thread.sleep(2000);
//		log.VerifyLoginInfo();
		login();
		inv = new InventoryPage();
		
	}


	
	
	@Test

	public void verifyInventoryUrlTest() throws Exception
	{

		String exp ="https://www.saucedemo.com/inventory.html";
		String act=inv.verifyInventoryUrl();
		Thread.sleep(2000);
		Assert.assertEquals(act, exp);

	}
	@Test
	public void verifyFooterLogoTest() throws Exception
	{

		boolean act = inv.verifyFooterLogo();
		Thread.sleep(2000);
		Assert.assertTrue(act);

	}

	@Test
	public void verifyDropDownTest() throws Exception
	{

		Thread.sleep(2000);
		inv.dropdownSorting();
	}
 
	@Test
	public void verifyProductTextTest() throws Exception
	{
		Thread.sleep(2000);
		String act=inv.verifyProductText();
		String exp="PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void verifyAddItemsTest()
	{
		inv.addBackPack().click();
		inv.addJacket().click();
		String act=inv.cartChanges().getText();
		String exp = "2";
		Assert.assertEquals(act, exp);
	
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}


}

