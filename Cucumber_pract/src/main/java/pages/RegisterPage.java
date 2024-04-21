package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy (xpath="//input[@name='newsletter'][@value='1']")
	private WebElement subscription;
	
	@FindBy (name="agree")
	private WebElement privacypolicyOption;
	
	@FindBy (xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	@FindBy (xpath="//div[contains(@class,'alert')]")
	private WebElement warningmessage;
	
	@FindBy (xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningFirstName;
	
	@FindBy (xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement warningLastName;
	
	@FindBy (xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement warningEmail;
	
	@FindBy (xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement warningTelephone;
	
	@FindBy (xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement warningPassword;
	

	public void enterFirstName(String firstname) {
		firstNameField.sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		lastNameField.sendKeys(lastname);
	}
	
	public void enterEmailAddress(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterTelephoneNumber(String telephone) {
		telephoneField.sendKeys(telephone);
		}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
			}
	
	public void confirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}
	
	public void selectYes() {
		subscription.click();
	}
	public void selectPrivacyPolicy() {
		privacypolicyOption.click();
	}
	public AccountSuccessPage clickOnContinue() {
		continuebutton.click();
		return new AccountSuccessPage(driver);
	}
	
	public String getProperWarningMessage() {
		return warningmessage.getText();
	}
	
	public String getFirstnameWarning() {
		return warningFirstName.getText();
	}
	public String getLastnameWarning() {
		return warningLastName.getText();
	}
	public String getEmailWarning() {
		return warningEmail.getText();
	}
	public String getTelephoneWarning() {
		return warningTelephone.getText();
	}
	public String getPasswordWarning() {
		return warningPassword.getText();
	}
}
