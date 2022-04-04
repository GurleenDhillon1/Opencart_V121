package testcases;



import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import testbase.TestBase;

public class TC_login extends TestBase
{
	
	@Test(groups= {"sanity","master"})
	public void test_login() throws IOException
	{
		try
		{
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
		logger.info("Home page displayed");
		
		Homepage hp=new Homepage(driver);
		hp.myaccount();
		logger.info("Clicked on my account");
		hp.login();
		logger.info("Clicked on login");
		
		Loginpage lp=new Loginpage(driver);
		lp.email(rb.getString("email"));
		logger.info("Provided email");
		lp.password(rb.getString("password"));
		logger.info("Provided password");
		lp.login();
		logger.info("Clicked on login button");
		boolean target=lp.checkMyAccount();
		if(target)
		{
			logger.info("Login successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Failed");
			capturescreenshot(driver,"test_login");
			Assert.assertTrue(false);
		}
		
		
	   }catch(Exception e)
		{
		    logger.fatal("Login failed");
		    capturescreenshot(driver,"test_login");
		    Assert.fail();
		}
	}

}
