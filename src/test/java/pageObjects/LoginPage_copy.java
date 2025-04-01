package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_copy extends BasePage

{

	public LoginPage_copy(WebDriver copy)
	{
		super(copy);
		
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement textBox_Email;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement textBox_Password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement button_Login;
	
	
	
	
	
	public void setEmail(String email_)
	{
		textBox_Email.sendKeys(email_);
	}
	
	public void setPassword(String password_)
	{
		textBox_Password.sendKeys(password_);
	}
	
	
	public void click_Login_Button()
	{
		button_Login.click();
	}

}
