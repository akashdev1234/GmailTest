/**
 * 
 */
package com.dev.WebPageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dev.Library.utils;

/**
 * @author Akash Dev
 *
 */
public class SignInPage {

	public void FillUSerName(WebDriver driver, String string) {
		utils.fill(driver, By.id("Email"), "testgit1234@gmail.com");

	}

	public void FillPassword(WebDriver driver, String string) {
		utils.fill(driver, By.xpath(".//*[@id='Passwd']"), "epatchdev1234");

	}

	public void ClickNext1(WebDriver driver) {
		utils.click(driver, By.id("next"));
		utils.wait(driver, 30, TimeUnit.SECONDS);

	}

	public EmailHomePage ClickNext2(WebDriver driver) {
		utils.click(driver, By.id("signIn"));
		utils.waitForElementVisible(driver, By.xpath(".//span[@class='gb_Nb']"));

		return PageFactory.initElements(driver, EmailHomePage.class);

	}

	public boolean isElementExists(WebDriver driver) {
		return utils.isElementPresent(driver, By.partialLinkText("Need help?"));
	}

}
