package stepDefintion;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;
public class Search {
	WebDriver driver;
	private HomePage homepage ;
	private SearchResultPage searchresultpage;
	 
	@Given("User opens the Application")
	public void user_opens_the_application() {
    driver= DriverFactory.getdriver();
        
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) {
    homepage = new HomePage(driver);
    homepage.enterProductInSearch(validProduct);}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchresultpage= homepage.clickOnSearchButton();
	}

	@Then("User should get  valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
     Assert.assertTrue(searchresultpage.displayStatusOfValidProduct());
	}
	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
		 homepage = new HomePage(driver);
       homepage.enterProductInSearch(invalidproduct);	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		 
     // Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']//following-sibling::p")).getText().contains("There is no product that matches the search criteria."));
		Assert.assertEquals("There is no product that matches the search criteria.",searchresultpage.getProductNotMatching());

	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		 homepage = new HomePage(driver);
	}



}
