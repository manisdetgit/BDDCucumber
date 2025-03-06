package utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextStepup {
    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;


    public TestContextStepup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
