package com.orevan.serenity.steps.luma;

import com.orevan.serenity.pages.luma.LumaMiniCartPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 20/08/2016.
 */
public class MiniCartSteps {

    @Steps
    LumaMiniCartPage lumaMiniCartPage;

    @When("^User Trigger Mini Cart$")
    public void userTriggerMiniCart() throws Throwable {
        lumaMiniCartPage.openMiniCart();
    }

    @Then("^Mini Cart remain Open$")
    public void miniCartRemainOpen() throws Throwable {
        lumaMiniCartPage.emptyMiniCart();
    }

    @When("^User Close Mini Cart$")
    public void userCloseMiniCart() throws Throwable {
        lumaMiniCartPage.closeMiniCart();
    }

    @Then("^Mini Cart is Closed$")
    public void miniCartIsClosed() throws Throwable {
        lumaMiniCartPage.noMiniCart();
    }

    @Then("^Product \"([^\"]*)\" is Visible in Mini Cart$")
    public void productIsVisibleInMiniCart(String aproduct) throws Throwable {
        Assert.assertTrue(lumaMiniCartPage.miniCartProducts().contains(aproduct));
    }
}
