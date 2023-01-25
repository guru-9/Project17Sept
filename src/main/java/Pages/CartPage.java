package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {
//	InventoryPage inv = new InventoryPage();
	@FindBy(id="shopping_cart_container")   private WebElement cartContainer;
	@FindBy(xpath="//span[@class=\"title\"]") private WebElement yourCartText;
	@FindBy(id="remove-sauce-labs-backpack")   private WebElement removeButton;
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	 public  WebElement cartContainer()
	   {
		   return cartContainer;
	   }
   public String verifyCurrentUrl()
   {
	   return driver.getCurrentUrl();
	   
   }
   
   public String verifyYourCart()
   {
	return yourCartText.getText();
	   
   }
   
   public WebElement removeButton()
   {
	return removeButton;
	   
   }
  
}
