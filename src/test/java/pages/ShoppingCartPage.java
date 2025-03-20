package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Base;

public class ShoppingCartPage extends Base{
private WebDriver driver;
	
	private By shoppingCartPage = By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a");
	private By continueShopping = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/a");
	private By addItem = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]");
	private By removingItem = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]");
	private By updatingItemQuantities = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input");
	private By updateBtn = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]");
	private By checkout = By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a");
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void inShoppingCartPage()
	{
		driver.navigate().refresh();
	}
	public void addingItemToCart()
	{
		driver.findElement(continueShopping).click();
		driver.findElement(addItem).click();
	}
	public void redirectingToShoppingCartPage()
	{
		driver.findElement(shoppingCartPage).click();
		driver.navigate().refresh();
	}
	public void removingItemInCart()
	{
		driver.findElement(removingItem).click();
		driver.navigate().refresh();
	}
	public void updatingItemInCart()
	{
		WebElement update = driver.findElement(updatingItemQuantities);
		update.clear();
		update.sendKeys("3");
		driver.findElement(updateBtn).click();
	}
	public void checkout()
	{
		driver.findElement(checkout).click();
	}

}
