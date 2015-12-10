/*
 * Project: Club
 * Test case: User login
 * Createdby: Lily
 * Created Time:20151106
 * 
 */
package com.saninco.clubweb.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.saninco.clubweb.testClass.ClubUser;
//import com.saninco.club.pages.UserPage;
import com.saninco.clubweb.util.FileForUser;
import com.saninco.clubweb.pages.CompetitionPage;
import com.saninco.clubweb.pages.LoginPage;
import com.saninco.clubweb.pages.OperationPage;
import com.saninco.clubweb.pages.RoundControlPage;
import com.saninco.clubweb.pages.RoundPage;

/*
 * Get Parameter from the Excel Table
 * 
 */

@RunWith(value = Parameterized.class)
public class TestClubCompetion {

	private WebDriver driver;
	ClubUser user;

	@Parameters
	public static Collection<ClubUser> testData() throws IOException {
		
		ArrayList<ClubUser> users=FileForUser.readFile();
//		for (ClubUser user : users)
//		{
//		System.out.println("user:"+user.getEmail());
//		}
		return users ;
	}
	
	public TestClubCompetion(ClubUser user) {
		this.user = user;

	}

	@Before
	
	public void setUp() throws Exception {


		String browser = user.getBrowser();

		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver", "D:\\downloadSoftware\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			}
		else if (browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "D:\\downloadSoftware\\driver\\chromedriver.exe");
			
			/*
			 * 
			 *  Get rid of
			 *  "You are using an unsupported command-line
			 *   flag –ignore-certificate-errors. 
			 *   Stability and security will suffer "
			 *  
			 */
						
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			
			}
		else{
			
			System.out.println("Browser is not exist, use the firefox driver as a default driver ");
			driver = new FirefoxDriver();
		}

		driver.get("http://192.168.1.77:8080//Club");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}

	@Test
	public void testUserLogin() throws Exception {

		LoginPage loginPage;

//		UserPage userPage;

		loginPage = new LoginPage(driver);
		CompetitionPage competitionPage = new CompetitionPage(driver);
		OperationPage operationPage = new OperationPage(driver);
		RoundPage roundPage = new RoundPage(driver);
		
		// check YouEmailAddress windows pop up.
//		loginPage.checkYouEmailAddress(user.getEmail(), user.getPostalCode());



		loginPage.inputEmail(user.getUserName());
		loginPage.inputPassword(user.getPassword());
		loginPage.clickSigninButton();
		System.out.println("user.getCompitition()"+user.getCompitition());
		if ("P".equals(user.getCompitition()))
		{
		competitionPage.clickPulitzerEnterButton();
		}
		else if ("I".equals(user.getCompitition())){
			competitionPage.clickIngeMorathEnterButton();	
			
		}
		else if ("C".equals(user.getCompitition())){
			competitionPage.clickChrisHondrosButton();	
		}
		
		System.out.println("user.getOperation()"+user.getOperation());
		if ("Round".equals(user.getOperation()))
		{
		operationPage.clickRound();
		roundPage.clickRoundButton(user.getRoundNumber());
		roundtest_operation();
		}
		else if ("Award".equals(user.getOperation())){
			operationPage.clickAward();
		}
		else if ("Presentation".equals(user.getOperation())){
			operationPage.clickPresentation();
		}
		else if ("Projector".equals(user.getOperation())){
			operationPage.clickProjector();
		}



	}

	private void roundtest_operation() {
		

		RoundControlPage roundControlPage = new RoundControlPage(driver);
		
		//LockJudge
		roundControlPage.lockJudge1();
		roundControlPage.lockJudge2();
		roundControlPage.lockJudge3();
		// set automation play
		roundControlPage.autoPlayPress();
		//lock projector
		//mobile place start score
		
		
	}

	@After
	public void tearDown() throws Exception {
	//	driver.quit();

	}

}
