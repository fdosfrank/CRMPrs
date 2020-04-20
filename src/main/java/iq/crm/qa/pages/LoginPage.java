package iq.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import iq.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory = OR
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(linkText = "//a[contains(text(),'Sign Up')]")
	WebElement signupLink;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String userN,String passW) {
		userName.sendKeys(userN);
		password.sendKeys(passW);
		loginBtn.click();
		return new HomePage();
	}
	
}
