/**
 * 
 */
package com.dev.GmailTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dev.Library.utils;
import com.dev.WebPageFactory.EmailHomePage;
import com.dev.WebPageFactory.SignInPage;

/**
 * @author Akash Dev
 *
 */
public class GmailTest {

	@Test
	public void SignIn() {
		WebDriver driver = new FirefoxDriver();
		// Goto Gmail website
		SignInPage signInPage = utils.gotoSignIn(driver);
		// fill in username
		signInPage.FillUSerName(driver, "testgit1234@gmail.com");
		// Click Next
		signInPage.ClickNext1(driver);
		// fill in password
		signInPage.FillPassword(driver, "epatchdev1234");
		// Click Next
		EmailHomePage emailHomepage = signInPage.ClickNext2(driver);
		// verify login
		Assert.assertTrue(emailHomepage.isInboxExists(driver), "Inbox Should exist");
		// signout
		emailHomepage.signOut(driver);
		// verify if user signout
		Assert.assertTrue(signInPage.isElementExists(driver), "Need help should appear");
		driver.quit();
	}

	@Test
	public void chekEmail() {
		WebDriver driver = new FirefoxDriver();
		// Goto Gmail website
		SignInPage signInPage = utils.gotoSignIn(driver);
		// fill in username
		signInPage.FillUSerName(driver, "testgit1234@gmail.com");
		// Click Next
		signInPage.ClickNext1(driver);
		// fill in password
		signInPage.FillPassword(driver, "epatchdev1234");
		// Click Next
		EmailHomePage emailHomepage = signInPage.ClickNext2(driver);
		// verify login
		Assert.assertTrue(emailHomepage.isInboxExists(driver), "Inbox Should exist");
		// click compose
		emailHomepage.clickCompose(driver);

		// fill in recipent
		emailHomepage.fillRecipent(driver, "testgit1234@gmail.com");

		// fill in subject
		emailHomepage.fillSubject(driver, "Verification Mail");

		// fill in email body
		emailHomepage.fillBody(driver, "This is a test mail");

		// click send
		emailHomepage.EmailSend(driver);

		// click inbox
		utils.waitForElementVisible(driver, By.linkText("Inbox (1)"));
		emailHomepage.inboxClick(driver);

		// check email
		emailHomepage.checkEmail(driver);

		// verify the email subject and email body is correct

		Assert.assertTrue(emailHomepage.isSubjectTextSame(driver), "Email Subject should be same");
		Assert.assertTrue(emailHomepage.isBodyTextSame(driver), "Email body should be same");
		utils.wait(driver, 5, TimeUnit.SECONDS);
		// signout
		emailHomepage.signOut(driver);
		// verify if user signout
		Assert.assertTrue(signInPage.isElementExists(driver), "Need help should appear");
		driver.quit();
	}
}
