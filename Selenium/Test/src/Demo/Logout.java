package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
	WebDriver drv;
	public Logout (WebDriver drv) {
		this.drv = drv;
	}
	public void logout() {
 		drv.switchTo().frame("header");
	 	WebElement logoutBtn = drv.findElement(By.id("topMenuForm:logoff"));
		if (logoutBtn.isDisplayed()) {
			logoutBtn.click();
			}
		}
}
