package stepDefinitions;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Searchpage;

public class SearchTestWeb extends Base {
	
  public static Searchpage spage;
  
  @Before
  public void before()
  {
	  
  }
  
  @After
  public void after()
  {
	  stopDriver();
  }
	
  @Given("Launch the browser {string}")
  public void launch_the_browser(String browserName) {
	  
     Base.getDriver(browserName);
  }
  
  @When("User navigate to the LSAC home page")
  public void user_navigate_to_the_LSAC_home_page() throws IOException {
    driver =Base.getUrl();
	spage = new Searchpage(driver);
	spage.getCookiesButton().click();
  }

	@Then("It should show the {string} in the search results")
	public void it_should_show_the_in_the_search_results(String string) {
		WebElement result = spage.getActualSearchResult();
		assertTrue(result.getText().contains(string));
	}
	
	@And("User search for {string} in the search bar clicking on Search link")
	public void user_search_for_in_the_search_bar_clicking_on_Search_link(String string) {
		
	    spage.getSearchLink().click();
	    spage.getSearchField().sendKeys(string);
	}
	
	@And("Click on the search button")
	public void click_on_the_search_button() {
		
	    spage.getSearchButton().click();
	 }
}
