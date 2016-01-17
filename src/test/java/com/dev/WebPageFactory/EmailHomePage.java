/**
 * 
 */
package com.dev.WebPageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	public void clickCompose(WebDriver driver) {	
		utils.click(driver, By.cssSelector("div[gh='cm']"));
	}

	public void fillRecipent(WebDriver driver, String string) {
		utils.fill(driver, By.cssSelector("textarea[class='vO']"), string);	
	}

	public void fillSubject(WebDriver driver, String string) {
		utils.fill(driver, By.xpath(".//form/div[3]/input"), string);
	}

	public void fillBody(WebDriver driver, String string) {
		utils.fill(driver, By.xpath(".//*[@role='textbox']"), "This is a test mail");
		
	}

	public void EmailSend(WebDriver driver) {	
		utils.click(driver, By.xpath("//*[@role='button' and .='Send']"));
	}

	public void inboxClick(WebDriver driver) {
		// TODO Auto-generated method stub
		utils.click(driver, By.linkText("Inbox (1)"));
		
	}

	public void checkEmail(WebDriver driver) {
		utils.click(driver, By.cssSelector("div[class='y6'] span[id] b"));
		
	}

	public boolean isSubjectTextSame(WebDriver driver) {
		return utils.isElementPresent(driver, By.xpath(".//div/h2[text()='Verification Mail']"));
		
	}

	public Boolean isBodyTextSame(WebDriver driver) {
		// TODO Auto-generated method stub
		return utils.isElementPresent(driver, By.xpath("//div[contains(.,'This is a test mail')]"));
	}
	

}
