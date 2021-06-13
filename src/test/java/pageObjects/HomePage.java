package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='user-block']/div/div[1]/div/img")
	public WebElement logo;

	@FindBy(xpath = "/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/a/span")
	public WebElement accountname;


}
