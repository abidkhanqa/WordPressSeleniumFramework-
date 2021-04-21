package com.wordpress.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wordpress.constants.FilePathConstants;
import com.wordpress.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	protected BasePage() {
		
	}
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	
	/**
	 * This method is used to initialize the browser on the basis of given browser
	 * @param browser
	 * @return This returns WebDriver driver
	 */
	public WebDriver initDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			throw new RuntimeException("Please check config.properties file " + browser + " is not a valid browser name");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	/**
	 * This method us used to load the properties from config.properties file
	 * @return It returns Properties prop reference
	 */
	public Properties initProperties() {
		
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(FilePathConstants.getConfigFilepath());
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
