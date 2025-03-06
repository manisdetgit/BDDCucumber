package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextStepup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextStepup testContextStepup;
    public Hooks(TestContextStepup testContextStepup){
        this.testContextStepup = testContextStepup;
    }
    @After
    public void afterScenario() throws IOException {
        testContextStepup.testBase.webDriverManager().quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException
    {
        WebDriver driver =testContextStepup.testBase.webDriverManager();
        if(scenario.isFailed())
        {
            //screenshot
            File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");

        }

    }
}
