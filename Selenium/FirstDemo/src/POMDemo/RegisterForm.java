package POMDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver.exe");
		WebDriver drv = new ChromeDriver();
		drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		drv.get("https://support.avaya.com/products/P0638/proactive-outreach-manager");
		drv.manage().window().maximize();
		
		drv.findElement(By.linkText("Register Now")).click();
		String url = "https://cxpservices.avaya.com/signup/#/selfRegistration";
		String urlGet = drv.getCurrentUrl();
		Assert.assertEquals(url, urlGet);
		WebElement Par_rls = drv.findElement(By.xpath("/html/body/div[1]/div/div/main/div/app-self-register-user/section/form/div/div/div[1]/div"));
		boolean parStt = Par_rls.isSelected();
		WebElement Cus_rls = drv.findElement(By.xpath("/html/body/div[1]/div/div/main/div/app-self-register-user/section/form/div/div/div[2]/div"));
		boolean cusStt = Cus_rls.isSelected();
		WebElement No_rls = drv.findElement(By.xpath("/html/body/div[1]/div/div/main/div/app-self-register-user/section/form/div/div/div[3]/div"));
		boolean NoStt = No_rls.isSelected();
			if (parStt == true || cusStt == true || NoStt == true) {
			drv.findElement(By.name("Next")).click();
			}
		drv.quit();
	}

}
