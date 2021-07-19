package WebTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validate_Welcome_Page {

	@Test
	public static void Validate_Welcome_Page() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://test.amplifypro.life");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@value='Got It']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("srikanthm1208@gmail.com");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("password")).sendKeys("Test_123");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(1000);
		
		String Actual_page_title = driver.getTitle();
		
		String Expected_page_title = "Amplify Pro - Coaching and Rehab Tool for Personal Trainers, Gyms, Physios and Therapists";
		
		Assert.assertEquals(Actual_page_title, Expected_page_title);
		
		driver.quit();
		
		
		
	}

}
