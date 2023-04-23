package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
WebDriver driver;
	
	
	//================================Objects===================//
	@FindBy(name="user-name")
	WebElement Username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(className="rememberMe")
	WebElement rem;
	@FindBy(name="login-button")
	WebElement Loginbtn;
	
	//================================methods========================//
	
	//constructor to base class driver
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		//init for findby methos
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String Usernameval,String Passwordval) throws InterruptedException
	{
		//WebElement loginlink = driver.findElement(By.linkText("Log in"));
		Username.sendKeys(Usernameval);
		password.sendKeys(Passwordval);
		Thread.sleep(5000);
		Loginbtn.click();
		Thread.sleep(3000);
		
	}


}
