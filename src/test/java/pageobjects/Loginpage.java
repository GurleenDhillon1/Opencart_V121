package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
     @FindBy(xpath="//input[@id='input-email']")
     WebElement txt_email;
     
     @FindBy(xpath="//input[@id='input-password']")
     WebElement txt_password;
     
     @FindBy(xpath="//input[@value='Login']")
     WebElement btn_login;
     
     @FindBy(xpath="//h2[normalize-space()='My Account']")
     WebElement chk_myaccount;


   public void email(String Email)
   {
	   txt_email.sendKeys(Email);
   }
   public void password(String pwd)
   {
	   txt_password.sendKeys(pwd);
   }
   public void login()
   {
	   btn_login.click();
   }
   public boolean checkMyAccount()
   {
	   try
	   {
		   return chk_myaccount.isDisplayed();
	   }catch(Exception e)
	   {
		   return false;
	   }
	  
  }
   
}