package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import pageobjects.Registrationaccountpage;
import testbase.TestBase;

public class TC_001Accountregistration extends TestBase
{
	
	@Test(groups= {"master"})
	public void test_registration() throws IOException
	{
		try
		{
		logger.info("Started TC_001Accountregistration");
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
		logger.info("Home page ");
		Homepage hp=new Homepage(driver);
		hp.myaccount();
		logger.info("Clicked on Myaccount");
		hp.register();
		logger.info("Clicked on Register");
		Registrationaccountpage rp=new Registrationaccountpage(driver);
		rp.Fname("john");
		logger.info("Provided First name");
		rp.Lname("dev");
		logger.info("Provided Last name");
		rp.Email(randomestring()+"@gamil.com");
		logger.info("Provided Email address");
		rp.Telphone("3344433334");
		logger.info("Provided Telephone");
		rp.Password("12345");
		logger.info("Provided password");
		rp.CPassword("12345");
		logger.info("Provided confirm password");
		rp.policy();
		logger.info("Clicked on policy");
		rp.btn();
		logger.info("Clicked on Button");
		String confirm=rp.getconfirmation();
		if(confirm.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Account Registration Failed");
			capturescreenshot(driver,"test_registration");
			Assert.assertTrue(false);
		}	
		} catch(Exception e)
		{
			logger.fatal("Account Registration Failed");
			capturescreenshot(driver,"test_registration");
			Assert.fail();
		}
		logger.info("Finished TC_001Accountregistration");
		
	}	
}
