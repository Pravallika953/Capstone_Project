package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchFunctionalityPage;
import utility.Base;

public class SearchFunctionality extends Base
{
	private SearchFunctionalityPage searchFunctionalityPage;
	
	@Given("User in the search page")
	public void user_in_the_search_page() 
	{
		Base.getDriver().get("https://demo.opencart.com.gr");
		searchFunctionalityPage = new SearchFunctionalityPage(Base.getDriver());   
	}
	@When("User enters {string} in search bar and clicks the seach button")
	public void user_enters_in_search_bar_and_clicks_the_seach_button(String searchTerm)
	{
		searchFunctionalityPage.enterSearchTerm(searchTerm);
	}
	@When("User select {string} in sub search categories drop down list")
	public void user_select_in_sub_search_categories_drop_down_list(String categoriesElement)
	{
		searchFunctionalityPage.selectSubCategories(categoriesElement);
	}
	@When("User select the grid option")
	public void user_select_the_grid_option() 
	{
		searchFunctionalityPage.view();
	}
	@Then("User select {string} in sort by drop down list")
	public void user_select_in_sort_by_drop_down_list(String sortByElement) throws InterruptedException 
	{
		Thread.sleep(3000);
		searchFunctionalityPage.selectSortBy(sortByElement);
		Assert.assertTrue(Base.getDriver().getCurrentUrl().contains(""));
	}

}
