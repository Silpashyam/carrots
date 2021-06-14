package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void beforeClass()
	{
		utilobj = new Utility();
		driver = BaseClass.getDriver();
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
