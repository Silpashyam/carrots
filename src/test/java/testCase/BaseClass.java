package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pageObjects.LoginPage;
import utilities.Utility;

public class BaseClass  {
	
	
	public static WebDriver driver;
	
	public BaseClass(WebDriver driver)
	{
		this.driver=driver;
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
	
}