package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckOutPageFinal extends TestBase {

	@FindBy(id="continue") private WebElement continueButton;
 @FindBy(xpath="//span[@class=\"title\"]") private WebElement infoText;
 @FindBy(id="finish") private WebElement finishButton;
	public CheckOutPageFinal() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement continueButton()
	{
		return continueButton;
	}
	
	public String verifyCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifytext() {
	return infoText.getText();	
	}
	
	public WebElement verifyFinishFunctionality() {
		return finishButton;
	}
}

