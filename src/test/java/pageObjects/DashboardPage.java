package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Dashboard")
	public WebElement Dashboardmenu;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement Dashboardpagetitle;

}
