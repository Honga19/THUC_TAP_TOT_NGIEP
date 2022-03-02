package AutoFramework;
	
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FirstTC {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://10.30.8.81/VoicePortal");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("hnga\n");
		driver.findElement(By.id("password")).sendKeys("hihihi,.12");
		driver.findElement(By.xpath("//*[@id=\"body_section\"]/div/form/div[5]")).click();
		String url = "https://10.30.8.81/VoicePortal/faces/main.jsf";
		String urlGet = driver.getCurrentUrl();
		Assert.assertEquals(urlGet, url);
	 	driver.close();
	}

}
