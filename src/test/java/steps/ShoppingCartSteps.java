package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShoppingCartPage;
import utility.Base;

public class ShoppingCartSteps extends Base {
    private ShoppingCartPage shoppingCartPage;

    @Given("User is on the shopping cart page")
    public void user_is_on_the_shopping_cart_page() {
        Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=checkout/cart");
        shoppingCartPage = new ShoppingCartPage(Base.getDriver());
    }

    @When("User clicks on continue shopping and adds items to cart")
    public void user_clicks_on_continue_shopping_and_adds_items_to_cart() throws InterruptedException {
        Thread.sleep(2000);
        shoppingCartPage.inShoppingCartPage();
        shoppingCartPage.addingItemToCart();
    }

    @When("User clicks on the shopping cart page")
    public void user_clicks_on_the_shopping_cart_page() throws InterruptedException {
        Thread.sleep(2000);
        shoppingCartPage.redirectingToShoppingCartPage();
    }

    @When("User removes the added item")
    public void user_removes_the_added_item() throws InterruptedException {
        Thread.sleep(2000);
        shoppingCartPage.removingItemInCart();
    }

    @When("User updates the item quantity in the cart")
    public void user_updates_the_item_quantity_in_the_cart() throws InterruptedException {
        Thread.sleep(2000);
        shoppingCartPage.updatingItemInCart();
    }

    @Then("User proceeds to checkout")
    public void user_proceeds_to_checkout() throws InterruptedException {
        Thread.sleep(2000);
        shoppingCartPage.checkout();
    }
}
