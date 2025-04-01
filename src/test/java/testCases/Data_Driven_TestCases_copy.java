package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage_Copy;
import pageObjects.LoginPage_copy;
import pageObjects.MyAccountsPage_copy;
import testBase.BaseClass;
import utilities.DataProviders;

public class Data_Driven_TestCases_copy extends BaseClass 

{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="DataDriven")
	public void verify_Data_Driven_Testing(String email_,String pass_,String expected_)
	{
		
		try
		{

			HomePage_Copy h1=new HomePage_Copy(w1);
			LoginPage_copy l1=new LoginPage_copy(w1);
			MyAccountsPage_copy a1=new MyAccountsPage_copy(w1);
			
			
			h1.clickMyAccount();
			h1.clickLogin();
			
			
			
			l1.setEmail(email_);
			l1.setPassword(pass_);
			l1.click_Login_Button();
			
			
			
		boolean s1=a1.headingExists();
		
		
		if(expected_.equalsIgnoreCase("Valid"))
		{
			
			if(s1==true)
			{
				System.out.println("Since the data is valid so logged in @@@ PASSed @@@");
				a1.clickLogOut();
				Assert.assertTrue(true);
			}
			
			
			else
			{
				System.out.println(" Since data is valid but didnot Logged In ...failed....");
				Assert.assertTrue(false);
			}
			
		}
		
		
		
		
		
		if(expected_.equalsIgnoreCase("Invalid"))
		{
			
			if(s1==true)
			{
				System.out.println("Since the data is Invalid so logged in ...Failed....");
				a1.clickLogOut();
				Assert.assertTrue(false);
				
			}
			
			else
			{
				System.out.println(" Since data is Invalid so didnot Logged In @@@ Paased @@@");
				Assert.assertTrue(true);
				
			}
			
			
			
			
			
		}
			
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}

	
		
	}
	

}
