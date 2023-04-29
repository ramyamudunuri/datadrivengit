package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
@FindBy(name = "txtUsername")
WebElement user;
@FindBy(name  ="txtPassword")
WebElement pass;
@FindBy(xpath = "//input[@id=\"btnLogin\"]")
WebElement logi;
public void login(String username,String password) {
	user.sendKeys(username);
	pass.sendKeys(password);
	logi.click();
	
}
}
