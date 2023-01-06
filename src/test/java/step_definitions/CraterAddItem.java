package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterItemsPage;
import utils.Driver;

public class CraterAddItem {
	
	CraterDashboardPage dashboardPage = new CraterDashboardPage();
	CraterItemsPage itemsPage = new CraterItemsPage();
	
	@Given("user navigates to Items tab")
	public void user_navigates_to_items_tab() {
	dashboardPage.Items.click();
	Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("user clicks on the Add Item button")
	public void user_clicks_on_the_add_item_button() {
	itemsPage.addItemButton.click();
	}
	@When("user should be on item input page")
	public void user_should_be_on_item_input_page() {
	   Assert.assertTrue(itemsPage.newItemHeaderText.isDisplayed());
	}
//	@When("user provides item information name {String} and price {String} and unit {String} and description {String}")
//	public void user_provides_item_information_name_and_price_and_unit_and_description(String name, String price, String unit, String description) {
//	itemsPage.addItemNameField.sendKeys(name);
//	itemsPage.addItemPriceField.sendKeys(price);
//	itemsPage.addItemUnitField.sendKeys(unit);;
//	itemsPage.pc_unit.click();
//	itemsPage.addItemDescription.sendKeys(description);
//	}
	@When("user provides item information name {string} and price {string} and unit {string} and description {string}")
	public void user_provides_item_information_name_and_price_and_unit_and_description(String name, String price, String unit, String description) {
		itemsPage.addItemNameField.sendKeys(name);
		itemsPage.addItemPriceField.sendKeys(price);
		itemsPage.addItemUnitField.sendKeys(unit, Keys.ENTER);
		//itemsPage.pc_unit.click();
		itemsPage.addItemDescription.sendKeys(description);
	}
	@When("click Save Item button")
	public void click_save_item_button() {
	  itemsPage.saveItemButton.click();
	}
//	@Then("the Item is added to the Item list table")
//	public void the_item_is_added_to_the_item_list_table() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

}
