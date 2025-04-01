package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegitrationTest extends BaseClass

{
	@Test(groups={"Regression","Master"})
	public void verifyRegistration() throws InterruptedException
	
	{
		
		logger.info(" **** Starting the Test Case: TC_001_AccountRegitrationTest ***** ");
		
		try
		{

			HomePage hp=new HomePage(w1);
			AccountRegistrationPage reg=new AccountRegistrationPage(w1);
			
			
			hp.clickMyAccount();
			logger.info(" clicked on My Account Link... ");
			hp.clickRegister();
			logger.info(" clicked on Register Link... ");
			
			Thread.sleep(3000);
			
			
			logger.info(" Providing customer Details... ");
			
			
			reg.setFirstName(randomString().toUpperCase());
			logger.info("Entered first Name");
			reg.setLastName(randomString().toUpperCase());
			logger.info("Entered last Name");
			reg.setEmail(randomString()+"@gmail.com");
			logger.info("Entered email Address");
			reg.setNumber(randomNumber());
			logger.info("Entered mobile Number ");
			
			
			
			String pass_=alphaNumeric();
			
			reg.setPassword(pass_);
			logger.info("Entered password");
			
			reg.setConfirmPassword(pass_);
			logger.info("Entered confirm password");
			
			reg.clickYes();
			logger.info("Clicked on subcribe Yes button");
			
			
			reg.clickTermsandConditions();
			logger.info("Clicked on the terms and condition check box");
			
			reg.clickContinueButton();
			logger.info("Clicked on continue Button..");
			
			logger.info(" Validating the expected message... ");
			String s1=reg.getMessage();
			
			String s2="Your Account Has Been Created!";
			
			if(s1.equals(s2))
			{
				Assert.assertTrue(true);
			}
			
			else
			{

				logger.error(" Test failed !!!");
				logger.debug("Debug Logs !!!");
				Assert.assertTrue(false);
				
			}
			
//			Assert.assertEquals(s1, s2);
			
			
		
			
			
		}
		catch(Exception e)
		{
			
			Assert.fail();
			
		}
		
		logger.info(" !!! FINISHED .... Test Case Completed !!! ");
		
		
	}
	
	
	
	
	
	
	

}
