package qa.crm.qa.test;



import org.testng.Assert;
import org.testng.annotations.*;

import iq.crm.qa.base.TestBase;
import iq.crm.qa.pages.ContactsPage;
import iq.crm.qa.pages.HomePage;
import iq.crm.qa.pages.LoginPage;
import iq.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
    ContactsPage contactsPage;
    
    String sheetName = "contacts";
    
    public ContactPageTest() {
    	super();
    }
	
    @BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
    }
    
    
    @Test(priority=1, enabled = true)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLable(), "contacts label is missing on the page");
	}
	
	@Test(priority=2, enabled = false)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("ara pie");
	}
	
	@Test(priority=3, enabled = false)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("ara pie");
		contactsPage.selectContactsByName("apple pie");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		
		homePage.clickonNewContactLink();
		//contactsPage.createNewContact("Mr.","Tom","Peter","FB");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

    
    
}
