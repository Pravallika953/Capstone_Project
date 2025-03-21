package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShoppingCartPage;
import utility.Base;

public class ShoppingCartSteps extends Base
{
	private ShoppingCartPage shoppingCartPage;
	
	@Given("User is in the shopping cart page")
	public void user_is_in_the_shopping_cart_page() 
	{
		Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=checkout/cart");
		shoppingCartPage = new ShoppingCartPage(Base.getDriver());  
	}
	@When("User clicks on continue shopping and add items to cart")
	public void user_clicks_on_continue_shopping_and_add_items_to_cart() 
	{
		shoppingCartPage.inShoppingCartPage();
		shoppingCartPage.addingItemToCart();
	}
	@When("User clcik on the shopping cart page")
	public void user_clcik_on_the_shopping_cart_page() 
	{
		shoppingCartPage.redirectingToShoppingCartPage();
	}
	@When("User removing the item added")
	public void user_removing_the_item_added() throws InterruptedException 
	{
		Thread.sleep(3000);
		shoppingCartPage.removingItemInCart();
	}
	@When("User updating the items quantity in the cart")
	public void user_updating_the_items_quantity_in_the_cart() 
	{
		shoppingCartPage.updatingItemInCart();
	}
	@Then("User clicks on checkout")
	public void user_clicks_on_checkout()
	{
		shoppingCartPage.checkout();
	}


}
