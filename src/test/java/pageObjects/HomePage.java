package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage

{
	
	
	//constructor//
	public HomePage(WebDriver homepage)
	{
		super(homepage);
	}
	
	
	
	//locator
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	//action methods//
	
	public void clickMyAccount()
	{
		linkMyAccount.click();
	}
	
	public void clickRegister()
	{
		linkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}

}
