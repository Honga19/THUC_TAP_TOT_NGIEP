package AvySearchTip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTip {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://support.avaya.com/products/P0638/proactive-outreach-manager");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("GlobalSearch_SearchTips")).click();
		
		WebElement title = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/h1"));
		String titleContent = title.getText();
		System.out.print(titleContent);
		
	}

}
