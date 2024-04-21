package stepDefintion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;
public class Register {
	WebDriver driver;
	private HomePage homepage; 
	private RegisterPage registerpage;
private AccountSuccessPage	accountSuccessPage;
private CommonUtils commonUtils;
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getdriver();
		homepage= new HomePage(driver);
		homepage.clickOnMyAccount();
       registerpage= homepage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {

	Map<String, String> datamap=  dataTable.asMap(String.class,String.class);

        registerpage.enterFirstName(datamap.get("firstName"));
        registerpage.enterLastName(datamap.get("lastName"));
        commonUtils=new CommonUtils();
        registerpage.enterEmailAddress(commonUtils.getEmailWithTimeStamp1());
        registerpage.enterTelephoneNumber(datamap.get("telephone"));
        registerpage.enterPassword(datamap.get("password"));
        registerpage.confirmPassword(datamap.get("password"));
	}
    @When("User enters the details into below fields with duplicate email")
    public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
    	
    	Map<String, String> datamap=  dataTable.asMap(String.class,String.class);
    	registerpage.enterFirstName(datamap.get("firstName"));
        registerpage.enterLastName(datamap.get("lastName"));
        registerpage.enterEmailAddress(datamap.get("email"));
        registerpage.enterTelephoneNumber(datamap.get("telephone"));
        registerpage.enterPassword(datamap.get("password"));
        registerpage.confirmPassword(datamap.get("password"));
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter(){
		registerpage.selectYes();
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
          registerpage.selectPrivacyPolicy();
	}

	@When("User Clicks on Continue button")
	public void user_clicks_on_continue_button() {
    accountSuccessPage=registerpage.clickOnContinue();
	}

	@Then("User should get created successfully")
	public void user_should_get_created_successfully() {
		
Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
 //  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).getText().contains("Your Account Has Been Created!"));
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
    Assert.assertEquals("Warning: E-Mail Address is already registered!",registerpage.getProperWarningMessage());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText().contains("Warning: E-Mail Address is already registered!"));
    
	}
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		//intentionally blank
		registerpage.enterFirstName(" ");
        registerpage.enterLastName(" ");
        registerpage.enterEmailAddress(" ");
        registerpage.enterTelephoneNumber(" ");
        registerpage.enterPassword(" ");
        registerpage.confirmPassword(" ");
	}

	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {
    Assert.assertTrue(registerpage.getProperWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
    Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstnameWarning());
    Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastnameWarning());
    Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning());
    Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
    Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarning());
	}
	
}