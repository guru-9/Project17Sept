package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath = "//div[@class='bot_column']") private WebElement botLogo;
	@FindBy(id="user-name") private WebElement userNameBox;
	@FindBy(xpath="//input[@id=\"password\"]") private WebElement passBox;
	@FindBy(xpath="//input[@id=\"login-button\"]") private WebElement submitButton;


	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}


	public String verifyTitle() throws Exception
	{
		Thread.sleep(2000);
		return driver.getTitle();
	}

	public String verifyCurrentUrl() throws Exception

	{
		Thread.sleep(2000);
		return driver.getCurrentUrl();

	}

	public Boolean verifyLoginLogo() throws Exception
	{
		Thread.sleep(2000);
		return loginLogo.isDisplayed();
	}

	public Boolean verifyBoatLogo() throws Exception
	{
		Thread.sleep(2000);
		return botLogo.isDisplayed();
	}

	public void VerifyLoginInfo() throws Exception
	{
		Thread.sleep(2000);
		userNameBox.click();
		Thread.sleep(2000);
		//		userNameBox.sendKeys(ReadData.readExcel(0, 0));
		//		Thread.sleep(2000);
		userNameBox.sendKeys(ReadData.readPropertyFile("username"));
		Thread.sleep(2000);	
		passBox.click();
		Thread.sleep(2000);	
		
		
		
		//		passBox.sendKeys(ReadData.readExcel(0, 1));
		passBox.sendKeys(ReadData.readPropertyFile("password"));
		Thread.sleep(2000);	
		submitButton.click();

	}
}
