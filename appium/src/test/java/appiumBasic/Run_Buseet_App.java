package appiumBasic;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.api.general.AlertEventListener;
import io.appium.java_client.remote.MobileCapabilityType;

public class Run_Buseet_App {
	AndroidDriver <MobileElement>driver;
	@Test
	
	public void Open_Application () throws MalformedURLException, InterruptedException {
	
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("PlatformName","Android");

caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Abdelrahman");
caps.setCapability(MobileCapabilityType.APP,"E:\\Appium space work\\appium\\buseet.apk");
caps.setCapability(MobileCapabilityType.APP,"E:\\Appium space work\\appium\\buseet.apk");


 driver = new AndroidDriver <MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
driver.findElement(By.id("com.buseet.client_android:id/positiveBtn")).click();
driver.findElement(By.id("com.buseet.client_android:id/BT_skip")).click();
Thread.sleep(3000);
driver.switchTo().alert().accept();
Thread.sleep(3000);

//WebDriverWait wait = new WebDriverWait(driver, 10);
//wait.until(ExpectedConditions.elementToBeClickable("com.buseet.client_android:id/profile_image"));
 driver.findElement(By.id("com.buseet.client_android:id/profile_image")).click();
driver.findElement(By.id("com.buseet.client_android:id/BT_logout")).click();
driver.findElement(By.id("com.buseet.client_android:id/mobileNumberET")).sendKeys("1067155344");
driver.findElement(By.id("com.buseet.client_android:id/loginBtn")).click();




	}
	
	public String getOTP () {
		
		Activity activity = new Activity("com.android.mms", "com.android.mms.ui.ConversationList");	
		activity.setAppWaitActivity("com.android.mms.ui.ConversationList");
		activity.setAppWaitPackage("com.android.mms");
        ((AndroidDriver) driver).startActivity(activity);
        driver.switchTo().alert().accept();
        String getotp = driver.findElementById("com.android.mms:id/subject").getText().split(":")[1].trim();
        
        return getotp;
	}
	
	public void signup () {
		
		driver.findElement(By.id("com.buseet.client_android:id/firstNameET")).sendKeys("Abdelrahman");
		driver.findElement(By.id("com.buseet.client_android:id/lastNameET")).sendKeys("Yosry");
		driver.findElement(By.id("com.buseet.client_android:id/emailET")).sendKeys("abdelrahmanyosry2013@gmail.com");
		driver.findElement(By.id("com.buseet.client_android:id/passwordET")).sendKeys("password");
		driver.findElement(By.id("com.buseet.client_android:id/submitBtn")).click();
		driver.findElement(By.id("com.buseet.client_android:id/continueBT")).click();
		
	}
	
	public void work () {
		driver.findElement(By.id("com.buseet.client_android:id/searchCompanyItemRoot")).click();
		driver.switchTo().alert().accept();
		
	}
	
	public void Edit_profile () {
		
		driver.findElement(By.id("com.buseet.client_android:id/profile_image")).click();
		driver.findElement(By.id("com.buseet.client_android:id/IB_more")).click();
		driver.findElement(By.id("com.buseet.client_android:id/BT_back")).click();
	}
	
	public void Add_homeAnd_Work(){
		driver.findElement(By.id("com.buseet.client_android:id/textView8")).click();
		
		driver.findElement(By.id("com.buseet.client_android:id/BtnSave")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("com.buseet.client_android:id/cardInfo")).click();
		driver.findElement(By.id("com.buseet.client_android:id/destinationAutoCompleteFrom")).sendKeys("Buseet",Keys.ENTER);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		
	}
	
	public void book () {
		driver.findElement(By.id("com.buseet.client_android:id/cardInfo")).click(); 
	}
	
}
