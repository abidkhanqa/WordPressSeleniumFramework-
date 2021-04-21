package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wordpress.base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;
	
	private By emailId = By.id("usernameOrEmail");
	private By password = By.id("password");
	private By continueButton = By.xpath("//button[@type='submit']");
	private By loginButton = By.xpath("//button[@type='submit']");
	
	
	public ProfilePage login(String emailAddress, String passWord) {
		driver.findElement(emailId).sendKeys(emailAddress);
		driver.findElement(continueButton).click();
		driver.findElement(password).sendKeys(passWord);
		driver.findElement(loginButton).click();
		
		return new ProfilePage(driver);
	}
	
}
