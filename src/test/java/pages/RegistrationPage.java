package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Base;
public class RegistrationPage extends Base{
	private WebDriver driver;
	private By firstName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By eMail = By.name("email");
	private By telephone = By.name("telephone");
	private By password = By.name("password");
	private By confirmPassword = By.name("confirm");
	private By subscribe = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
	private By terms = By.name("agree");
	private By registerBtn = By.cssSelector("input[value='Continue']");
	private By loginBtn = By.cssSelector("input[value='Login']");
	private By logoutBtn = By.xpath("//*[@id=\"column-right\"]/div/a[13]");
	private By forgetPass = By.xpath("//*[@id=\"column-right\"]/div/a[3]");
	private By forgetContinue = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");
	
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void userNewAccount(String fname, String lname, String email, String phone, String pass, String confirmPass)
	{
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(eMail).sendKeys(email);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(confirmPass);
		
		driver.findElement(subscribe).click();
		driver.findElement(terms).click();
		driver.findElement(registerBtn).click();
	}
	public void login(String email, String pass)
	{
		driver.findElement(eMail).sendKeys(email);
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(loginBtn).click();
	}
	public void logout(String email)
	{
		driver.findElement(logoutBtn).click();
		driver.findElement(forgetPass).click();
		driver.findElement(eMail).sendKeys(email);
		driver.findElement(forgetContinue).click();
		
	}

}
