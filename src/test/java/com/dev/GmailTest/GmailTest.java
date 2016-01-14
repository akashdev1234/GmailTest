/**
 * 
 */
package com.dev.GmailTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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

	/*@Test
	public void SignIn() {
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
	}
*/
	@Test
	public void chekEmail() {
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
		//click compose
         driver.findElement(By.cssSelector("div[gh='cm']")).click();
		//fill in recipent
         driver.findElement(By.cssSelector("textarea[class='vO']")).sendKeys("testgit1234@gmail.com");
		//fill in subject
         //utils.wait(driver, 5, TimeUnit.SECONDS);
         driver.findElement(By.xpath(".//form/div[3]/input")).sendKeys("Verification Mail");
		//fill in email body
         //utils.wait(driver, 5, TimeUnit.SECONDS);
         WebElement area = driver.findElement(By.xpath(".//*[@role='textbox']"));
         area.clear();
         area.sendKeys("This is a test mail");
		//click send
         WebElement btn = driver.findElement(By.xpath("//*[@role='button' and .='Send']"));
         btn.click();
		//click inbox
         driver.findElement(By.partialLinkText("Inbox")).click();
		//check email
   
         
		//verify the email subject and email body is correct
		//signout

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
