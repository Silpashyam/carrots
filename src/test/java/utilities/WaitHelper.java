package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	WebDriver driver;

	
	public void WaitForElementClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public boolean waitForElementNotPresent(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		return status;
	}
	public static WebElement explicitwaitforelementpresent(WebDriver driver, WebElement element, int timeout)
	{
		WebDriverWait mywait = new WebDriverWait(driver,timeout);
		mywait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

}
