package LoginOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class setUp {
	WebDriver drv;
	@BeforeMethod
	public void sUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Download\\\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.setAcceptInsecureCerts(true);
		drv = new ChromeDriver(ops);
		drv.get("https://10.30.8.82/VoicePortal");
		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void close() {
	drv.close();	
	}
	
}
