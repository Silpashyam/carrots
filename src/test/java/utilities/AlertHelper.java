package utilities;

import org.openqa.selenium.WebDriver;

public class AlertHelper {
	WebDriver driver;
	public void alertAccept()
	{
		org.openqa.selenium.Alert obj1 = driver.switchTo().alert();
		obj1.accept();
	}
	public void alertDismiss()
	{
		org.openqa.selenium.Alert obj2 = driver.switchTo().alert();
		obj2.dismiss();
		
	}
	public void alertMessageAccept(String name)
	{
		org.openqa.selenium.Alert obj3 = driver.switchTo().alert();
		obj3.sendKeys(name);
		obj3.accept();
	}

}
