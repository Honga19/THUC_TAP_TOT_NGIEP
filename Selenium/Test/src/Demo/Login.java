package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
public class Login {
	WebDriver drv;
	public Login (WebDriver drv) {
		this.drv = drv;
	}
	public void login(String uName, String pass) {
		drv.findElement(By.id("username")).sendKeys(uName);
		drv.findElement(By.id("password")).sendKeys(pass);
		drv.findElement(By.xpath("//*[@id=\"body_section\"]/div/form/div[5]/input")).click();
		String url = "https://10.30.8.81/VoicePortal/faces/main.jsf";
		String urlGet = drv.getCurrentUrl();
		Assert.assertEquals(urlGet, url);
	}
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.setAcceptInsecureCerts(true);
		drv = new ChromeDriver(ops);
		drv.get("https://10.30.8.81/VoicePortal");
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
}
