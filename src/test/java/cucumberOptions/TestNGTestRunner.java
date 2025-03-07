package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features",
glue = "stepDefinitions",
monochrome = true, tags = "@OffersPage",
        plugin= {"html:target/cucumber-reports","html:target/cucumber.html", "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        },
dryRun = false)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

  /*  @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }*/


}
