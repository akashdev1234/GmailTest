package com.dev.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dev.WebPageFactory.SignInPage;

public class utils {

	public static SignInPage gotoSignIn(WebDriver driver) {
		driver.get("http://www.gmail.com");
		return PageFactory.initElements(driver,SignInPage.class);
	}
}
