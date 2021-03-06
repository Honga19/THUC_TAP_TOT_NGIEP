package LoginOps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class functions {
	WebDriver drv;
	public functions (WebDriver drv) {
		this.drv = drv;
	}
	public void login(String uName, String pass) {
		drv.findElement(By.id("username")).sendKeys(uName);
		drv.findElement(By.id("password")).sendKeys(pass);
		drv.findElement(By.xpath("//*[@id=\"body_section\"]/div/form/div[5]/input")).click();
		String url = "https://10.30.8.82/VoicePortal/faces/main.jsf";
		String urlGet = drv.getCurrentUrl();
		Assert.assertEquals(urlGet, url);
		System.out.print("Login successful!\n");
	}
	public void lgOps() {
		drv.switchTo().defaultContent();
		drv.switchTo().frame("menu"); 
		drv.findElement(By.xpath("//*[@id=\"menuForm:menuTable:0:menuItemTable:2:menuItem_panelGroup\"]/a/span")).click();
		drv.switchTo().defaultContent();
		drv.switchTo().frame("main");
		String a = drv.findElement(By.className("heading1plain")).getText();
		Assert.assertEquals(a, "Login Options");
		System.out.print("Click successful\n");
	}
	public void value(String id, String value) {
		drv.switchTo().defaultContent();
		drv.switchTo().frame("main");
		WebElement a = drv.findElement(By.id(id));
		a.clear();
		a.sendKeys(value);
		System.out.print(value +": ");
	}
	public void failCheck(String eXpath,String failV) {
		drv.findElement(By.id("userSettings:save1")).click();
		String failGet = drv.findElement(By.xpath(eXpath)).getText();
		Assert.assertEquals(failGet, failV);
		System.out.print(failGet + "\n");
	}
	public void passCheck(String pass) {
		drv.findElement(By.id("userSettings:save1")).click();
		String passGet = drv.findElement(By.className("info")).getText();
		Assert.assertEquals(passGet, pass);
		System.out.print(passGet + "\n");
	} 
}
