package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.LoginPage;
import utilities.Utility;

public class BaseClass  {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	
	public void CorrectUnamePwd() throws InterruptedException
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

}


//  excel
// data provider
// screenshot
// wait
// action class common
// gettitle, get url coomon method
// scroll down
// window handles
// 30 testcases
// parameter testng
// parallel testng
// dependency test