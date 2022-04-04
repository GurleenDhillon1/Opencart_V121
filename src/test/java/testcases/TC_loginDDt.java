package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.MyAccountPage;
import testbase.TestBase;
import utilities.XLUtility;

public class TC_loginDDt extends TestBase
{
	@Test(dataProvider="loginData",groups= {"regession"})
	public void TC_001loginDDT(String user,String pwd,String exp)
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
		lp.email(user);
		logger.info("Provided email");
		lp.password(pwd);
		logger.info("Provided password");
		lp.login();
		logger.info("Clicked on login button");
		boolean target=lp.checkMyAccount();
		if(exp.equals("Valid"))
		{
			if(target==true)
			{
				logger.info("Login Success ");
				
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(target==true)
			{
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{		
				logger.error("Login Failed ");
				Assert.assertTrue(true);
			}
		}
		
		
	}catch(Exception e)
	{
		logger.fatal("Login Failed ");
		Assert.fail();
	}
	
	logger.info(" Finished TC_003_LoginDDT ");
	
}
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
     String path=".\\test data\\Opencart_LoginData.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
				
	}

		
	}


