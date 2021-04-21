package com.wordpress.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wordpress.base.BasePage;
import com.wordpress.utils.TestUtil;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebDriver driver;
	
	private By profilePageHeader = By.xpath("//h1[normalize-space()='My Profile']");
	private By yourProfileLink = By.linkText("your profile");
	private By userNameValue = By.xpath("//a[normalize-space()='testqa12']");
	private By publicDisplayName = By.xpath("//input[@name='display_name']");
	private By firstName = By.id("first_name");
	private By lastName = By.id("last_name");
	private By aboutMe = By.id("description");
	private By saveProfileDetailsButton = By.xpath("//button[@type='submit']");
	private By savedSettingSuccessMessage = By.xpath("//span[contains(text(),'Settings saved successfully!')]");
	private By moreInformationButton = By.xpath("//button[@aria-label='More information']");
	private By moreInformationEmail = By.xpath("//*[contains(text(),'testqa1901@gmail.com')]"); 
	private By addButton = By.xpath("//button[@class='button is-compact']");
	private By addWordPressSite = By.xpath("//button[normalize-space()='Add WordPress Site']");
	private By addUrl = By.xpath("//button[text()='Add URL']");
	private By createSiteButton = By.xpath("//button[normalize-space()='Create Site']");
	private By cancelSiteButoon = By.xpath("//button[normalize-space()='Cancel']");
	private By urlTextBox = By.name("value");
	private By descriptionTextBox = By.name("title");
	private By addSite = By.xpath("//button[normalize-space()='Add Site']");
	private By profileLink = By.className("profile-link__url");
	private By helpButton = By.xpath("//button[@title='Help']");
	private By helpResultLists = By.xpath("//ul[@class='inline-help__results-list']/li");
	private By searchForHelpTextBox = By.xpath("//input[@type='search']");
	private By searchResult1 = By.xpath("//span[normalize-space()='Moving a Website or Blog']");
	
	
	public String getProfilePageTile() {
		return driver.getTitle();
	}
	
	public String getProfilePageHeaderValue() {
		if(	driver.findElement(profilePageHeader).isDisplayed()) {
			return driver.findElement(profilePageHeader).getText();
		}
		return null;
	}
		
	public String getUserGravatarProfile() {
		TestUtil.waitForElementVisible(driver, yourProfileLink);
		String userName = null;
		String parentWindow = driver.getWindowHandle();
		driver.findElement(yourProfileLink).click();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		for(String childWindow: allWindows) {
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
		 		userName = driver.findElement(userNameValue).getText();
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		return userName;
	}
	
	public String getMoreInformationEmail() {
		TestUtil.waitForPageLoaded(driver);
		driver.findElement(moreInformationButton).click();
		String words = driver.findElement(moreInformationEmail).getText();
		String newwords[] = words.split(" ");
		return newwords[newwords.length-1];
	}
	
	public String getPublicDisplayName() {
		TestUtil.waitForElementVisible(driver, publicDisplayName);
		return driver.findElement(publicDisplayName).getAttribute("value");
	}
	
	 public boolean saveProfileDetailsDisabled() {
		return driver.findElement(saveProfileDetailsButton).isEnabled();
	 }
	
	public String saveProfileDetails() {
		TestUtil.waitForElementVisible(driver, firstName);
		driver.findElement(firstName).sendKeys("John");
		driver.findElement(lastName).sendKeys("Smith");
		driver.findElement(aboutMe).sendKeys("Hi I am John!");
		driver.findElement(saveProfileDetailsButton).click();
		TestUtil.waitForElementVisible(driver, savedSettingSuccessMessage);
		return driver.findElement(savedSettingSuccessMessage).getText();
	}
	
	public boolean addWordPressSite() {
		TestUtil.waitForElementVisible(driver, addButton);
		driver.findElement(addButton).click();
		driver.findElement(addWordPressSite).click();
		return driver.findElement(createSiteButton).isDisplayed();
	}
	
	public boolean cancelProfileLinks() {
		addWordPressSite();
		try {
			driver.findElement(cancelSiteButoon).click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public String addUrl() {
		TestUtil.waitForElementVisible(driver, addButton);
		driver.findElement(addButton).click();
		driver.findElement(addUrl).click();
		driver.findElement(urlTextBox).sendKeys("www.google.com");
		driver.findElement(descriptionTextBox).sendKeys("google");
		driver.findElement(addSite).click();
		return driver.findElement(profileLink).getText();

	}
	
	public List<WebElement> searchForHelp() {
		TestUtil.waitForElementVisible(driver, helpButton);
		driver.findElement(helpButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(searchForHelpTextBox).sendKeys("website");
		TestUtil.waitForElementVisible(driver, searchResult1);
		List<WebElement> AllsearchResults = driver.findElements(helpResultLists);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return AllsearchResults;
	}
}
