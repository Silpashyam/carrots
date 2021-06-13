package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import utilities.ExcelHelper;
import utilities.Utility;

public class LoginExcel {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	ExcelHelper excelobj;

	String url="http://buffalocart.com/demo/erp/login";
	String browser="chrome";
	
	String expectederrormsg="username or password information doesn't exist!";
	
	String validusername;
	String validpassword;
	String invalidusername;
	String invalidpassword;
	
	//@Parameters({"urls","browser"})
	@BeforeClass
	public void beforeTest() throws IOException {

		utilobj=new Utility();
		driver=utilobj.LaunchBrowser(url, browser);
		loginobj=new LoginPage(driver);
		String sheetname="sheet1";
		
		ExcelHelper excelobj=new ExcelHelper();
		validusername= excelobj.readExcelFun(1,1,sheetname);
		validpassword=excelobj.readExcelFun(2,1,sheetname);
		invalidusername=excelobj.readExcelFun(3,1,sheetname);
		invalidpassword=excelobj.readExcelFun(4,1,sheetname);

	}

	/*
	 * @BeforeMethod() public void gotoLoginPage() throws InterruptedException {
	 * System.out.println("Before method");
	 * 
	 * driver.navigate().to(url); Thread.sleep(2000);
	 * //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 * 
	 * }
	 */


	@Test(priority=1)
	public void invalidUsernameValidPassword() throws InterruptedException {

		System.out.println("invalidUsernameValidPassword()");

		utilobj.textboxValueEnter(loginobj.username,invalidusername);
		utilobj.textboxValueEnter(loginobj.password,validpassword);
		utilobj.click(loginobj.signin);

		//String actualerrormsg=loginobj.invalidmessage.getText();

		//SoftAssert objassert=new SoftAssert();
		//objassert.assertEquals(actualerrormsg,expectederrormsg);
		//objassert.assertAll();


	}

	@Test(priority=2)
	public void validUsernameInvalidPassword() throws InterruptedException {

		System.out.println("validUsernameInValidPassword()");

		utilobj.textboxValueEnter(loginobj.username,validusername);
		utilobj.textboxValueEnter(loginobj.password,invalidpassword);
		utilobj.click(loginobj.signin);

		//String actualerrormsg=loginobj.invalidmessage.getText();

		//SoftAssert objassert=new SoftAssert();
		//objassert.assertEquals(actualerrormsg,expectederrormsg);
		//objassert.assertAll();

		
	}


	@Test(priority=3)
	public void invalidUsernameInvalidPassword() throws InterruptedException {

		System.out.println("invalidUsernameInValidPassword()");

		utilobj.textboxValueEnter(loginobj.username,invalidusername);
		utilobj.textboxValueEnter(loginobj.password,invalidpassword);
		utilobj.click(loginobj.signin);

		//String actualerrormsg=loginobj.invalidmessage.getText();

		//SoftAssert objassert=new SoftAssert();
		//objassert.assertEquals(actualerrormsg,expectederrormsg);
		//objassert.assertAll();
		
		//avoid 403 error
		Thread.sleep(2000);


	}

	@Test(priority=4) 
	public void validUsernameValidPassword() throws InterruptedException {

		System.out.println("validUsernameValidPassword()");	  

		//driver.navigate().to(url);
		
		utilobj.textboxValueEnter(loginobj.username,validusername);
		utilobj.textboxValueEnter(loginobj.password,validpassword);
		utilobj.click(loginobj.signin);
		
		
		
		String actualdashboardurl=driver.getCurrentUrl();
		String expecteddashboardurl="http://buffalocart.com/demo/erp/admin/dashboard";
		

		SoftAssert objassertlogin=new SoftAssert();
		objassertlogin.assertEquals(actualdashboardurl,expecteddashboardurl);
		objassertlogin.assertAll();
		
		//utilobj.click1(loginobj.demomenurighttop); 
		//utilobj.click1(loginobj.logout);
		
		//avoid 403 error
		Thread.sleep(2000);
		
		
		 String actualloginurl=driver.getCurrentUrl(); String
		 expectedloginurl="http://buffalocart.com/demo/erp/login";
		  
		 SoftAssert objassertlogout=new SoftAssert();
		 objassertlogout.assertEquals(actualloginurl,expectedloginurl);
		 objassertlogout.assertAll();
		 
		 
		
	}

	
	 
	

}