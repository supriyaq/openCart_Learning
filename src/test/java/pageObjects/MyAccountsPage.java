package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends BasePage
{

	public MyAccountsPage(WebDriver accountpage) 
	
	{
		super(accountpage);
		
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement HeadingMyAccount;
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LinkLogout;
	
	
	
	
	public boolean vaildateMyAccount()
	{
		try
		{
			boolean value=HeadingMyAccount.isDisplayed();
			return value;
			
		}
		catch(Exception e)
		{
			return (false);
		}
		
	}
	
	
	public void clickLogout()
	{
		LinkLogout.click();
	}

}
