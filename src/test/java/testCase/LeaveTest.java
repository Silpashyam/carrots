package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LeavePage;
import pageObjects.LoginPage;
import pageObjects.TasksPage;
import utilities.AlertHelper;
import utilities.SelectHelper;
import utilities.Utility;
import utilities.WaitHelper;

public class LeaveTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	LeavePage leaveobj;
	AlertHelper alertobj;
	SelectHelper selectobj;
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
	@Test(priority = 1,enabled=true)  // TESTCASE NUMBER = 22
	public void leavemenucheck()  {
		leaveobj = new LeavePage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver,leaveobj.Leavemenu, 30);
		utilobj.click(element);
		String titlefromsite = utilobj.getText(leaveobj.Leavepagetitle);
		String title = "Leave Management";
		Assert.assertEquals(title, titlefromsite, "Leave page opened is correct");
	}
	@Test(priority=2,enabled=true)  // TESTCASE NUMBER = 23
	  public void applyLeave() {
		  leaveobj = new LeavePage(driver);
		  selectobj = new SelectHelper();
		  utilobj.click(leaveobj.applyleave);
		  selectobj.selectByVisibleText(leaveobj.selectusers, "Joe");
		  selectobj.selectByVisibleText(leaveobj.leavecategory, "personal");
		  utilobj.click(leaveobj.duration);
		  utilobj.textboxValueIntEnter(leaveobj.startdate,2021-06-14);
		  selectobj.selectByVisibleText(leaveobj.hours, "08");
		  utilobj.textboxValueEnter(leaveobj.reason, "Personal matter");
		  utilobj.click(leaveobj.submit);
		  boolean verifyleave = driver.getPageSource().contains("personal");
		  Assert.assertTrue(verifyleave);
		  
		  
}
}
