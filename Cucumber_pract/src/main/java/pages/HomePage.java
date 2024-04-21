package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;

public   HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath="//span[text()='My Account']")
private WebElement myAccountDropMenu;

@FindBy(xpath="//a[text()='Login']")
private WebElement loginOption;

@FindBy(linkText="Register")
private WebElement registerOption;

@FindBy(name="search")
private WebElement searchproduct;

@FindBy(xpath="//button[contains(@class,'btn btn-default b')]")
private WebElement searchbutton;


public void clickOnMyAccount() {
	myAccountDropMenu.click();
}
public LoginPage selectLoginOption() {
	loginOption.click();
	return new LoginPage(driver);
}
public RegisterPage selectRegisterOption() {
	registerOption.click();
	return new RegisterPage(driver);
}
public void enterProductInSearch(String validproduct) {
	searchproduct.sendKeys(validproduct);
}
public SearchResultPage clickOnSearchButton() {
	searchbutton.click();
	return new SearchResultPage(driver);
}
}
