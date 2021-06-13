package testCase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.ProjectsPage;
import pageObjects.TasksPage;
import utilities.ActionsHelper;
import utilities.AlertHelper;
import utilities.SelectHelper;
import utilities.Utility;
import utilities.WaitHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TasksTest {
	WebDriver driver;
	Utility utilobj;
	LoginPage loginobj;
	TasksPage tasksobj;
	SelectHelper selectobj;
	ActionsHelper actionsobj;
	AlertHelper alertobj;
	WaitHelper waitobj;
	String Taskname = "Sampletasks1";
	public String TaskName() {
		return Taskname;
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		utilobj = new Utility();
		driver = utilobj.LaunchBrowser("chrome", "http://buffalocart.com/demo/erp/login");
	}
	@Test
	public void CorrectUnameCorrectPwd() throws InterruptedException {
		Thread.sleep(3000);
		loginobj = new LoginPage(driver);
		utilobj.textboxValueEnter(loginobj.username, "admin");
		utilobj.textboxValueEnter(loginobj.password, "123456");
		utilobj.click(loginobj.signin);
		Thread.sleep(5000);
		if (driver.getTitle().equals("Codecarrots")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 1,enabled=true) // TESTCASE NUMBER = 13
	public void tasksmenucheck() {
		tasksobj = new TasksPage(driver);
		WebElement element = waitobj.explicitwaitforelementpresent(driver, tasksobj.Tasksmenu, 30);
		utilobj.click(element);
		String titlefromsite = utilobj.getText(tasksobj.Taskspagetitle);
		String title = "Tasks";
		Assert.assertEquals(title, titlefromsite, "Tasks page opened is correct");
	}
  @Test(priority=2,enabled=true) // TESTCASE NUMBER = 14
  public void addTask() {
	  tasksobj = new TasksPage(driver);
	  selectobj = new SelectHelper();
	  actionsobj = new ActionsHelper();
	  utilobj.click(tasksobj.NewTask); 
	  utilobj.textboxValueEnter(tasksobj.Taskname,Taskname);
	  selectobj.selectByVisibleText(tasksobj.RelatedTo,"Projects");
	  ProjectsTest projectstestobj = new ProjectsTest();
	  String projectname=projectstestobj.ProjectName();
	  if((tasksobj.SelectProject).isDisplayed())
	  {
		  selectobj.selectByVisibleText(tasksobj.SelectProject, projectname);
	  }
	  utilobj.textboxValueIntEnter(tasksobj.StartDate,2021-06-14);
	  utilobj.textboxValueIntEnter(tasksobj.DueDate,2021-12-24);
	  utilobj.textboxValueIntEnter(tasksobj.HourlyRate, 40);
	  utilobj.textboxValueIntEnter(tasksobj.EstimatedHours, 80);
	  actionsobj.dragAndDrop(driver, tasksobj.Slider, 200, 0);
	  selectobj.selectByVisibleText(tasksobj.Status,"In Progress");
	  utilobj.textboxValueEnter(tasksobj.Description, "Tasks Description");
	  utilobj.click(tasksobj.Billable);
	  if ((tasksobj.AssignedToEveryone).isSelected()) {
			utilobj.click(tasksobj.AssignedToEveryone);
		} else {
			utilobj.click(tasksobj.AssignedToCutomize);
		}
		if ((tasksobj.SelectUsers).isDisplayed()) {
			utilobj.click(tasksobj.SelectUsers);
		}
		utilobj.click(tasksobj.save);
	    String tasknamefromsite = utilobj.getText(tasksobj.tasknamefromsite);
		Assert.assertEquals(Taskname, tasknamefromsite, "Task created successfully");		
  }
  @Test(priority=3, enabled=true)   // TESTCASE NUMBER = 15
  public void verifyTask() 
  {
	  utilobj.click(tasksobj.taskheading);
	  int firstpage = 1;
	  do
	  {
		  if(firstpage==0)
		  {
			  utilobj.click(tasksobj.pagination);
		  }
		  else
		  {
			  firstpage=0;
		  }
		  boolean verifytask = driver.getPageSource().contains(Taskname);
		  if(verifytask)
		  {
			  Assert.assertTrue(verifytask);
			  break;
		  }	  
	  } 
	  while(tasksobj.pagination.isDisplayed());
  }
 
  @Test(priority=4, enabled=true)   // TESTCASE NUMBER = 16
  public void statusChange() 
  {
	  utilobj.click(tasksobj.taskheading);
	  utilobj.click(tasksobj.statuschange);
	  utilobj.click(tasksobj.statuschangedropdown);
	  boolean verifystatus = driver.getPageSource().contains("Change Status");
	  Assert.assertTrue(verifystatus);
  }
  @Test(priority=5, enabled=true) // TESTCASE NUMBER = 17
  public void delete() 
  {
	  alertobj = new AlertHelper();
	  WebElement element = waitobj.explicitwaitforelementpresent(driver, tasksobj.delete, 30);
	  utilobj.click(element);
	  alertobj.alertAccept();
	  boolean verifydelete = driver.getPageSource().contains("Task deleted sucessfully");
	  Assert.assertTrue(verifydelete);
  }
  
 @Test(priority=6,enabled=false) // TESTCASE NUMBER = 18
 public void fileDownload() 
 {
	 
	 utilobj.click(tasksobj.importtask);
	 WebElement element = waitobj.explicitwaitforelementpresent(driver, tasksobj.downloadsample, 30);
	 utilobj.click(element);
	 String samplename= "tasks_sample.xlsx";
	 File fileLocation = new File("C:\\Users\\User\\Downloads");
	 File[] totalfiles = fileLocation.listFiles();
	 boolean filefound = false;
	 for(File file : totalfiles)
	 {
		 if(file.getName().equals(samplename))
		 {
			 System.out.println(file.getName() +"File is downloaded");
			 filefound=true;
			 break;
		 }
	 }
	 if(filefound==false)
		 System.out.println("File not found");
	 
 }
 @Test(priority=7,enabled=false) // TESTCASE NUMBER = 19
 public void fileUpload() 
 {
	 utilobj.click(tasksobj.importtask);
	 String filepath= "C:\\Users\\User\\Downloads\\tasks_sample.xlsx";
	 utilobj.textboxValueEnter(tasksobj.choosefile, filepath);
	 selectobj.selectByVisibleText(tasksobj.Status,"In Progress");
	 if ((tasksobj.AssignedToEveryone).isSelected()) {
			utilobj.click(tasksobj.AssignedToEveryone);
		} else {
			utilobj.click(tasksobj.AssignedToCutomize);
		}
		if ((tasksobj.SelectUsers).isDisplayed()) {
			utilobj.click(tasksobj.SelectUsers);
		}
		utilobj.click(tasksobj.upload);
		boolean verifyupload = driver.getPageSource().contains("This is Tasks Name");
		Assert.assertTrue(verifyupload);
	 
 }
 }
