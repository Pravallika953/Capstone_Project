package steps;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utility.Base;
import utility.ExcelUtils;

public class RegistrationSteps extends Base
{
	private RegistrationPage registrationPage;
    private static final String EXCEL_PATH = "C:\\Users\\prava\\24405_Pravallika\\Day-1\\Capstone_Project_Opencart\\src\\test\\resources\\Excel\\\\RegisterData.xlsx";

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() throws InterruptedException 
    {
        Base.getDriver().manage().deleteAllCookies();
        ((JavascriptExecutor) Base.getDriver()).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) Base.getDriver()).executeScript("window.sessionStorage.clear();");
        Base.getDriver().navigate().refresh(); 

        Thread.sleep(3000);
        Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=account/register");

       
        if (Base.getDriver().getCurrentUrl().contains("route=account/account")) {
            System.out.println("Redirected to account page instead of registration. Retrying...");
            Base.getDriver().manage().deleteAllCookies();
            Thread.sleep(2000);
            Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=account/register");
        }

        registrationPage = new RegistrationPage(Base.getDriver());
        ExcelUtils.localExcel(EXCEL_PATH, "UserData");
    }

    @When("User enters registration details from Excel row {int}")
    public void user_enters_registration_details(int rowNum) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("123");
        String fname = ExcelUtils.getCellData(rowNum, 0);
        String lname = ExcelUtils.getCellData(rowNum, 1);
        String email = ExcelUtils.getCellData(rowNum, 2);
        String phone = ExcelUtils.getCellData(rowNum, 3);
        String pass = ExcelUtils.getCellData(rowNum, 4);
        String confirmPass = ExcelUtils.getCellData(rowNum, 5);
        System.out.println("456");
        registrationPage.userNewAccount(fname, lname, email, phone, pass, confirmPass);
    }

    @Then("User created the account successfully")
    public void user_created_the_account_successfully() {
        System.out.println("Account is created successfully");
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        Base.getDriver().manage().deleteAllCookies();
        ((JavascriptExecutor) Base.getDriver()).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) Base.getDriver()).executeScript("window.sessionStorage.clear();");
        Base.getDriver().navigate().refresh();

        Thread.sleep(3000);
        Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=account/login");

        registrationPage = new RegistrationPage(Base.getDriver());
    }

    @When("User enters login details from Excel row {int}")
    public void user_enters_login_details(int rowNum) throws InterruptedException {
        Thread.sleep(3000);
        String email = ExcelUtils.getCellData(rowNum, 2);
        String pass = ExcelUtils.getCellData(rowNum, 4);
        registrationPage.login(email, pass);
        
    }
    
    @When("User recovering password from Excel row {int}")
    public void user_recovering_password_from_excel_row(int rowNum) throws InterruptedException
    {
    	Base.getDriver().manage().deleteAllCookies();
        ((JavascriptExecutor) Base.getDriver()).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) Base.getDriver()).executeScript("window.sessionStorage.clear();");
        Base.getDriver().navigate().refresh();

        Thread.sleep(3000);
        
        Base.getDriver().get("https://demo.opencart.com.gr/index.php?route=account/login");

        registrationPage = new RegistrationPage(Base.getDriver());
        String email = ExcelUtils.getCellData(rowNum, 2);
        registrationPage.logout(email);
    }

    @Then("User redirects to the homepage")
    public void user_redirects_to_the_homepage() {
        System.out.println("User is in the homepage");
    }

}
