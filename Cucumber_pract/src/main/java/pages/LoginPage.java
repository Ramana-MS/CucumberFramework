package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickonloginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement warningmessage;
	
	public void emailAddress(String email) {
		emailField.sendKeys(email);
	}
	public void passwordAddress(String password) {
		passwordField.sendKeys(password);
	}
	public AccountPage clicksOnLoginButton() {
		clickonloginbutton.click();
		return new AccountPage(driver);
	}
	 
	public String getWarningText() {
		return warningmessage.getText();
	}
	
	
}
