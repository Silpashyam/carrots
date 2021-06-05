package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.ProjectsPage;
import utilities.Utility;

public class ProjectsTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	ProjectsPage projectsobj;
	LoginTest logintestobj;

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

	@Test(priority = 1)
	public void projectmenucheck() throws InterruptedException {
		Thread.sleep(3000);
		projectsobj = new ProjectsPage(driver);
		utilobj.click(projectsobj.Projectsmenu);
		String titlefromsite = utilobj.getText(projectsobj.Projectspagetitle);
		String title = "Projects";
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(title, titlefromsite, "project page opened is correct");
		objassert.assertAll();
	}

	@Test(priority = 2)
	public void addproject() throws InterruptedException {
		Thread.sleep(3000);
		projectsobj = new ProjectsPage(driver);
		utilobj.click(projectsobj.NewProject);
		projectsobj.ProjectNo.clear();
		utilobj.textboxValueEnter(projectsobj.ProjectNo, "project001");
		String Projectname = "Sampleproject01";
		utilobj.textboxValueEnter(projectsobj.ProjectName, Projectname);
		utilobj.selectByValue(projectsobj.SelectClient, "4");
		int indexvalue = 0;
		Actions act = new Actions(driver);
		act.moveToElement(projectsobj.Slider).dragAndDropBy(projectsobj.Slider, 300, 0).build().perform();

		utilobj.click(projectsobj.StartDate);
		String startmonth = "June 2021";
		String day = "10";
		Thread.sleep(2000);
		while (true) {
			String text = projectsobj.StartDatemonthyear.getText(); // System.out.println(text);
			if (text.equals(startmonth))
				break;
			else
				utilobj.click(projectsobj.StartDateprevious);
		}
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr[3]/td[4]")).click();
		utilobj.click(projectsobj.EndDate);
		String endmonth = "June 2021";
		String endday = "10";
		Thread.sleep(2000);
		while (true) {
			String text = projectsobj.StartDatemonthyear.getText(); // System.out.println(text);
			if (text.equals(endmonth))
				break;
			else
				utilobj.click(projectsobj.StartDateprevious);
		}
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr[3]/td[4]")).click();

		utilobj.selectByIndex(projectsobj.BillingType, indexvalue);
		int fixedprice = 50;
		utilobj.textboxValueIntEnter(projectsobj.FixedPrice, fixedprice);
		int estimatehours = 20;
		utilobj.textboxValueIntEnter(projectsobj.EstimatedHours, estimatehours);
		utilobj.selectByVisibleText(projectsobj.Status, "In Progress");
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
		String projectnamefromsite = projectsobj.projectnameaftersave.getText();
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(Projectname, projectnamefromsite, "project created successfully");
		objassert.assertAll();
		System.out.println("project created successfully");

	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}
}
