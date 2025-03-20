package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Base;

public class ProductDetailsPage extends Base{
	private WebDriver driver;
	private By productTitle = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a");
	private By productDescription = By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[1]/a");
	private By productPrice = By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");
	private By productImage = By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li[1]/a/img");
	private By productAvailability = By.xpath("//*[@id=\"content\"]/div/div[2]/ul[1]/li[4]");
	private By productWishlist = By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]");
	private By productQuantity = By.id("input-quantity");
	private By productAddToCart = By.id("button-cart");
	
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void verifyingProductTitle()
	{
		WebElement title = driver.findElement(productTitle);
		title.isDisplayed();
		title.click();
	}
	public void verifyingProductDescription()
	{
		driver.findElement(productDescription).isSelected();
	}
	public void verifyingProductPrice()
	{
		driver.findElement(productPrice).isDisplayed();
	}
	public void verifyingProductImage()
	{
		driver.findElement(productImage).isDisplayed();
	}
	public void verifyingProdutctAvailability()
	{
		driver.findElement(productAvailability).isDisplayed();
	}
	public void addProductToWishlist()
	{
		driver.findElement(productWishlist).click();
	}
	public void addProductToAddToCart()
	{
		WebElement quantity = driver.findElement(productQuantity);
		quantity.clear();
		quantity.sendKeys("2");
		driver.findElement(productAddToCart).click();
	}
}
