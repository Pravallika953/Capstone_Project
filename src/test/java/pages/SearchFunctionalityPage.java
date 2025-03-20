package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchFunctionalityPage {
	private WebDriver driver;
    private By searchBox = By.xpath("//*[@id=\"search\"]/input");
    private By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    private By categories = By.name("category_id");
    private By searchBtn = By.id("button-search");
    private By grid = By.id("grid-view");
    private By sortBy = By.id("input-sort");
    
    public SearchFunctionalityPage(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public void enterSearchTerm(String searchTerm)
    {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.sendKeys(searchTerm);
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
    
    public void selectSubCategories(String categoriesElement)
    {
    	Select dropDownElement = new Select(driver.findElement(categories));
    	dropDownElement.selectByVisibleText(categoriesElement);
    	driver.findElement(searchBtn).click();
    }
    
    public void view()
    {
    	driver.findElement(grid);
    }
    
    public void selectSortBy(String sortByElement)
    {
    	Select dropDownElement = new Select(driver.findElement(sortBy));
    	dropDownElement.selectByVisibleText(sortByElement);
    }
}
