package com.saninco.clubweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClubDefaultPage {
	
	WebDriver driver;

		
	public ClubDefaultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	

	public void loadDefaultPage(WebDriver driver){
		driver.get("http://192.168.1.77:8080/Club");	
	}
	


}

