package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{


@Test (groups={"Sanity","Master"})
public void verifyLogin() throws InterruptedException
{
	logger.info("Test case TC002_Login Test Started ....");
	
	
	try
	{
		

		HomePage hp=new HomePage(w1);
		
		LoginPage lp=new LoginPage(w1);
		
		MyAccountsPage map=new MyAccountsPage(w1);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		Thread.sleep(3000);
		
		lp.setEmail(class1.getProperty("email"));
		lp.setPassword(class1.getProperty("password"));
		lp.clickLoginButton();
		
		
		Thread.sleep(3000);
		
		boolean value1=map.vaildateMyAccount();
		
		Assert.assertTrue(value1);
		
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info(" Test case 2 passed...");

}




}
