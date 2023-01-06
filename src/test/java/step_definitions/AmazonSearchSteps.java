package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;
import utils.Driver;
import utils.TestDataReader;

public class AmazonSearchSteps {
	
	AmazonPage amazonPage = new AmazonPage();
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
	Driver.getDriver().get(TestDataReader.getProperty("amazonUrl"));
	Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("I enter the search term {string}")
	public void i_enter_the_search_term(String items) {
	  amazonPage.searchBox.sendKeys(items);
	}
	@When("I click on search button")
	public void i_click_on_search_button() {
	  amazonPage.searchBtn.click();
	}
	@Then("I should see the search item {string} on search result page")
	public void i_should_see_the_search_item_on_search_result_page(String items) {
	//Assert.assertTrue(amazonPage.confirmSearchResult.getText().contains(items)); 
	// this will miss if we get some more text in the search results
		String originalText = amazonPage.confirmSearchResult.getText();
		//System.out.println(originalText.substring(1, items.length()+1));
		Assert.assertEquals(originalText.substring(1, items.length()+1), items); ;
	}
	@Then("the page title should contain the searched item {string}")
	public void the_page_title_should_contain_the_searched_item(String items) {
	
		//Assert.assertEquals(Driver.getDriver().getTitle().substring(13), items);
		String title = Driver.getDriver().getTitle();
	Assert.assertEquals(title.substring(title.length()-items.length()), items);
	}

}
