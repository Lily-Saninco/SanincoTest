package com.saninco.maventest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;




public class mobileTest {
  @Test
  public void androidClubLogin() throws InterruptedException, ExecuteException, IOException {
	  AndroidDriver driver;	  
	  
	  System.out.println("****************setUP Starts****************");

	  System.out.println("ANDROID_HOME:"+System.getenv("ANDROID_HOME"));
	  System.out.println("PATH : "+System.getenv("PATH"));

	  DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	  DefaultExecutor executor = new DefaultExecutor();
	  executor.setExitValue(1);
	  // executor.execute(killNode,resultHandler);
	  // executor.execute(killPlayerEmulator,resultHandler);
	  // executor.execute(killADB,resultHandler);

	  // CommandLine command = new CommandLine("/bin/sh -c¡±);
	  // command.addArgument("/Applications/Appium.app/Contents/Resources/node/bin/node¡±,false);

	  //CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
	  CommandLine command = new CommandLine("node");

	  //command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
	  command.addArgument("C:/Program Files (x86)/Appium/node_modules/appium/bin/Appium.js", false);
	  command.addArgument("--address", false);
	  command.addArgument("127.0.0.1");
	  command.addArgument("--port", false);
	  //command.addArgument("6723");
	  command.addArgument("4723");
	  command.addArgument("--bootstrap-port", false);
	  //command.addArgument("6724");
	  command.addArgument("4242");
	  // command.addArgument("¨Cno-reset¡±, false);

	  executor.execute(command, resultHandler);

	  Thread.sleep(20000);  
  
	  
	  
	  File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Apps/Club/");
		File app = new File(appDir, "SPSApp7.apk");
		
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
		
		// find keyword Ê×Ò³ and verify it is display
        //Assert.assertTrue(driver.findElement(By.name("Ê×Ò³")).isDisplayed());
  }
}
