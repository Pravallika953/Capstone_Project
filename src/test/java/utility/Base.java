package utility;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected static WebDriverWait wait;
    private static final String EXCEL_PATH = "C:\\Users\\prava\\24405_Pravallika\\Day-1\\Capstone_Project_Opencart\\src\\test\\resources\\Excel\\RegisterData.xlsx";
    public static WebDriver getDriver() 
    {
        return threadLocalDriver.get(); 
    }

    @BeforeClass
    @Parameters("browser")
    public static void setup(String browser) throws InterruptedException 
    {
        WebDriver driver;
        System.out.println("Setting up browser: " + browser);
//        Thread.sleep(5000);

        try {
            if (browser.equalsIgnoreCase("chrome")) 
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } 
            else if (browser.equalsIgnoreCase("edge")) 
            {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } 
            else
            {
                throw new IllegalArgumentException("Browser not supported: " + browser);
            }

            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com.gr");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            threadLocalDriver.set(driver); 
            wait.until(driver1 -> driver1.getCurrentUrl().equals("https://demo.opencart.com.gr/"));

            ExcelUtils.localExcel(EXCEL_PATH, "UserData");
            
            System.out.println("Driver initialized successfully.");
        } 
        catch (Exception e)
        {
            System.err.println("Error during setup: " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
            System.out.println("Driver closed.");
        }
    }
}
