package com.saninco.maventest;
//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitTestCase1 {

	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("i hope jenkins work!");
		driver.get("http://192.168.1.77:8080/Club");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		WebElement username=driver.findElement(By.id("j_username"));
		username.sendKeys("user3");
		WebElement password=driver.findElement(By.id("j_password"));
		password.sendKeys("1");
		WebElement loginButton=driver.findElement(By.cssSelector(".loginbut.pmar>a"));
		loginButton.click();

		driver.quit();
	}

}
