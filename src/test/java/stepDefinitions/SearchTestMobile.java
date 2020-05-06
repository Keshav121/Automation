package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Searchpage;

public class SearchTestMobile extends Base {
	
	public static Searchpage spage;
	public static AppiumDriver<MobileElement> driver;
	
	@Given("Launch the browser on mobile device {string}")
    public void launch_the_browser_on_mobile_device_something(String mobilebrowser) throws IOException
	{
		service =startServer();
		driver=capabilities(mobilebrowser);    
		
	}
	
	@When("User navigate to the LSAC home page on mobile")
	public void user_navigate_to_the_LSAC_home_page_on_mobile() throws IOException, InterruptedException 
	{
	    driver =getUrlOnMobile();
	    spage = new Searchpage(driver);
		spage.getCookiesButtonOnMobile().click();
	}
	
	 @Then("It should show the {string} in the search results on mobile")
	 public void it_should_show_the_something_in_the_search_results_on_mobile(String string)
	    {
		   WebElement result = spage.getActualSearchResultOnMobile();
		   assertTrue(result.getText().contains(string));
		   service.stop();
	    }

	@And("Click on the menu toggle bar")
	public void click_on_the_menu_toggle_bar() 
	{
			spage.getMobileBrowserMenuButton().click();		
	}
		
	@And("User search for {string} in the search bar on mobile")
	public void user_search_for_something_in_the_search_bar_on_mobile(String string)
	{
			spage.getSearchLinkOnMobile().click();
		    spage.getSearchFieldOnMobile().sendKeys(string);
	}
		
	@And("Click on the search button on mobile")
	public void click_on_the_search_button_on_mobile()
	  {
		  spage.getSearchButtonOnMobile().click();

	  }
		
	@And("Perform the scroll action on the view")
	public void perform_the_scroll_action_on_the_view() throws Throwable 
	{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,280)","");
	}

}
