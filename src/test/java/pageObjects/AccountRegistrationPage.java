package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage


{

	public AccountRegistrationPage(WebDriver accountRegistration) {
		super(accountRegistration);


	}
		
		@FindBy(xpath="//input[@id='input-firstname']")
		WebElement textFieldFirstName;
		
		
		

		@FindBy(xpath="//input[@id='input-lastname']")
		WebElement textFieldLastName;
		
		
		

		@FindBy(xpath="//input[@id='input-email']")
		WebElement  textFieldemail;
		
		

		@FindBy(xpath="//input[@id='input-telephone']")
		WebElement textFieldNumber;
		
		

		@FindBy(xpath="//input[@id='input-password']")
		WebElement textFieldPassword;
		
		

		@FindBy(xpath="//input[@id='input-confirm']")
		WebElement textFieldConfirmPassword;
		
		

		@FindBy(xpath="//label[normalize-space()='Yes']")
		WebElement  RadioButtonYes;
		
		

		@FindBy(xpath="//input[@value='0']")
		WebElement  RadioButtonNo;
		
		

		@FindBy(xpath="//input[@name='agree']")
		WebElement checkBox;
		
		

		@FindBy(xpath="//input[@value='Continue']")
		WebElement  ContinueButton;
		
		

		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement  sucessfulMessage;
		
		
		//action//
		
		public void setFirstName(String fname)
		{
			textFieldFirstName.sendKeys(fname);
		}
		
		
		
		public void setLastName(String lname)
		{
			textFieldLastName.sendKeys(lname);
		}
		
		
		
		public void setEmail(String email)
		{
			textFieldemail.sendKeys(email);
		}
		
		
		public void setNumber(String number)
		{
			textFieldNumber.sendKeys(number);
		}
		
		public void setPassword(String pass)
		{
			textFieldPassword.sendKeys(pass);
		}
		
		
		public void setConfirmPassword(String pass)
		{
			textFieldConfirmPassword.sendKeys(pass);
		}
		
		
		public void clickYes()
		{
			RadioButtonYes.click();
		}
		
		
		public void clickTermsandConditions()
		{
			checkBox.click();
		}
		
		
		public void clickContinueButton()
		{
			ContinueButton.click();
		}
		
		
		
		
		public String getMessage()
		{
			try
			{
				return(sucessfulMessage.getText());
			}
			
			catch (Exception e)
			{
				return (e.getMessage());
			}
		}
		
		
	
	
	

}
