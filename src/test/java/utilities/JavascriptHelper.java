package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
	WebDriver driver;
	
	 // This method will scroll till element 
	public void scrollToElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}	
	// Scroll till element and click
	public void scrollToElementAndClick(WebElement element,WebDriver driver){
		scrollToElement(element,driver);
		element.click();
	}
	
	// This method will scroll down vertically
	 
	public void scrollDownVertically(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	//This method will scroll up vertically	
	public void scrollUpVertically(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-(document.body.scrollHeight))");
	}	
	//This method will scroll till given pixel (e.g=1500)	 
	public void scrollDownByPixel(int pixel,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+pixel+")");
	}	
	public void scrollUpByPixel(int pixel,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-"+pixel+")");
	}
}
