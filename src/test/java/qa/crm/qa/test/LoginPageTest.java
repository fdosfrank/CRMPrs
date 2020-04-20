package qa.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;


import iq.crm.qa.base.TestBase;
import iq.crm.qa.pages.HomePage;
import iq.crm.qa.pages.LoginPage;
import iq.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil utilPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1,enabled = false)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	
	@Test(priority=2,enabled = false)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
