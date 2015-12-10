package com.saninco.clubweb.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoundControlPage extends ClubDefaultPage{

	public RoundControlPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "judge_1_lockBtn")
	public WebElement judge_1_lockBtn;

	@FindBy(id = "judge_2_lockBtn")
	public WebElement judge_2_lockBtn;
	
	@FindBy(id = "judge_3_lockBtn")
	public WebElement judge_3_lockBtn;
	
	@FindBy(id = "play_auto_btn")
	public WebElement play_auto_btn;
	
	public void lockJudge1(){
		if("N".equals(judge_1_lockBtn.getAttribute("lockflag")))

		{
		judge_1_lockBtn.click();
		}
	}
	
	public void lockJudge2(){
		if("N".equals(judge_2_lockBtn.getAttribute("lockflag"))){
		judge_2_lockBtn.click();
		}
	}
	
	public void lockJudge3(){
		if("N".equals(judge_3_lockBtn.getAttribute("lockflag"))){
		judge_3_lockBtn.click();
		}
	}
	
	public void autoPlayPress(){
		if("N".equals(play_auto_btn.getAttribute("autolockflag"))){
		play_auto_btn.click();
		}
	}
	
}

