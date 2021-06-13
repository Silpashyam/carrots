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
	@FindBy(xpath = "//*[@id='16']/div/header/h3")
	public WebElement IncomevsExpense;
	@FindBy(xpath = "/html/body/div[1]/footer/strong/a")
	public WebElement footer;
	@FindBy(xpath = "/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/a/span")
	public WebElement accountname;
	@FindBy(linkText = "Private Chat")
	public WebElement PrivateChatmenu;
}
