package com.orevan.serenity.steps.luma;

import com.orevan.serenity.pages.luma.LumaCatPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by tolaf on 26/07/2016.
 */
public class ProductSteps {

    LumaCatPage lumaCatPage;

    @When("^User Trigger Top Level \"([^\"]*)\" then Sub Category Level \"([^\"]*)\"$")
    public void userTriggerTopLevelThenSubCategoryLevel(String tcat, String scat) throws Throwable {
        lumaCatPage.clickSecondCat(tcat, scat);
    }

    @Then("^Simple Products \"([^\"]*)\" are Displayed in Grid View$")
    public void simpleProductsAreDisplayedInGridView(String sproduct) throws Throwable {

    }

    @Then("^Configurable Products \"([^\"]*)\" are Displayed in Grid View$")
    public void configurableProductsAreDisplayedInGridView(String cproduct) throws Throwable {

    }

    @When("^User Click Switch View CTA$")
    public void userClickSwitchViewCTA() throws Throwable {

    }

    @Then("^Simple Products \"([^\"]*)\" are Displayed in List View$")
    public void simpleProductsAreDisplayedInListView(String sproduct) throws Throwable {

    }

    @Then("^Configurable Products \"([^\"]*)\" are Displayed in List View$")
    public void configurableProductsAreDisplayedInListView(String cproduct) throws Throwable {

    }


}
