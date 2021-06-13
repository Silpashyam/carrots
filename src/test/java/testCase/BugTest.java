package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.BugPage;
import pageObjects.LoginPage;
import utilities.SelectHelper;
import utilities.Utility;
import utilities.WaitHelper;

public class BugTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	BugPage bugobj;
	WaitHelper waitobj;
	SelectHelper selectobj;

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

	@Test(priority = 1, enabled = true) // TESTCASE NUMBER = 20
	public void bugsmenucheck() {
		bugobj = new BugPage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver, bugobj.Bugsmenu, 30);
		utilobj.click(element);
		String titlefromsite = utilobj.getText(bugobj.Bugpagetitle);
		String title = "Bugs";
		Assert.assertEquals(title, titlefromsite, "Bugs page opened is correct");
	}

	@Test(priority = 2, enabled = true) // TESTCASE NUMBER = 21
	public void addBug() {
		selectobj = new SelectHelper();
		utilobj.click(bugobj.NewBug);
		String issuenumber = utilobj.getText(bugobj.IssueNumber);
		if (issuenumber == null)
			utilobj.textboxValueEnter(bugobj.IssueNumber, "Issue001");
		utilobj.textboxValueEnter(bugobj.Bugtitle, "Bug001");
		selectobj.selectByVisibleText(bugobj.RelatedTo, "Projects");
		if ((bugobj.SelectProject).isDisplayed()) {
			selectobj.selectByVisibleText(bugobj.SelectProject, "SampleProject006");
		}
		selectobj.selectByIndex(bugobj.Reporter, 0);
		selectobj.selectByVisibleText(bugobj.Priority, "High");
		selectobj.selectByVisibleText(bugobj.Severity, "Minor");
		utilobj.textboxValueEnter(bugobj.Description, "Bug Decription");
		utilobj.textboxValueEnter(bugobj.Reproducibility, "Bug Reproducibility");
		selectobj.selectByVisibleText(bugobj.Bugstatus, "In Progress");
		Boolean Value = (bugobj.AssignedToEveryone).isSelected();
		// System.out.println(Value);
		if ((bugobj.AssignedToEveryone).isSelected()) {
			utilobj.click(bugobj.AssignedToEveryone);
		} else {
			utilobj.click(bugobj.AssignedToCutomize);
		}
		if ((bugobj.SelectUsers).isDisplayed()) {
			utilobj.click(bugobj.SelectUsers);
		}
		utilobj.click(bugobj.save);
		String Projectname = "New Test Project";
		String namefromsite = utilobj.getText(bugobj.bugname);
		Assert.assertEquals(Projectname, namefromsite, "Bug created successfully");
	}

	@Test(priority = 3, enabled = true) // TESTCASE NUMBER = 22
	public void verifyBug() {
		utilobj.click(bugobj.bugheading);
		int firstpage = 1;
		do {
			if (firstpage == 0) {
				utilobj.click(bugobj.pagination);
			} else {
				firstpage = 0;
			}
			boolean verifybug = driver.getPageSource().contains("Bug001");
			if (verifybug) {
				Assert.assertTrue(true);
				break;
			}
		}

		while (bugobj.pagination.isDisplayed());
	}
}
