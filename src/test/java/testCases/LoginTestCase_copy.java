package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage_Copy;
import pageObjects.LoginPage_copy;
import pageObjects.MyAccountsPage;
import pageObjects.MyAccountsPage_copy;
import testBase.BaseClass;

public class LoginTestCase_copy extends BaseClass

{
	
	@Test(groups={"Sanity","Master"})
	public void verifyLoginFunctionality()
	{
		
		
		logger.info(" **** Login Test case Started ****");
		
		
		try
		{ 

			HomePage_Copy h1=new HomePage_Copy(w1);
			LoginPage_copy l1=new LoginPage_copy(w1);
			MyAccountsPage_copy a1=new MyAccountsPage_copy(w1);
			
			
			h1.clickMyAccount();
			h1.clickLogin();
			
			
			
			l1.setEmail(class1.getProperty("email"));
			l1.setPassword(class1.getProperty("password"));
			l1.click_Login_Button();
			
			
			
		boolean s1=a1.headingExists();
		Assert.assertTrue(s1);
			
			
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info(" ........... test Case completed  ......");
	
		
		
		
	}

}
