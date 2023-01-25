package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckOutPage1 extends TestBase {
	
	@FindBy(xpath="//button[@class=\"btn btn_action btn_medium checkout_button\"]") private WebElement checkOutButton;
	@FindBy(xpath="//span[@class=\"title\"]") private WebElement yourInfoText;
	@FindBy(id="first-name") private WebElement nameTextBox;
	@FindBy(id="last-name") private WebElement lastNameTextBox;
	@FindBy(id="postal-code") private WebElement postalTextBox;
	public CheckOutPage1() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement CheckoutButton()
	{
		return checkOutButton;
	}
	public String verifyCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public WebElement nameTextBox() {
		return nameTextBox;
		
	}
	
	public WebElement lastNameTextBox()
	{
		return lastNameTextBox;
		
	}
	
	public WebElement postalCodeTb()
	{
		return postalTextBox; 
	}
	

}
