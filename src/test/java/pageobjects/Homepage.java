package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{  WebDriver driver;
  
 public Homepage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 
 }
 @FindBy(xpath="//span[text()='My Account']")
 WebElement lnk_Myaccount;
 
 @FindBy(xpath="//a[normalize-space()='Register']")
 WebElement lnk_register;
 
 @FindBy(xpath="//a[normalize-space()='Login']")
 WebElement lnk_login;
 
 public void myaccount()
 {
	 lnk_Myaccount.click();
 }
 public void register()
 {
	 lnk_register.click();
 }
 public void login()
 {
	 lnk_login.click();
 }
 


}
