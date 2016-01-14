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
public class EmailHomePage {

	public static SignInPage signOut(WebDriver driver) {
		driver.findElement(By.xpath("//span[@class='gb_Za gbii']")).click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='logo logo-w']")));
		return PageFactory.initElements(driver, SignInPage.class); 
	}

	public boolean isInboxExists(WebDriver driver) {
		return driver.findElements(By.partialLinkText("Inbox")).size() > 0;
	}

}
