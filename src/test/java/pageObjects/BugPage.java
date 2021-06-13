package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BugPage {
	WebDriver driver;

	public BugPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Bugs")
	public WebElement Bugsmenu;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement Bugpagetitle;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[3]/div/div[2]/ul/li[2]/a")
	public WebElement NewBug;
	@FindBy(name = "issue_no")
	public WebElement IssueNumber;
	@FindBy(name = "bug_title")
	public WebElement Bugtitle;
	@FindBy(name = "related_to")
	public WebElement RelatedTo;
	@FindBy(xpath = "//*[@id='related_to']/div/div/div/ul/li")
	public WebElement SelectProject;
	@FindBy(name = "reporter")
	public WebElement Reporter;
	@FindBy(name = "priority")
	public WebElement Priority;
	@FindBy(name = "severity")
	public WebElement Severity;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[8]/div/div/div[6]")
	public WebElement Description;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[9]/div/div/div[6]")
	public WebElement Reproducibility;
	@FindBy(name = "bug_status")
	public WebElement Bugstatus;
	@FindBy(xpath = "//*[@id='border-none']/div/div[1]/label/span")
	public WebElement AssignedToEveryone;
	@FindBy(xpath = "//*[@id='border-none']/div/div[2]/label/input")
	public WebElement AssignedToCutomize;
	@FindBy(xpath = "//*[@id='permission_user_1']/div/div[1]/label/span")
	public WebElement SelectUsers;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[13]/button")
	public WebElement save;
	@FindBy(xpath = "//*[@id='DataTables_next']/a")
	public WebElement pagination;
	@FindBy(xpath = "//*[@id='task_details']/div/div[2]/div[2]/div/p")
	public WebElement bugname;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement bugheading;
}
