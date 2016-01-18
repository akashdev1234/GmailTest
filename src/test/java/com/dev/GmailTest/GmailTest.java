/**
 * 
 */
package com.dev.GmailTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dev.Library.utils;
import com.dev.WebPageFactory.EmailHomePage;
import com.dev.WebPageFactory.SignInPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Akash Dev
 *
 */
public class GmailTest {

	// Extentreports
	// Set path for the reports
	ExtentReports report = new ExtentReports("C:\\reports\\GmailTest.html");
	ExtentTest logger = report.startTest("EmailCheckTest");

	@Test
	public void SignIn() {

		WebDriver driver = new FirefoxDriver();
		logger.log(LogStatus.INFO, "Browser Started");
		// Goto Gmail website
		SignInPage signInPage = utils.gotoSignIn(driver);
		logger.log(LogStatus.INFO, "Webpage loaded");
		// fill in username
		signInPage.FillUSerName(driver, "testgit1234@gmail.com");
		logger.log(LogStatus.INFO, "Fill username");
		// Click Next
		signInPage.ClickNext1(driver);
		logger.log(LogStatus.INFO, "Click next");
		// fill in password
		signInPage.FillPassword(driver, "epatchdev1234");
		logger.log(LogStatus.INFO, "Fill Password");
		// Click Next
		EmailHomePage emailHomepage = signInPage.ClickNext2(driver);
		logger.log(LogStatus.INFO, "again click next");
		// verify login
		Assert.assertTrue(emailHomepage.isInboxExists(driver), "Inbox Should exist");
		logger.log(LogStatus.PASS, "verify login");
		// signout
		emailHomepage.signOut(driver);
		logger.log(LogStatus.INFO, "Signout");
		// verify if user signout
		Assert.assertTrue(signInPage.isElementExists(driver), "Need help should appear");
		logger.log(LogStatus.PASS, "Verify user signout");
		driver.quit();
		logger.log(LogStatus.INFO, "close browser");
	}

	@Test
	public void chekEmail() {
		WebDriver driver = new FirefoxDriver();
		
		logger.log(LogStatus.INFO, "Start browser");
		// Goto Gmail website
		SignInPage signInPage = utils.gotoSignIn(driver);
		logger.log(LogStatus.INFO, "Go to Gmail");
		// fill in username
		signInPage.FillUSerName(driver, "testgit1234@gmail.com");
		logger.log(LogStatus.INFO, "Fill Username");
		// Click Next
		signInPage.ClickNext1(driver);
		logger.log(LogStatus.INFO, "Click next");
		// fill in password
		signInPage.FillPassword(driver, "epatchdev1234");
		logger.log(LogStatus.INFO, "Fill Password");
		// Click Next
		EmailHomePage emailHomepage = signInPage.ClickNext2(driver);
		logger.log(LogStatus.INFO, "click next again");
		// verify login
		Assert.assertTrue(emailHomepage.isInboxExists(driver), "Inbox Should exist");
		logger.log(LogStatus.PASS, "Verify login");
		// click compose
		emailHomepage.clickCompose(driver);
		logger.log(LogStatus.INFO, "click compose");
		// fill in recipent
		emailHomepage.fillRecipent(driver, "testgit1234@gmail.com");
		logger.log(LogStatus.INFO, "Fill in recipent");

		// fill in subject
		emailHomepage.fillSubject(driver, "Verification Mail");
		logger.log(LogStatus.INFO, "Fill in subject");

		// fill in email body
		emailHomepage.fillBody(driver, "This is a test mail");
		logger.log(LogStatus.INFO, "Fill in email body");

		// click send
		emailHomepage.EmailSend(driver);
		logger.log(LogStatus.INFO, "Click send");

		// click inbox
		utils.waitForElementVisible(driver, By.linkText("Inbox (1)"));
		emailHomepage.inboxClick(driver);
		logger.log(LogStatus.INFO, "Click Inbox");

		// check email
		emailHomepage.checkEmail(driver);
		logger.log(LogStatus.INFO, "Check email");

		// verify the email subject and email body is correct

		Assert.assertTrue(emailHomepage.isSubjectTextSame(driver), "Email Subject should be same");
		Assert.assertTrue(emailHomepage.isBodyTextSame(driver), "Email body should be same");
		//utils.wait(driver, 5, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS, "verify email subject and body");

		// signout
		emailHomepage.signOut(driver);
		logger.log(LogStatus.INFO, "signout");
		// verify if user signout
		Assert.assertTrue(signInPage.isElementExists(driver), "Need help should appear");
		logger.log(LogStatus.PASS, "verify user signout");
		driver.quit();
		logger.log(LogStatus.INFO, "close browser");
	}

	@AfterMethod
	public void TearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "<pre>" + result.getThrowable().getMessage() + "</pre>");

		}
		report.endTest(logger);
		report.flush();
	}
}
