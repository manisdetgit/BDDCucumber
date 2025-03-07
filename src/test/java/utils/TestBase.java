package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;



    public WebDriver webDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");

        if (driver == null) {
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");  // Optional, sometimes helps with stability in headless mode
                options.addArguments("--window-size=1920x1080"); // Optional, set window size for headless mode

                // Initialize WebDriver in headless mode
                 driver = new ChromeDriver(options);
               // driver = new ChromeDriver();
            } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            driver.get(url);


        }return driver;
    }



}
