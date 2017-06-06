package com.valtech.serenity.steps;

import com.valtech.serenity.pages.ValtechHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 05/06/2017.
 */
public class valtechStepDefinition {

    @Steps
    ValtechHomePage valtechHomePage;

    @Given("^Valtech HomePage$")
    public void valtechHomePage() throws Throwable {
        valtechHomePage.gotoValtech();

    }

    @When("^User Navigate to HomePage$")
    public void userNavigateToHomePage() throws Throwable {
        Assert.assertEquals(valtechHomePage.expectedValtechHomePage(), valtechHomePage.getTitle());
    }

    @Then("^Latest News section is displaying$")
    public void latestNewsSectionIsDisplaying() throws Throwable {
        valtechHomePage.verifyLatestNewsBanner();
    }

    @When("^User Navigate to \"([^\"]*)\" Pages via Top Navigation$")
    public void userNavigateToPagesViaTopNavigation(String page) throws Throwable {

    }

    @Then("^Header Tag in Page is displaying \"([^\"]*)\" Page Name$")
    public void HeaderTagInPageIsDisplayingPageName(String page) throws Throwable {

    }

    @When("^User Navigate to Contact Page$")
    public void userNavigateToContactPage() throws Throwable {

    }

    @And("^User Collate Valtech Offices$")
    public void userCollateValtechOffices() throws Throwable {

    }

    @Then("^Total Number of Valtech Office is returned$")
    public void totalNumberOfValtechOfficeIsReturned() throws Throwable {

    }
}
