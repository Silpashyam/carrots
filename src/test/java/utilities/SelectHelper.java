package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper {
	WebDriver driver;
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
