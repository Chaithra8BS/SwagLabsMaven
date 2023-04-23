package testcase;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import testcase.Baseclass;
import pages.LoginPage;

public class Logintest extends Baseclass{
	
	@Test
	public void validlogin() throws FilloException, InterruptedException
	{
		Recordset recordset = connection.executeQuery("select * from data where TestName='validlogin'");
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);	
		
		String ActPageURL = driver.getCurrentUrl();
		String ExpPageURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(ActPageURL, ExpPageURL);
		
	}
	
	@Test
	public void Invalidlogin() throws FilloException, InterruptedException
	{
		Recordset recordset = connection.executeQuery("select * from data where TestName='Invalidlogin'");
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
		
		String ActError = error.getText();
		String ExpError = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ActError, ExpError);
		
	}

}
