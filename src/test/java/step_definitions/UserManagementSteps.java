package step_definitions;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CraterDashboardPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	BrowserUtils utils = new BrowserUtils();
	CraterCommonPage commonPage = new CraterCommonPage();
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String useremail, String password) {
	 utils.sendKeysWithActionsClass(craterLogin.useremail, useremail);
	 utils.sendKeysWithActionsClass(craterLogin.password, password);
	}
	
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	   craterLogin.loginButton.click();
	}
	
	
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		utils.waitUntilElementVisible(dashboard.amountDueText);
		Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	}
	
	@Then("user quits the browser")
	public void user_quits_the_browser() {
	    Driver.quitDriver();
	}
	
	//invalid login
	
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String invalidUseremail, String invalidPassword) {
		 utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		 utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}
	@Then("an error message appears")
	public void an_error_message_appears() {
	    utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
	    Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	}
	@Then("user is not logged in")
	public void user_is_not_logged_in() {
	   Assert.assertTrue(craterLogin.loginButton.isDisplayed());
	   Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
	   
	}
	
	
	// invalid login scenario outline
	boolean useremailEmpty;
	boolean passwordEmpty;
	@When("user enters invalid Useremail {string} and Password {string}")
	public void user_enters_invalid_Useremail_and_Password(String invalidUseremail, String invalidPassword) {
		useremailEmpty = invalidUseremail.isBlank();
		passwordEmpty = invalidPassword.isBlank();
		
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}
	@Then("error message appears")
	public void error_message_appears() {
	   if(useremailEmpty || passwordEmpty) {
		   utils.waitUntilElementVisible(craterLogin.fieldRequired);
		 Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());  
	   }else {
		   utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
		   Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	   }
	}
	
	
	

}
