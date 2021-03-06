package Login;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginform {
	WebDriver driver;
	public void login(String userName, String password) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"body_section\"]/div/form/div[5]/input")).click();
		}
	
	public void logout() {
 		driver.switchTo().frame("header");
	 	WebElement logoutBtn = driver.findElement(By.id("topMenuForm:logoff"));
		try {
	 	if (logoutBtn.isDisplayed()) {
			logoutBtn.click();
			System.out.print("correct");
			}
		}
		catch (Exception e)
		{
			System.out.print("incorrect");
		}
	}
	
	public void test() {
		String url = "https://10.30.8.81/VoicePortal/faces/main.jsf";
		String urlGet = driver.getCurrentUrl();
		Assert.assertEquals(urlGet, url);
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
		}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@Test
	public void loginByAdmin() {
		login("hnga\n", "hihihi.12");
		test();
		logout();
	}

	@Test
	public void loginFail() {
		login("hnga\n", "");
		test();
		logout();		
	}
	
	@Test
	public void loginFail2() {
		login("hngaaaaa\n", "hihihi.21");
		test();
		logout();
	}
}