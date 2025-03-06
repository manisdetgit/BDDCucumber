package stepDefinitions;

import PageObjects.LandingPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;
import utils.TestContextStepup;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {

    TestContextStepup testContextStepup;
    public  LandingPage landingPage;


    public LandingPageStepDefinition(TestContextStepup testContextStepup) {
        this.testContextStepup = testContextStepup;
        landingPage = testContextStepup.pageObjectManager.getLandingPage();

    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));


    }


    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortname) throws InterruptedException {
        landingPage.searchItem(shortname);
       Thread.sleep(2000);
        testContextStepup.landingPageProductName = landingPage.getProductName().split("-")[0].trim() ;
        System.out.println(testContextStepup.landingPageProductName +" is extracted from Home page");
    }

    @When("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }


}
