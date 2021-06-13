package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.TasksPage;
import utilities.Utility;

public class LogoutTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	LogoutPage logoutobj;
	TasksPage tasksobj;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		utilobj = new Utility();
		driver = utilobj.LaunchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
	}
	@Test(priority=1)
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
	@Test(priority=1)  // TESTCASE NUMBER = 30
	public void Logout() 
	{
		logoutobj = new LogoutPage(driver);
		Boolean value= (logoutobj.demo).isEnabled();
		System.out.println(value);
		if((logoutobj.demo).isDisplayed())
		{
			utilobj.click(logoutobj.demo);
			System.out.println("demo clicked");
			utilobj.click(logoutobj.logout);
			String currenturl= driver.getCurrentUrl();
			Assert.assertEquals(currenturl, "http://buffalocart.com/demo/erp/login","Logout successfully");
		}
		
	}
}
