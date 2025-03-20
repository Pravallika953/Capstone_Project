package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;
import utility.Base;

public class ProductDetailsSteps extends Base
{
	private ProductDetailsPage productDetailsPage;
	
	@Given("User is in the search page")
	public void user_is_in_the_search_page() 
	{
		Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=product/search&sort=p.price&order=DESC&search=mac&category_id=18");
		productDetailsPage = new ProductDetailsPage(Base.getDriver());  
	    System.out.println("User is in the search page to verify the product");
	}
	@When("User verifying the product title and clicks")
	public void user_verifying_the_product_title_and_clicks() 
	{
	    productDetailsPage.verifyingProductTitle();
	}
	@When("User verifying the product description")
	public void user_verifying_the_product_description() 
	{
		productDetailsPage.verifyingProductDescription();
	}
	@When("User verifying the product price")
	public void user_verifying_the_product_price() 
	{
		productDetailsPage.verifyingProductPrice();
	}
	@When("User verifying the product image")
	public void user_verifying_the_product_image() 
	{
		productDetailsPage.verifyingProductImage();
	}
	@When("User verifying the product availability")
	public void user_verifying_the_product_availability() 
	{
		productDetailsPage.verifyingProdutctAvailability();
	}
	@When("User adding the product to wishlist")
	public void user_adding_the_product_to_wishlist() 
	{
		productDetailsPage.addProductToWishlist();
	}
	@When("User adding the product to cart")
	public void user_adding_the_product_to_cart() 
	{
		productDetailsPage.addProductToAddToCart();
	}
	@Then("User want to verify the cart")
	public void user_want_to_verify_the_cart()
	{
	   System.out.println("Prodocts has to be verify in the cart");
	}

}
