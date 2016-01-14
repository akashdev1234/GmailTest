/**
 * 
 */
package com.dev.GmailTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.dev.Library.utils;
import com.dev.WebPageFactory.EmailHomePage;
import com.dev.WebPageFactory.SignInPage;

/**
 * @author Akash Dev
 *
 */
public class GmailTest {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void SignIn() {
		// Goto Gmail website
		SignInPage signin = utils.gotoSignIn(driver);
		// fill in username
		SignInPage.FillUSerName(driver, "testgit1234@gmail.com");
		// Click Next
		SignInPage.ClickNext1(driver);
		// fill in password
		SignInPage.FillPassword(driver, "epatchdev1234");
		// Click Next
		EmailHomePage emailHomepage = SignInPage.ClickNext2(driver);

		// verify login
		Assert.assertTrue(emailHomepage.isInboxExists(driver), "Inbox Should exist");

		// signout
		EmailHomePage.signOut(driver);

		// verify if user signout
		Assert.assertTrue(SignInPage.isElementExists(driver), "Need help should appear");
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
