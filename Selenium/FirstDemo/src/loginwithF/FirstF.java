package loginwithF;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstF {
	WebDriver driver;
	public void login(String uName, String pass) {
		
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"body_section\"]/div/form/div[5]/input")).click();
		
	}
	static void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();

		ops.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(ops);
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://10.30.8.81/VoicePortal");
		
		driver.manage().window().maximize();
	}
	public void main(String[] args) {
		// TODO Auto-generated method stub

		setUp();
		login("nga", "matkhau123");
	}
		
}

