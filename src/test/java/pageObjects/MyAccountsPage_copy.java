package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage_copy  extends BasePage

{
	public MyAccountsPage_copy(WebDriver copy)
	{
		super(copy);
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement heading;
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Link_LogOut;
	
	
	
	public boolean headingExists()
	{
		try
		{
			boolean value1=heading.isDisplayed();
			return value1;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	public void clickLogOut()
	{
		Link_LogOut.click();
		
	}
	

}
