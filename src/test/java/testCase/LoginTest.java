package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.Utility;
import utilities.WaitHelper;

public class LoginTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	WaitHelper waitobj;

	@BeforeTest
	public void beforeTest() {
		utilobj = new Utility();
		driver = utilobj.LaunchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
	}

	@Test(priority = 1, enabled = true) // TESTCASE NUMBER = 1
	public void verifyUrl() {
		loginobj = new LoginPage(driver);
		String urlfromsite = utilobj.getUrl(driver);
		String url = "http://buffalocart.com/demo/erp/login";
		Assert.assertEquals(url, urlfromsite, "Url verification=sucess");
	}

	@Test(priority = 2, enabled = true) // TESTCASE NUMBER = 2
	public void verifyTitle() {
		loginobj = new LoginPage(driver);
		String Titlefromsite = utilobj.getTitle(driver);
		String title = "Welcome to Codecarrots";
		Assert.assertEquals(title, Titlefromsite, "Title verification=sucess");
	}

	@Test(priority = 3, enabled = true) // TESTCASE NUMBER = 3
	public void incorrectUnameIncorrectPwd() {
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username, "admin1");
		utilobj.textboxValueEnter(loginobj.password, "admin1");
		utilobj.click(loginobj.signin);
		boolean verifylogin = driver.getPageSource().contains("username or password information doesn't exist!");
		Assert.assertTrue(verifylogin);
	}

	@Test(priority = 4, enabled = true) // TESTCASE NUMBER = 4
	public void incorrectUnameCorrectPwd() {
		loginobj = new LoginPage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver, loginobj.username, 30);
		utilobj.textboxValueEnter(element, "admin2");
		utilobj.textboxValueEnter(loginobj.password, "123456");
		utilobj.click(loginobj.signin);
		boolean verifylogin = driver.getPageSource().contains("username or password information doesn't exist!");
		Assert.assertTrue(verifylogin);
	}

	@Test(priority = 5, enabled = true) // TESTCASE NUMBER = 5
	public void CorrectUnameIncorrectPwd() {
		loginobj = new LoginPage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver, loginobj.username, 30);
		utilobj.textboxValueEnter(element, "admin");
		utilobj.textboxValueEnter(loginobj.password, "admin3");
		utilobj.click(loginobj.signin);
		boolean verifylogin = driver.getPageSource().contains("username or password information doesn't exist!");
		Assert.assertTrue(verifylogin);
	}

	@Test(priority = 6, enabled = true) // TESTCASE NUMBER = 6
	public void CorrectUnameCorrectPwd() {
		loginobj = new LoginPage(driver);
		driver.navigate().refresh();
		WebElement element = waitobj.explicitwaitforelementpresent(driver, loginobj.username, 30);
		utilobj.textboxValueEnter(element, "admin");
		utilobj.textboxValueEnter(loginobj.password, "123456");
		utilobj.click(loginobj.signin);
		String Titlefromsite = utilobj.getTitle(driver);
		String title = "Codecarrots";
		Assert.assertEquals(title, Titlefromsite, "Loggined successfully");
	}
}
