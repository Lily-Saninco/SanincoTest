package com.saninco.maventest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class mobileTest {
  @Test
  public void androidClubLogin() throws InterruptedException, MalformedURLException {
	  AndroidDriver driver;
	  File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Apps/Club/");
		File app = new File(appDir, "SPSApp5.apk");
		
		System.out.println("-----------------");
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "MyDevice");
		//capabilities.setCapability("deviceName", "SM-G730W8");
		capabilities.setCapability("platformVersion", "4.4.2");
		//capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.sps");
		capabilities.setCapability("appActivity", "actvity.SPSAppActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		WebElement username=driver.findElementById("com.sps:id/username");
		username.sendKeys("judge3");
		WebElement password=driver.findElementById("com.sps:id/password");
		password.sendKeys("1");
		WebElement loginButton=driver.findElement(By.className("android.widget.Button"));
		loginButton.click();
		
  }
}
