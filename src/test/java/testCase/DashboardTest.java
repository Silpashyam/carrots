package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.TasksPage;
import utilities.ActionsHelper;
import utilities.AlertHelper;
import utilities.SelectHelper;
import utilities.Utility;
import utilities.WaitHelper;

public class DashboardTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	DashboardPage dashboardobj;
	SelectHelper selectobj;
	ActionsHelper actionsobj;
	AlertHelper alertobj;
	WaitHelper waitobj;
	@BeforeTest
	public void beforeTest() throws InterruptedException {
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
	@Test(priority = 1,enabled=true) // TESTCASE NUMBER = 24
	public void dashboardmenucheck() {
		dashboardobj = new DashboardPage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver, dashboardobj.Dashboardmenu, 30);
		utilobj.click(element);
		String titlefromsite = utilobj.getText(dashboardobj.Dashboardpagetitle);
		String title = "Dashboard";
		Assert.assertEquals(title, titlefromsite, "Dashboard page opened is correct");
	}
}
