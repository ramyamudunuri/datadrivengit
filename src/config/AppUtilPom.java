package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.Login;
import commonFunctions.Logout;

public class AppUtilPom {
	public static WebDriver driver;
	@BeforeTest
	public static void Adminlogin(){
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Login a=PageFactory.initElements(driver, Login.class);
		a.login("Admin", "Qedge123!@#");
		
		
	}
	@AfterTest
	public static void Adminlogout() {
		Logout g=PageFactory.initElements(driver,Logout.class);
		g.logout();
		driver.quit();
	}

}
