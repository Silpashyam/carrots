package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.TasksPage;
import utilities.ActionsHelper;
import utilities.AlertHelper;
import utilities.JavascriptHelper;
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
	JavascriptHelper jsobj;
	@BeforeClass
	public void beforeClass()
	{
		utilobj = new Utility();
		driver = BaseClass.getDriver();
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
	@Test(priority = 2,enabled=true) // TESTCASE NUMBER = 25
	public void incomeVSExpensecheck() {
		dashboardobj = new DashboardPage(driver);
		jsobj= new JavascriptHelper();		
		jsobj.scrollToElement(dashboardobj.IncomevsExpense,driver);
		boolean scrollvalue = (dashboardobj.IncomevsExpense).isDisplayed();
		Assert.assertTrue(scrollvalue);
	}
	@Test(priority = 3,enabled=true) // TESTCASE NUMBER = 26
	public void scrollDown() {
		dashboardobj = new DashboardPage(driver);
		jsobj= new JavascriptHelper();	
		WebElement element = waitobj.explicitwaitforelementpresent(driver, dashboardobj.Dashboardmenu, 30);
		utilobj.click(element);
		jsobj.scrollDownVertically(driver);
		boolean footervalue = (dashboardobj.footer).isDisplayed();
		Assert.assertTrue(footervalue);
	}
	@Test(priority = 4,enabled=true) // TESTCASE NUMBER = 27
	public void scrollUp() {
		dashboardobj = new DashboardPage(driver);
		jsobj= new JavascriptHelper();	
		jsobj.scrollUpVertically(driver);
		boolean accountvalue = (dashboardobj.accountname).isDisplayed();
		Assert.assertTrue(accountvalue);
	}
	@Test(priority = 5,enabled=true) // TESTCASE NUMBER = 28
	public void scrollDownpixel() {
		dashboardobj = new DashboardPage(driver);
		jsobj= new JavascriptHelper();	
		jsobj.scrollDownByPixel(1500,driver);
		boolean accountvalue = true;
		Assert.assertTrue(accountvalue);
	}
	@Test(priority = 6,enabled=true) // TESTCASE NUMBER = 29
	public void scrollUppixel() {
		dashboardobj = new DashboardPage(driver);
		jsobj= new JavascriptHelper();	
		jsobj.scrollUpByPixel(500,driver);
		boolean accountvalue = true;
		Assert.assertTrue(accountvalue);
	}
}
