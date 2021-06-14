package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

	String url = "http://buffalocart.com/demo/erp/login";
	String browser = "chrome";
	String expectederrormsg = "username or password information doesn't exist!";
	String validusername;
	String validpassword;
	String invalidusername;
	String invalidpassword;

	@BeforeClass
	public void beforeTest() throws IOException {

		utilobj = new Utility();
		driver = utilobj.LaunchBrowser(url, browser);
		loginobj = new LoginPage(driver);
		String sheetname = "sheet1";

		ExcelHelper excelobj = new ExcelHelper();
		validusername = excelobj.readExcelFun(1, 1, sheetname);
		validpassword = excelobj.readExcelFun(2, 1, sheetname);
		invalidusername = excelobj.readExcelFun(3, 1, sheetname);
		invalidpassword = excelobj.readExcelFun(4, 1, sheetname);

	}

	@Test(priority = 1)
	public void invalidUsernameValidPassword() {

		utilobj.textboxValueEnter(loginobj.username, invalidusername);
		utilobj.textboxValueEnter(loginobj.password, validpassword);
		utilobj.click(loginobj.signin);
		String actualerrormsg = utilobj.getText(loginobj.invalidmessage);
		Assert.assertEquals(actualerrormsg, expectederrormsg);
	}

	@Test(priority = 2)
	public void validUsernameInvalidPassword() {

		utilobj.textboxValueEnter(loginobj.username, validusername);
		utilobj.textboxValueEnter(loginobj.password, invalidpassword);
		utilobj.click(loginobj.signin);
		String actualerrormsg = utilobj.getText(loginobj.invalidmessage);
		Assert.assertEquals(actualerrormsg, expectederrormsg);
	}

	@Test(priority = 3)
	public void invalidUsernameInvalidPassword() {

		utilobj.textboxValueEnter(loginobj.username, invalidusername);
		utilobj.textboxValueEnter(loginobj.password, invalidpassword);
		utilobj.click(loginobj.signin);
		String actualerrormsg = utilobj.getText(loginobj.invalidmessage);
		Assert.assertEquals(actualerrormsg, expectederrormsg);
	}

	@Test(priority = 4)
	public void validUsernameValidPassword() {

		utilobj.textboxValueEnter(loginobj.username, validusername);
		utilobj.textboxValueEnter(loginobj.password, validpassword);
		utilobj.click(loginobj.signin);

		String Titlefromsite = utilobj.getTitle(driver);
		String title = "Codecarrots";
		Assert.assertEquals(title, Titlefromsite, "Loggined successfully");

	}

}