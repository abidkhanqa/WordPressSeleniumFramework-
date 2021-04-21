package com.wordpress.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.annotations.ExtentReport;
import com.wordpress.base.BaseTest;
import com.wordpress.constants.FrameworkConstants;
import com.wordpress.enums.ExtentReportEnums;

@ExtentReport(category = ExtentReportEnums.MYPROFILE)
public class MyProfilepageTests extends BaseTest{
	
	
	@BeforeMethod
	public void profilePageSetUp() {
		profilePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyProfilePageTitle() {
		String title = profilePage.getProfilePageTile();
		Assert.assertEquals(title, FrameworkConstants.getProfilepagetitle());
	}
	
	@Test(priority = 2)
	public void verifyProfilePageHeader() {
		String headerValue = profilePage.getProfilePageHeaderValue();
		Assert.assertEquals(headerValue, FrameworkConstants.getProfileheader());
	}
	
	@Test(priority = 3)
	public void verifyYourProfileLink() {
		String profileName = profilePage.getUserGravatarProfile();
		Assert.assertEquals(profileName, FrameworkConstants.getProfileanme());
	}
	
	@Test(priority = 4)
	public void verifyMoreInformationEmailAddress() {
		String emailAddress = profilePage.getMoreInformationEmail();
		Assert.assertEquals(emailAddress, FrameworkConstants.getEmailaddress());
	}
	
	@Test(priority = 5)
	public void verifyPublicDisplayName() {
		String displayName = profilePage.getPublicDisplayName();
		Assert.assertEquals(displayName, FrameworkConstants.getDisplayname());
	}
	
	@Test(priority = 6)
	public void verifySaveProfileDetailsButtonIsDisabled() {
		boolean expected = profilePage.saveProfileDetailsDisabled();
		Assert.assertFalse(expected, "Save profile details button is enabled");
	}
	
	@Test(priority = 7)
	public void verifySaveProfileDetailsSuccessMessage() {
		String message = profilePage.saveProfileDetails();
		Assert.assertEquals(message, FrameworkConstants.getSaveprofilesuccessmessage());
	}
	
	@Test(priority = 8)
	public void verifyAddWordPressSite() {
		boolean createSiteButton = profilePage.addWordPressSite();
		Assert.assertTrue(createSiteButton);
	}
	
	@Test(priority = 9)
	public void verifyCancelProfileLinks() {
		boolean cancelled = profilePage.cancelProfileLinks();
		Assert.assertTrue(cancelled);
	}
	
	@Test(priority = 10)
	public void verifyAddUrl() {
		String urlName = profilePage.addUrl();
		Assert.assertEquals(urlName, FrameworkConstants.getUrlvalue());
	}
	
	@Test(priority = 11)
	public void verifyHelpSearchResults() {
		List<WebElement> AllsearchResults = profilePage.searchForHelp();
		for (WebElement searchResult : AllsearchResults) {
			Assert.assertTrue(searchResult.getText().contains("Website"));
		}
	}
		
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
