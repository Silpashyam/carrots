package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/a/span")
	public WebElement demo;
	@FindBy(xpath = "/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/ul/li[3]/form/div/button")
	public WebElement logout;
}
