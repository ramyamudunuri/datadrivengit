package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {
@FindBy(id = "welcome")
WebElement wel;
@FindBy(xpath  ="//a[normalize-space()=\"Logout\"]")
WebElement logo;
public void logout() {
	wel.click();
	logo.click();
}
}
