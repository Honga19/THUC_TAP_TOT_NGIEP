package LoginOps;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ssTimeOut{
	WebDriver driver;
	public void login() {
		driver.findElement(By.id("username")).sendKeys("hnga\n");
		driver.findElement(By.id("password")).sendKeys("hihihi.12");
		driver.findElement(By.xpath("//*[@id=\"body_section\"]/div/form/div[5]/input")).click();
		}
	public void elm(String time) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menu");
		driver.findElement(By.xpath("//*[@id=\"menuForm:menuTable:0:menuItemTable:3:menuItem_panelGroup\"]/a/span")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement a = driver.findElement(By.id("userSettings:sessionTimeout"));
		a.clear();
		a.sendKeys(time);
		System.out.print(time +": ");
	}
	public void testt() {
		driver.findElement(By.id("userSettings:save1")).click();
		driver.findElement(By.className("leftcolumn")).getText();
		String warning= driver.findElement(By.xpath("//*[@id=\"userSettings:loginOpts1\"]/tbody/tr[2]/td[2]/span")).getText();
		System.out.print(warning+ "\n");
	} 
	@Test
	public void FailValue() {
		elm("0.5");
		testt();
	}
	@Test
	public void FailValue1() {
		elm("hngaaa");
		testt();
	}
	@Test
	public void FailValue2() {
		elm("0");
		testt();
	}
	@Test
	public void FailValue3() {
		elm("100");
		testt();
	}
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(ops);
		driver.get("https://10.30.8.81/VoicePortal");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login();
		}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}