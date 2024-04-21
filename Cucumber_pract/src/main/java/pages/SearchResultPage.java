package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement displayValidProduct;
	
	@FindBy(xpath="//input[@id='button-search']//following-sibling::p")
	private WebElement noProductmessage;
	
	
	public boolean displayStatusOfValidProduct() {
		return displayValidProduct.isDisplayed();
	}
	
	public String getProductNotMatching() {
	return	noProductmessage.getText();
	}
}
