package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.Utility;
import utilities.WaitHelper;

public class HomeTest {
	WebDriver driver;
	Utility utilobj;
	HomePage homeobj;
	WaitHelper waitobj;
	LoginPage loginobj;

	@BeforeTest
	public void beforeTest() {
		utilobj = new Utility();
		driver = utilobj.LaunchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
	}

	@Test
	public void CorrectUnameCorrectPwd() throws InterruptedException {
		Thread.sleep(3000);
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username, "admin");
		utilobj.textboxValueEnter(loginobj.password, "123456");
		utilobj.click(loginobj.signin);
		Thread.sleep(5000);
		if (driver.getTitle().equals("Codecarrots")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1, enabled = true) // // TESTCASE NUMBER = 7
	public void verifyHomeUrl() {
		homeobj = new HomePage(driver);
		String urlfromsite = utilobj.getUrl(driver);
		String url = "http://buffalocart.com/demo/erp/admin/dashboard";
		Assert.assertEquals(url, urlfromsite, "Home Url verification=sucess");
	}

	@Test(priority = 2, enabled = true) // TESTCASE NUMBER = 8
	public void verifyHomeTitle() {
		homeobj = new HomePage(driver);
		String Titlefromsite = utilobj.getTitle(driver);
		String title = "Codecarrots";
		Assert.assertEquals(title, Titlefromsite, "Home Title verification=sucess");
	}

	@Test(priority = 3, enabled = true) // TESTCASE NUMBER = 9
	public void verifyLogo() {
		homeobj = new HomePage(driver);
		boolean logo = (homeobj.logo).isDisplayed();
		Assert.assertTrue(logo);
	}

	@Test(priority = 4, enabled = true) // TESTCASE NUMBER = 10
	public void verifyUserLoggedin() {
		homeobj = new HomePage(driver);
		String Titlefromsite = utilobj.getText(homeobj.accountname);
		String title = "demo";
		Assert.assertEquals(title, Titlefromsite, "Home Title verification=sucess");
	}

}
