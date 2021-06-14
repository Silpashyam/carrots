package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ScreenshotHelper;
import utilities.Utility;
import utilities.WaitHelper;

public class HomeTest {
	WebDriver driver;
	Utility utilobj;
	HomePage homeobj;
	WaitHelper waitobj;
	LoginPage loginobj;
	ScreenshotHelper scrobj;

	@BeforeClass
	public void beforeClass()
	{
		utilobj = new Utility();
		driver = BaseClass.getDriver();
	}
	 
	@Test(priority = 1, enabled = true)  // TESTCASE NUMBER = 7
	public void verifyHomeUrl() {
		homeobj = new HomePage(driver);
		String urlfromsite = utilobj.getUrl(driver);
		String url = "http://buffalocart.com/demo/erp/admin/dashboard";
		Assert.assertEquals(url, urlfromsite, "Home Url verification=sucess");
	}

	@Test(priority = 2, enabled = true) // TESTCASE NUMBER = 8
	public void verifyHomeTitle() throws IOException {
		homeobj = new HomePage(driver);
		scrobj = new ScreenshotHelper();
		String Titlefromsite = utilobj.getTitle(driver);
		String title = "Codecarrotss";
		//Assert.assertEquals(title, Titlefromsite, "Home Title verification=sucess");
		if (Titlefromsite.equals(title)) {
			Assert.assertTrue(true);
		} else {
			scrobj.screenshot(driver, "HomeTitleTest");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3, enabled = true) // TESTCASE NUMBER = 9
	public void verifyLogo() {
		homeobj = new HomePage(driver);
		boolean logo = (homeobj.logo).isDisplayed();
		Assert.assertTrue(logo);
	}

	@Test(priority = 4, enabled = true) // TESTCASE NUMBER = 10
	public void verifyUserLoggedin() throws IOException {
		homeobj = new HomePage(driver);
		scrobj = new ScreenshotHelper();
		String Titlefromsite = utilobj.getText(homeobj.accountname);
		String title = "demos";
		//Assert.assertEquals(title, Titlefromsite, "Home Title verification=sucess");
		if (Titlefromsite.equals(title)) {
			Assert.assertTrue(true);
		} else {
			scrobj.screenshot(driver, "UserLoggedinTest");
			Assert.assertTrue(false);
		}
	}

}
