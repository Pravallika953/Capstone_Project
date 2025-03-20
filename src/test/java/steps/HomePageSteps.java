package steps;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utility.Base;

public class HomePageSteps {
    private HomePage homePage;

    @Given("User is on the Home Page")
    public void user_is_on_the_home_page() {
        Base.getDriver().get("https://demo.opencart.com.gr");
        homePage = new HomePage(Base.getDriver());
    }

    @When("User enters {string} in the search bar")
    public void user_enters_in_the_search_bar(String searchTerm) {
        homePage.enterSearchTerm(searchTerm);
    }

    @When("User clicks the search button")
    public void user_clicks_the_search_button() {
        homePage.clickSearchButton();
    }

    @Then("User redirected to the search page")
    public void user_redirected_to_the_search_page() {
        Assert.assertTrue(Base.getDriver().getCurrentUrl().contains("route=product/search"));
    }
}

