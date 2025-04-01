package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTestCases extends BaseClass

{
	@Test(dataProvider="LoginData", dataProviderClass =DataProviders.class,groups="DataDriven")
	
	public void verify_DDT(String email,String password,String expectedValue) throws InterruptedException
	{
		logger.info(" Data Driven test case started ");

		try
		{

			HomePage hp=new HomePage(w1);
			
			LoginPage lp=new LoginPage(w1);
			
			MyAccountsPage map=new MyAccountsPage(w1);
			
			hp.clickMyAccount();
			hp.clickLogin();
			
			Thread.sleep(3000);
			
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLoginButton();
			
			
			Thread.sleep(3000);
			
			boolean value1=map.vaildateMyAccount();
			
			if(expectedValue.equalsIgnoreCase("Valid"))
			{
				System.out.println(" Validation for valid data==>");
				
				if(value1==true)
				{

					System.out.println(" the data is valid so the user logged In @@@ PAASED @@@  ");
					map.clickLogout();
					
					Assert.assertTrue(true);
					
				}
				
				else
				{
					System.out.println(" the data is !!!valid !!! but the user didnot logged In so FAILED ");
					Assert.assertTrue(false);
				}
				
				
				
			}
			
			if(expectedValue.equalsIgnoreCase("Invalid"))
			{
				System.out.println("validating for Invalid data==>");
				
				if(value1==true)
				{
					System.out.println(" the data is invalid but user logged in so !!! FAILED !!! ");
	                 map.clickLogout();
					
					Assert.assertTrue(false);
					
				}
				
				else
				{
					System.out.println("the data is invalid and the user didnot logged in so @@ PASSESd @@ ");
					Assert.assertTrue(true);
				}
			}
			
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Test completed");

		
	}
	

}
