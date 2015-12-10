/*
 * Project: Club
 * Test case: User login
 * Createdby: Lily
 * Created Time:20151106
 * 
 */
package com.saninco.clubweb.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import com.saninco.clubweb.util.*;
import com.saninco.clubweb.pages.LoginPage;

/*
 * Get Parameter from the Excel Table
 * 
 */

@RunWith(value = Parameterized.class)
public class TestClubLoginPageWithJUnit {

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
	
	public TestClubLoginPageWithJUnit(ClubUser user) {
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
			 *   flag �ignore-certificate-errors. 
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
		// check YouEmailAddress windows pop up.
//		loginPage.checkYouEmailAddress(user.getEmail(), user.getPostalCode());



		loginPage.inputEmail(user.getUserName());
		loginPage.inputPassword(user.getPassword());
		loginPage.clickSigninButton();

//		userPage = new UserPage(driver);
//		String firstName = userPage.getUserFirstNameText();


		// Get the user information from database
//		System.out.println(firstName);
		ClubUser databaseUser = FileForUser.userSearch(user.getUserName());
//		if (databaseUser.equals(null)) {
//			fail("User not exist");
//		}
		// Verify firstName is correct
		String databaseFirstName = databaseUser.getUserName().toUpperCase();
		assertEquals(databaseFirstName, user.getUserName());
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();

	}

}
