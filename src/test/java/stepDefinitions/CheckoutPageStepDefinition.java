package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextStepup;

public class CheckoutPageStepDefinition {

    //public String offerPageProductName;
    public PageObjects.CheckoutPage checkoutPage;
    TestContextStepup testContextStepup;

    public CheckoutPageStepDefinition(TestContextStepup testContextStepup) {
       this.testContextStepup = testContextStepup;
        this.checkoutPage = testContextStepup.pageObjectManager.getCheckoutPage();
    }




    @Then("verify user has ability to enter promo code and place the order")
    public void  verify_user_has_ability_enter_promo() throws InterruptedException {

        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());

    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout(String name) throws InterruptedException
    {

        checkoutPage.CheckoutItems();
        //Assertion to extract name from screen and compare with name
    }





}
