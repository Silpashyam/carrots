package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	WebDriver driver;

	public WebDriver LaunchBrowser(String browsers, String url) {


		System.out.println(browsers);
		switch (browsers) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url); // IMPLICIT WAIT
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "//Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("choose a browser");
		}
		return driver;

	}
	public void textboxValueEnter(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public void textboxValueIntEnter(WebElement element,int text)
	{
		element.sendKeys(String.valueOf(text));
	}
	public void click(WebElement element)
	{
		element.click();
	}
	public String getText(WebElement element)
	{
		String text =element.getText();
		return text;
	}
	public void selectByValue(WebElement element,String text)
	{
		Select obj = new Select(element);
		obj.selectByValue(text);
	}
	public void selectByIndex(WebElement element,int text)
	{
		Select obj = new Select(element);
		obj.selectByIndex(text);
	}	
	public void selectByVisibleText(WebElement element,String text)
	{
		Select obj = new Select(element);
		obj.selectByVisibleText(text);
	}
}
