package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Searchpage{
	
	public WebDriver driver;
	public AppiumDriver<MobileElement> appiumDriver;
	
	public Searchpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Searchpage(AppiumDriver<MobileElement> appiumDriver)
	{
		this.appiumDriver = appiumDriver;
	}
	
By cookiesAcceptButton=By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonAccept']");
By searchLinkClick = By.linkText("Search");
By searchField = By.xpath("//input[@id='edit-search']");
By searchButton = By.xpath("//input[@id='edit-submit-sitewide-search']");
By actualSearchResult = By.xpath("//h3[contains(@class,'field-content mb05')]//a[contains(text(),'Choosing a Law School')]");
By browserMenuButton =  By.xpath("//span[@class='wrapper-header__menu-toggle-bars']");

public WebElement getCookiesButton()
{
	return driver.findElement(cookiesAcceptButton);
}

public WebElement getSearchLink()
{
	return driver.findElement(searchLinkClick);
}

public WebElement getSearchField()
{
	return driver.findElement(searchField);
}

public WebElement getSearchButton()
{
	return driver.findElement(searchButton);
}

public WebElement getActualSearchResult()
{
	return driver.findElement(actualSearchResult);
}

public WebElement getCookiesButtonOnMobile()
{
	return appiumDriver.findElement(cookiesAcceptButton);
}

public WebElement getMobileBrowserMenuButton()
{
	return appiumDriver.findElement(browserMenuButton);
}

public WebElement getSearchLinkOnMobile()
{
	return appiumDriver.findElement(searchLinkClick);
}

public WebElement getSearchFieldOnMobile()
{
	return appiumDriver.findElement(searchField);
}

public WebElement getSearchButtonOnMobile()
{
	return appiumDriver.findElement(searchButton);
}

public WebElement getActualSearchResultOnMobile()
{
	return appiumDriver.findElement(actualSearchResult);
}

}
