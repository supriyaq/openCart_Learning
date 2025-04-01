package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_Copy extends BasePage
{
	
	public HomePage_Copy(WebDriver copy) 
	{
		super(copy);
	}
	
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Link_MyAccount;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement Link_Register;
	
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement Link_Login;
	
	
	public void clickMyAccount()
	{
		Link_MyAccount.click();
	}
	
	
	public void clickRegister()
	{
		Link_Register.click();
	}
	
	
	
	public void clickLogin()
	{
		Link_Login.click();
	}
	

}
