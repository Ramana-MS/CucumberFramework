package stepDefintion;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage ;
	private AccountPage accountPage;
	CommonUtils commonUtils;
	@Given("User has navigated to login page")
    public void user_has_navigated_to_login_page() {
		driver=DriverFactory.getdriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		loginPage=homepage.selectLoginOption();
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String email) {
        
        loginPage.emailAddress(email);
	}

	@When("User enters valid password {string} into passwords field")
	public void user_enters_valid_password_into_passwords_field(String password) {
        loginPage.passwordAddress(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
       accountPage= loginPage.clicksOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
    Assert.assertTrue(accountPage.getSuccessfullyLoggedin());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commonUtils= new CommonUtils();
        loginPage.emailAddress(commonUtils.getEmailWithTimeStamp());

	}

	@When("User enters invalid password {string} into passwords field")
	public void user_enters_invalid_password_into_passwords_field(String invalidpassword) {
           loginPage.passwordAddress(invalidpassword);

	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
    Assert.assertTrue(loginPage.getWarningText().contains("Warning: No match for E-Mail Address and/or Password."));
  
    }

	
	@When("User dont enters email address into email field")
	public void user_dont_enters_email_address_into_email_field() {
		loginPage.emailAddress(" ");


	}

	@When("User dont enters password into password field")
	public void user_dont_enters_password_into_password_field() {
		loginPage.passwordAddress(" ");
	}
	
	


	
}