package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 

{
	
	WebDriver driver;
	
	public BasePage(WebDriver basepage)
	{
		driver=basepage;
		PageFactory.initElements(driver, this);
	}

}
