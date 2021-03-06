package LoginOps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sTimeOut extends setUp {
	functions loginf;
	
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
	public void timeOut (String time) {
		drv.switchTo().defaultContent();
		drv.switchTo().frame("main");
		WebElement a = drv.findElement(By.id("userSettings:sessionTimeout"));
		a.clear();
		a.sendKeys(time);
		System.out.print(time +": ");
	}
	public void failCheck(String fail) {
		drv.findElement(By.id("userSettings:save1")).click();
		String failGet = drv.findElement(By.xpath("//*[@id=\"userSettings:loginOpts1\"]/tbody/tr[2]/td[2]/span")).getText();
		Assert.assertEquals(failGet, fail);
		System.out.print(failGet);
	}
	public void passCheck(String pass) {
		drv.findElement(By.id("userSettings:save1")).click();
		String passGet = drv.findElement(By.className("info")).getText();
		Assert.assertEquals(passGet, pass);
		System.out.print(passGet);
	} 
	@Test
	public void FailValue() {
		loginf = new functions(drv);
		loginf.login("hnga\n", "hihihaha123");
		lgOps();
		timeOut("");
		failCheck("Please fill in this field.");
	}
	@Test
	public void FailValue1() {
		loginf = new functions(drv);
		loginf.login("hnga\n", "hihihaha123");
		lgOps();
		timeOut("0.5");
		failCheck("Value is not of the correct type. Specify a numeric value.");
	}
	@Test
	public void FailValue2() {
		loginf = new functions(drv);
		loginf.login("hnga\n", "hihihaha123");
		lgOps();
		timeOut("hnga");
		failCheck("Value is not of the correct type. Specify a numeric value.");
	}
	@Test
	public void FailValue4() {
		loginf = new functions(drv);
		loginf.login("hnga\n", "hihihaha123");
		lgOps();
		timeOut("#$%^");
		failCheck("Value is not of the correct type. Specify a numeric value.");
	}
	@Test
	public void FailValue3() {
		loginf = new functions(drv);
		loginf.login("hnga\n", "hihihaha123");
		lgOps();
		timeOut("70");
		failCheck("Specified value is not between the expected values of 5 and 60.");
	}
	
	@Test
	public void PassValue() {
		loginf = new functions(drv);
		loginf.login("hnga\n", "hihihaha123");
		lgOps();
		timeOut("5");
		passCheck("The information that you entered has been saved.");
	}
	

}
