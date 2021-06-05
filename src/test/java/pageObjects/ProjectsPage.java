package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {
WebDriver driver;
	
	public ProjectsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Projects")
	public WebElement Projectsmenu;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement Projectspagetitle;
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div[3]/div/div[2]/ul/li[2]/a")
	public WebElement NewProject;	
	@FindBy(name = "project_no")
	public WebElement ProjectNo;
	@FindBy(name = "project_name")
	public WebElement ProjectName;
	@FindBy(name = "client_id")
	public WebElement SelectClient;
	@FindBy(xpath = "//*[@id=\"create\"]/form/div/div[1]/div[4]/div/div[1]/span")
	public WebElement Slider;
	@FindBy(name = "start_date")
	public WebElement StartDate;
	@FindBy(xpath = "/html/body/div[8]/div[1]/table/thead/tr[1]/th[2]")
	public WebElement StartDatemonthyear; 
	@FindBy(xpath = "/html/body/div[8]/div[1]/table/thead/tr[1]/th[1]")
	public WebElement StartDateprevious;		
	@FindBy(xpath = "/html/body/div[8]/div[1]/table/tbody/tr/td[contains(text(),10]")
	public WebElement StartDatedate;
	@FindBy(name = "end_date")
	public WebElement EndDate;
	@FindBy(name = "billing_type")
	public WebElement BillingType;
	@FindBy(name = "project_cost")
	public WebElement FixedPrice;
	@FindBy(name = "estimate_hours")
	public WebElement EstimatedHours;
	@FindBy(name = "project_status")
	public WebElement Status;
	@FindBy(name = "demo_url")
	public WebElement DemoUrl;
	@FindBy(xpath = "//*[@id='border-none']/div/div[1]/label/input")
	public WebElement AssignedToEveryone;
	@FindBy(xpath = "//*[@id='border-none']/div/div[2]/label/input")
	public WebElement AssignedToCutomize; 
	@FindBy(xpath = "//*[@id='permission_user_1']/div/div[1]/label/span")
	public WebElement SelectUsers; 
	@FindBy(xpath = "//*[@id='create']/form/div/div[3]/div[1]/div/div/div[6]")
	public WebElement Description; 
	@FindBy(xpath = "//*[@id='create']/form/div/div[3]/div[2]/button")
	public WebElement save; 
	@FindBy(xpath = "//*[@id='task_details']/div/div[2]/div[2]/div/p")
	public WebElement projectnameaftersave;
}
