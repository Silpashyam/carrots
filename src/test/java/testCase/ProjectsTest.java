package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.ProjectsPage;
import utilities.ActionsHelper;
import utilities.SelectHelper;
import utilities.Utility;
import utilities.WaitHelper;

public class ProjectsTest {
	WebDriver driver;
	Utility utilobj;
	WaitHelper waitobj;
	LoginPage loginobj;
	ProjectsPage projectsobj;
	LoginTest logintestobj;
	SelectHelper selectobj;
	ActionsHelper actionsobj;
	String Projectname = "Sampleproject1";

	public String ProjectName() {
		return Projectname;
	}

	@BeforeClass
	public void beforeClass()
	{
		utilobj = new Utility();
		driver = BaseClass.getDriver();
	}

	@Test(priority = 1, enabled = true) // TESTCASE NUMBER = 11
	public void projectmenucheck() {
		projectsobj = new ProjectsPage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver, projectsobj.Projectsmenu, 30);
		utilobj.click(element);
		String titlefromsite = utilobj.getText(projectsobj.Projectspagetitle);
		String title = "Projects";
		Assert.assertEquals(title, titlefromsite, "project page opened is correct");
	}

	@Test(priority = 2, enabled = true) // TESTCASE NUMBER = 12
	public void addproject() {
		projectsobj = new ProjectsPage(driver);
		selectobj = new SelectHelper();
		actionsobj = new ActionsHelper();
		WebElement element = waitobj.explicitwaitforelementpresent(driver, projectsobj.NewProject, 30);
		utilobj.click(element);
		projectsobj.ProjectNo.clear();
		utilobj.textboxValueEnter(projectsobj.ProjectNo, "project001");
		utilobj.textboxValueEnter(projectsobj.ProjectName, Projectname);
		selectobj.selectByVisibleText(projectsobj.SelectClient, "Shell");
		actionsobj.dragAndDrop(driver, projectsobj.Slider, 300, 0);
		utilobj.click(projectsobj.StartDate);
		String startmonth = "June 2021";
		String day = "10";
		while (true) {
			String text = utilobj.getText(projectsobj.StartDatemonthyear);
			if (text.equals(startmonth))
				break;
			else
				utilobj.click(projectsobj.StartDateprevious);
		}
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr[3]/td[4]")).click();
		utilobj.click(projectsobj.EndDate);
		String endmonth = "June 2021";
		String endday = "10";
		while (true) {
			String text = utilobj.getText(projectsobj.StartDatemonthyear);
			if (text.equals(endmonth))
				break;
			else
				utilobj.click(projectsobj.StartDateprevious);
		}
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr[3]/td[4]")).click();
		int indexvalue = 0;
		selectobj.selectByIndex(projectsobj.BillingType, indexvalue);
		int fixedprice = 50;
		utilobj.textboxValueIntEnter(projectsobj.FixedPrice, fixedprice);
		int estimatehours = 20;
		utilobj.textboxValueIntEnter(projectsobj.EstimatedHours, estimatehours);
		selectobj.selectByVisibleText(projectsobj.Status, "In Progress");
		utilobj.textboxValueEnter(projectsobj.DemoUrl, "http://www.demourl.com");
		if ((projectsobj.AssignedToEveryone).isSelected()) {
			utilobj.click(projectsobj.AssignedToCutomize);
		} else {
			utilobj.click(projectsobj.AssignedToEveryone);
		}
		if ((projectsobj.SelectUsers).isDisplayed()) {
			utilobj.click(projectsobj.SelectUsers);
		}
		utilobj.textboxValueEnter(projectsobj.Description, "Project description");
		utilobj.click(projectsobj.save);
		String projectnamefromsite = utilobj.getText(projectsobj.projectnameaftersave);
		Assert.assertEquals(Projectname, projectnamefromsite, "project created successfully");

	}

}
