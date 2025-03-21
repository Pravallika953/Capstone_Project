package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utility.Base;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"steps"}, 
    plugin = {
        "pretty",
        "json:target/cucumber-reports-json/Cucumber.json"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(@Optional("chrome") String browser) throws InterruptedException {
        System.out.println("Running tests on: " + browser);
        Base.setup(browser);
    }

    @AfterClass
    public void afterClass() 
    {
        Base.tearDown(); 
    }
}
