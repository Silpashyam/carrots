package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TasksPage {
	WebDriver driver;

	public TasksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Tasks")
	public WebElement Tasksmenu;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement Taskspagetitle;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[4]/div/div[2]/ul/li[2]/a")
	public WebElement NewTask;
	@FindBy(name = "task_name")
	public WebElement Taskname;
	@FindBy(name = "related_to")
	public WebElement RelatedTo;
	@FindBy(name = "project_id")
	public WebElement SelectProject;
	@FindBy(name = "task_start_date")
	public WebElement StartDate;
	@FindBy(name = "due_date")
	public WebElement DueDate;
	@FindBy(name = "hourly_rate")
	public WebElement HourlyRate;
	@FindBy(name = "task_hour")
	public WebElement EstimatedHours;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[9]/div/div[1]/span")
	public WebElement Slider;
	@FindBy(name = "task_status")
	public WebElement Status;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[11]/div/div/div[6]")
	public WebElement Description;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[12]/div/div/div/span")
	public WebElement Billable;
	@FindBy(xpath = "//*[@id='border-none']/div/div[1]/label/span")
	public WebElement AssignedToEveryone;
	@FindBy(xpath = "//*[@id='border-none']/div/div[2]/label/input")
	public WebElement AssignedToCutomize;
	@FindBy(xpath = "//*[@id='permission_user_1']/div/div[1]/label/span")
	public WebElement SelectUsers;
	@FindBy(xpath = "//*[@id='assign_task']/div/div/form/div[15]/button")
	public WebElement save;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement taskheading;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[4]/div/div[2]/ul/li[3]/a")
	public WebElement importtask;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div/header/div/div/div/a/i")
	public WebElement downloadsample;
	@FindBy(name = "upload_file")
	public WebElement choosefile;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div/div/form/div/div[5]/div/button")
	public WebElement upload;
	@FindBy(xpath = "//*[@id='table_2']/td[6]/strong/i")
	public WebElement delete;
	@FindBy(xpath = "//*[@id='DataTables']//a[contains(text(),Sampletasks1)]/parent::*/following-sibling::td[2]/div/button")
	public WebElement statuschange;
	@FindBy(xpath = "//*[@id='DataTables']//a[contains(text(),Sampletasks1)]/parent::*/following-sibling::td[2]/div/ul/li[2]")
	public WebElement statuschangedropdown;
	@FindBy(xpath = "//*[@id='DataTables']//a[contains(text(),Sampletasks1)]/parent::*/following-sibling::td[2]/span")
	public WebElement currentstatus;
	@FindBy(xpath = "//*[@id='DataTables']//a[contains(text(),Sampletasks1)]/parent::*/following-sibling::td[3]/span/a/i")
	public WebElement assignedtochange;
	@FindBy(xpath = "//*[@id='DataTables_next']/a")
	public WebElement pagination;
	@FindBy(xpath = "//*[@id='form_validation']/div/div[1]/label/span")
	public WebElement AssignedToEveryoneform;
	@FindBy(xpath = "//*[@id='form_validation']/div/div[2]/label/input")
	public WebElement AssignedToCutomizeform; 
	@FindBy(xpath = "//*[@id='table-tasks']/tbody/tr/td[2]/a")
	public WebElement tasknamefromsite;
}
