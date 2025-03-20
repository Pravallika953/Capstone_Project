package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Base;

public class HomePage extends Base{
	private WebDriver driver;
    private By searchBox = By.xpath("//*[@id=\"search\"]/input");
    private By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterSearchTerm(String searchTerm) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.sendKeys(searchTerm);
    }
    
    public void clickSearchButton() {
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
	
}