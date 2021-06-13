package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {
	WebDriver driver;

	public LeavePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Leave Management")
	public WebElement Leavemenu;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement Leavepagetitle;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div/div/ul/li[5]/a")
	public WebElement applyleave;
	@FindBy(name = "user_id")
	public WebElement selectusers;
	@FindBy(name = "leave_category_id")
	public WebElement leavecategory;
	@FindBy(xpath = "//*[@id=\"myModal_extra_lg\"]/div/div/div[1]/div[2]/div/div[1]/form/div/div[3]/div/label[3]/span")
	public WebElement duration;
	@FindBy(name = "hours_start_date")
	public WebElement startdate;
	@FindBy(name = "hours")
	public WebElement hours;
	@FindBy(name = "reason")
	public WebElement reason;
	@FindBy(id = "file-save-button")
	public WebElement submit;
}
