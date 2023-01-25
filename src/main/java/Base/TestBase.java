package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CartPage;
import Pages.CheckOutPage1;
import Pages.CheckOutPageFinal;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
//	 LoginPage log;
//	 InventoryPage inv;
	  CartPage cr;
	 CheckOutPage1 ch;
	 CheckOutPageFinal cf;
	 public static void initialization() throws Exception
	 {
		 WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
//		 driver.get("https://www.saucedemo.com/");
		 driver.get(ReadData.readPropertyFile("url"));
	 }
	 
	 
	 
	 public void login() throws Exception
	 {
		 LoginPage log = new LoginPage();
			Thread.sleep(2000);
			log.VerifyLoginInfo();
	 }
	
	
	
	 
	 
	 //	 public void checkoutpage1() throws Exception
//	 {
//		 log = new LoginPage();
//			Thread.sleep(2000);
//			log.VerifyLoginInfo();
//			 Thread.sleep(5000);
//			inv = new InventoryPage();
//			inv.addBackPack().click();
//			 Thread.sleep(5000);
//			inv.addJacket().click();
//			 Thread.sleep(5000);
//			cr= new CartPage();
//		    cr.cartContainer().click();
//		    Thread.sleep(5000);
//	 }

}
