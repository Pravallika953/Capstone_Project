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
	public void user_is_in_the_search_page() throws InterruptedException 
	{
		Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=product/search&sort=p.price&order=DESC&search=mac&category_id=18");
		Thread.sleep(2000);
		productDetailsPage = new ProductDetailsPage(Base.getDriver());  
	    System.out.println("User is in the search page to verify the product");
	}
	
	@When("User verifying the product title and clicks")
	public void user_verifying_the_product_title_and_clicks()
	{
	    productDetailsPage.verifyingProductTitle();
	}
	
	@When("User verifying the product description")
	public void user_verifying_the_product_description() throws InterruptedException 
	{
		Thread.sleep(2000);
		productDetailsPage.verifyingProductDescription();
	}
	
	@When("User verifying the product price")
	public void user_verifying_the_product_price() throws InterruptedException 
	{
		Thread.sleep(2000);
		productDetailsPage.verifyingProductPrice();
	}
	
	@When("User verifying the product image")
	public void user_verifying_the_product_image() throws InterruptedException 
	{
		Thread.sleep(2000);
		productDetailsPage.verifyingProductImage();
	}
	
	@When("User verifying the product availability")
	public void user_verifying_the_product_availability() throws InterruptedException 
	{
		Thread.sleep(2000);
		productDetailsPage.verifyingProdutctAvailability();
	}
	
	@When("User adding the product to wishlist")
	public void user_adding_the_product_to_wishlist() throws InterruptedException 
	{
		Thread.sleep(2000);
		productDetailsPage.addProductToWishlist();
	}
	
	@When("User adding the product to cart")
	public void user_adding_the_product_to_cart() throws InterruptedException 
	{
		Thread.sleep(2000);
		productDetailsPage.addProductToAddToCart();
	}
	
	@Then("User want to verify the cart")
	public void user_want_to_verify_the_cart() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("Products has to be verify in the cart");
	}

}
