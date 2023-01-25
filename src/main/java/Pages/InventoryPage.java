package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.TestBase;

public class InventoryPage extends TestBase {
//	LoginPage log = new LoginPage();
	
	
	@FindBy(xpath="//img[@class='footer_robot']") private WebElement footerLogo;
	@FindBy(xpath="//select[@class=\"product_sort_container\"]") private WebElement dropDown;
	@FindBy(xpath="//span[@class=\"title\"]") private WebElement productText;
	@FindBy(id="add-to-cart-sauce-labs-backpack") private WebElement addBackpack;
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket") private WebElement addJacket;
	@FindBy(xpath="//span[@class=\"shopping_cart_badge\"]")   private WebElement cart;
	@FindBy(id="shopping_cart_container")   private WebElement cartContainer;
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
		
		public String verifyInventoryUrl() throws Exception
		{
			
			Thread.sleep(2000);
			return driver.getCurrentUrl();
		
		}
		
		public boolean verifyFooterLogo() throws Exception
		{
			Actions a =new Actions(driver);
			a.scrollToElement(footerLogo);
			Thread.sleep(5000);
			return footerLogo.isDisplayed();
		}
		
		public void dropdownSorting() throws Exception
		{
			Actions a =new Actions(driver);
			Thread.sleep(2000);
			a.moveToElement(dropDown).click().build().perform();
			Thread.sleep(2000);
			a.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			a.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		    
		}
		
		public String verifyProductText()
		{
			
			return productText.getText();
			
		}
		
		public WebElement addBackPack()
		{
			return addBackpack;
			
		}
		
		public WebElement addJacket()
		{
			return addJacket;
			
		}
		
		public WebElement cartChanges()
		{
			return cart;
			
		}
		
}
