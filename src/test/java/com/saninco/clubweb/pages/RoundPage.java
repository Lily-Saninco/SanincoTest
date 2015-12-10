package com.saninco.clubweb.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoundPage extends ClubDefaultPage{

	public RoundPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".pl.pltitab")
	public List<WebElement> RoundNumber;

	public void clickRoundButton(int number) {
		RoundNumber.get(number-1).click();
	}
}

