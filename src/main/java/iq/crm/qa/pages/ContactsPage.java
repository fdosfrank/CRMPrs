package iq.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


import iq.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contatsLable;
	
	
	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstNameValue;
	
	@FindBy(id="surname")
	WebElement surnameValue;
	
	@FindBy(name="client_lookup")
	WebElement companyValue;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLable() {
		return contatsLable.isDisplayed();
		
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']" 
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public void createNewContact(String title,String ftName,String ltName,String companyName) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstNameValue.sendKeys(ftName);
		surnameValue.sendKeys(ltName);
		companyValue.sendKeys(companyName);
		saveBtn.click();
		
	}
	
	
}
