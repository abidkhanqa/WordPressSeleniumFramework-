package com.wordpress.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.wordpress.pages.LoginPage;
import com.wordpress.pages.ProfilePage;

public class BaseTest {

	public BasePage basePage;
	public LoginPage loginPage;
	public ProfilePage profilePage;
	public Properties prop;
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initProperties();
		driver = basePage.initDriver(prop.getProperty("browser"));
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	

}
