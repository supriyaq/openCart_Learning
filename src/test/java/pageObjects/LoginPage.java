package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage

{
	public LoginPage(WebDriver loginpage)
	{
		super(loginpage);
	}
	
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement TextFieldEmail;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement TextFieldPassword;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement ButtonLogin;
	
	
	
	public void setEmail(String email)
	{
		TextFieldEmail.sendKeys(email);
	}
	
	
	

	public void setPassword(String pass)
	{
		TextFieldPassword.sendKeys(pass);
	}

	
	public void clickLoginButton()
	{
		ButtonLogin.click();
	}
}
