package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class Functionalibrary extends AppUtil {
	public static  boolean login_verify(String user,String pass )
	{
		driver.get(conpro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conpro.getProperty("objusername"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("objpassword"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
		String expected="dashboard";
		String acctual=driver.getCurrentUrl();
		if (acctual.contains(expected)) {
			Reporter.log("login succes",true);
			return true;
			
		}
		else {
			String eror_message=driver.findElement(By.xpath(conpro.getProperty("objerror"))).getText();
			Reporter.log(eror_message);
			return false;
			
		}
		
		
	}

}
