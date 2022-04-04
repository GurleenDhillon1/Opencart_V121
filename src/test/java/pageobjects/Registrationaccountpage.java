package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrationaccountpage 
{
	WebDriver driver;
	  
	 public Registrationaccountpage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
     }
	 
	   @FindBy(name="firstname")
		WebElement txtFirstName;
		
		@FindBy(name="lastname")
		WebElement txtLastName;
		
		@FindBy(name="email")
		WebElement txtEmail;
		
		@FindBy(name="telephone")
		WebElement txtTelephone;
		
		@FindBy(name="password")
		WebElement txtPassword;
		
		@FindBy(name="confirm")
		WebElement txtConfirmPassword;
		
		@FindBy(name="agree")
		WebElement chkdPolicy;
		
		@FindBy(xpath="//input[@value='Continue']")
		WebElement btnContinue;
		
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
		
		public void Fname(String fname)
		{
			txtFirstName.sendKeys(fname);
		}
		public void Lname(String lname)
		{
			txtLastName.sendKeys(lname);
		}
		public void Email(String email)
		{
			txtEmail.sendKeys(email);
		}
		public void Telphone(String Phone)
		{
			txtTelephone.sendKeys(Phone);
		}
		public void Password(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		public void CPassword(String cpwd)
		{
			txtConfirmPassword.sendKeys(cpwd);
		}
		public void policy()
		{
			chkdPolicy.click();;
		}
		public void btn()
		{
			btnContinue.click();
		}
		public String getconfirmation()
		{
			try
			{
				return (msgConfirmation.getText());
			}catch(Exception e)
			{
				return(e.getMessage());
			}
	}	

}
