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

import com.dev.Library.utils;

/**
 * @author Akash Dev
 *
 */
public class EmailHomePage {

	public SignInPage signOut(WebDriver driver) {
		utils.click(driver, By.xpath("//span[@class='gb_Za gbii']"));
		utils.wait(driver, 200, TimeUnit.MILLISECONDS);
		utils.click(driver, By.xpath(".//*[@id='gb_71']"));
		utils.waitForElementVisible(driver, By.xpath("//div[@class='logo logo-w']"));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public boolean isInboxExists(WebDriver driver) {
		return utils.isElementPresent(driver, By.partialLinkText("Inbox"));
	}

}
