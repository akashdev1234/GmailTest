package com.dev.Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dev.WebPageFactory.SignInPage;

public class utils {

	public static SignInPage gotoSignIn(WebDriver driver) {
		driver.get("http://www.gmail.com");
		return PageFactory.initElements(driver,SignInPage.class);
	}

	public static void click(WebDriver driver, By by) {
		driver.findElement(by).click();
		
	}

	public static void waitForElementVisible(WebDriver driver, By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		
	}

	public static void fill(WebDriver driver, By by, String text) {
		WebElement fillText = driver.findElement(by);
		fillText.clear();
		fillText.sendKeys(text);
		
	}

	public static void wait(WebDriver driver, int i, TimeUnit t) {
		driver.manage().timeouts().implicitlyWait(i, t);
		
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		return driver.findElements(by).size() > 0;
	}
}
