package stepDefinitions;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TestContextStepup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    public String offerPageProductName;
    public OffersPage offersPage;

    TestContextStepup testContextStepup;


    public OfferPageStepDefinition(TestContextStepup testContextStepup) {
        this.testContextStepup = testContextStepup;
        offersPage = testContextStepup.pageObjectManager.getOffersPage();
    }
    @Then("^user searched for (.+) shortname in offers page$")
    public void userSearchedForShortnameInOffersPage(String shortname) {
        switchToOffersPage();

        offersPage.searchItem(shortname);
        offerPageProductName =  offersPage.getProductName();
    }

    public void switchToOffersPage(){
        LandingPage landingPage = testContextStepup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
       testContextStepup.genericUtils.switchWindowToChild();
    }

   
    @Then("validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(testContextStepup.landingPageProductName, offerPageProductName);

    }
}
