import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Testing {

	@Test
	public static void validate_Purchase_Amount() throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities cap= new DesiredCapabilities();

		File appDir = new File("src");

		File app = new File(appDir, "General-Store.apk");



		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Rahulemulator");


		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step


		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		Thread.sleep(4000);
		//Select the Country Argentina
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
		
		//Enter "Hello" in the name field
		driver.findElementByXPath("//android.widget.EditText[@index='3']").sendKeys("Hello");
		
		//Select gender female
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		
		//Press the Let's Shop Button
		driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
		
		Thread.sleep(3000);
		
			List<AndroidElement> Add_to_cart_buttons = driver.findElementsById("com.androidsample.generalstore:id/productAddCart");
			
			Add_to_cart_buttons.get(0).click();
			
			Thread.sleep(3000);
			
			Add_to_cart_buttons.get(1).click();
			
			Thread.sleep(3000);
			
			
			//click on cart
			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
			
			Thread.sleep(3000);
			
			double sum_of_products = 0;
			List<AndroidElement> prices = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
			for (int i = 0; i < prices.size(); i++) 
			{
			
				String Amount = prices.get(i).getText();
				Amount = Amount.substring(1);
				double value = Double.parseDouble(Amount);
				
				sum_of_products = value + sum_of_products;
				
			}
		
			System.out.println("sum of the two products : "+ sum_of_products);
			
			String Cart_total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
			
			Cart_total = Cart_total.substring(1);
			
			double Cart_total_value = Double.parseDouble(Cart_total);
			
			System.out.println("Cart total Value : " +Cart_total_value);
			
			Assert.assertEquals(sum_of_products, Cart_total_value);
			

	}

}
