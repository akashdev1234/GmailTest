/**
 * 
 */
package com.dev.WebPageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Akash Dev
 *
 */
public class SignInPage {

	public static void FillUSerName(WebDriver driver, String string) {
		driver.findElement(By.id("Email")).sendKeys("testgit1234@gmail.com");
		

	}

	public static void FillPassword(WebDriver driver, String string) {
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("epatchdev1234");
		
	}

	public static void ClickNext1(WebDriver driver) {
		driver.findElement(By.id("next")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public static EmailHomePage ClickNext2(WebDriver driver) {
		driver.findElement(By.id("signIn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='gb_Nb']")));
		return PageFactory.initElements(driver, EmailHomePage.class);
		
	}

	public static boolean isElementExists(WebDriver driver) {
		return driver.findElements(By.partialLinkText("Need help?")).size() > 0;
	}

}
