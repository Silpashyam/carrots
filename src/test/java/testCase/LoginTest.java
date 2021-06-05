package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.Utility;

public class LoginTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	@BeforeTest
	  public void beforeTest()  {
			utilobj = new Utility();
			driver = utilobj.LaunchBrowser("chrome","http://buffalocart.com/demo/erp/login");	
		}
	@Test(priority=1,enabled=true)
	public void incorrectUnameIncorrectPwd()
	{
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username,"admin1");
		utilobj.textboxValueEnter(loginobj.password,"admin1");
		utilobj.click(loginobj.signin);		
		if(driver.getPageSource().contains("username or password information doesn't exist!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	@Test(priority=2,enabled=true)
	public void incorrectUnameCorrectPwd() throws InterruptedException
	{
		Thread.sleep(3000);
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username,"admin2");
		utilobj.textboxValueEnter(loginobj.password,"123456");
		utilobj.click(loginobj.signin);		
		if(driver.getPageSource().contains("username or password information doesn't exist!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	@Test(priority=3,enabled=true)
	public void CorrectUnameIncorrectPwd() throws InterruptedException
	{
		Thread.sleep(3000);
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username,"admin");
		utilobj.textboxValueEnter(loginobj.password,"admin3");
		utilobj.click(loginobj.signin);		
		if(driver.getPageSource().contains("username or password information doesn't exist!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	@Test(priority=4,enabled=true)
	public void CorrectUnameCorrectPwd() throws InterruptedException
	{
		Thread.sleep(3000);
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username,"admin");
		utilobj.textboxValueEnter(loginobj.password,"123456");
		utilobj.click(loginobj.signin);		
		Thread.sleep(5000);
		if(driver.getTitle().equals("Codecarrots"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
  
  @AfterTest
	public void afterTest() {
		driver.close();
	}
}
