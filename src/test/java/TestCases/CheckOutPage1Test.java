package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutPage1;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class CheckOutPage1Test extends TestBase{
	InventoryPage inv;
    LoginPage log;
    CartPage cr;
    CheckOutPage1 ch;
    
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
	    
 }
		
		
	    

	 @Test(enabled=false)
	 public void verifyYourInfoTest() {
		 String act = ch.verifyCurrentUrl();
		 String exp ="https://www.saucedemo.com/checkout-step-one.html";
		 Assert.assertEquals(act, exp);
	 }
	 @Test(enabled=false)
	 public void VerifyNameTest() throws Exception
	 {
		 boolean act=ch.nameTextBox().isDisplayed();
		 Assert.assertTrue(act);
		 ch.nameTextBox().sendKeys("Gururaj");
		 Thread.sleep(5000);
	 }
	 
	 @Test(enabled=false)
	 public void verifyLastNameText() throws InterruptedException
	 {
		 boolean act=ch.lastNameTextBox().isDisplayed();
		 Assert.assertTrue(act);
		 ch.lastNameTextBox().sendKeys("Khot");
		 Thread.sleep(5000);
	 }
	 @Test
	 public void verifypostalTest() throws Exception
	 {
		 boolean act=ch.postalCodeTb().isDisplayed();
		 Assert.assertTrue(act);
		 ch.postalCodeTb().sendKeys("416209");
		 Thread.sleep(5000); 
	 }
	 
 @AfterMethod
 public void closeBrowser()
	{
		driver.close();
	}
}

