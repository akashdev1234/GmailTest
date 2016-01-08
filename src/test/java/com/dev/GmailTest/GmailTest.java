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

/**
 * @author Akash Dev
 *
 */
public class GmailTest {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void SignIn() {

		driver.get("http://www.gmail.com");
		driver.findElement(By.id("Email")).sendKeys("testgit1234@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("epatchdev1234");
		;
		driver.findElement(By.id("signIn")).click();

		// verify login
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='gb_Nb']")));
		Assert.assertTrue(driver.findElements(By.partialLinkText("Inbox")).size() > 0, "Inbox Should exist");
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
