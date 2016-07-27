package com.orevan.serenity.steps.luma;

import com.orevan.serenity.pages.luma.LumaAccountPage;
import com.orevan.serenity.pages.luma.LumaBasePage;
import com.orevan.serenity.pages.luma.LumaCustomerPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 24/07/2016.
 */
public class RegisteredUserEntryPointSteps {

    @Steps
    LumaBasePage lumaBasePage;

    @Steps
    LumaCustomerPage lumaCustomerPage;

    @Steps
    LumaAccountPage lumaAccountPage;

    @And("^Trigger Registered \"([^\"]*)\" Action with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void triggerRegisteredActionWithAnd(String ruser, String rusername, String rpassword) throws Throwable {
        lumaBasePage.clickSignIn();
        lumaCustomerPage.customerLoginPage();
        lumaCustomerPage.signIn(rusername, rpassword);
    }

    @Then("^Luma Module for Registered \"([^\"]*)\" is available$")
    public void lumaModuleForRegisteredIsAvailable(String ruser) throws Throwable {
        lumaAccountPage.myAccountPage();
        Assert.assertTrue(lumaBasePage.registeredUser().contains(ruser));
        lumaBasePage.currentUserMode(ruser);
    }

    @But("^Luma Modules for Guest \"([^\"]*)\" is not available$")
    public void lumaModulesForGuestIsNotAvailable(String guser) throws Throwable {
        Assert.assertFalse(lumaBasePage.registeredUser().contains(guser));
        lumaBasePage.currentUserMode(guser);
    }

    @When("^User Trigger Sign Up Action with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" Details$")
    public void userTriggerSignUpActionWithDetails(String fname, String lname, String email, String pword, String cpword) throws Throwable {

    }

    @Then("^User \"([^\"]*)\" is active$")
    public void userIsActive(String ruser) throws Throwable {
        lumaAccountPage.myAccountDashboard(ruser);
        lumaBasePage.currentUserMode(ruser);
        lumaBasePage.clickSignOut();
    }

    @When("^User Trigger Sign Up Action with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" Details$")
    public void userTriggerSignUpActionWithDetails(String fname, String lname, String email, String pword) throws Throwable {
        lumaBasePage.clickCreateAccount();
        lumaCustomerPage.newCustomerPage();
        lumaCustomerPage.registerUser(fname, lname, email, pword);
    }

    @Then("^New User \"([^\"]*)\" is active$")
    public void newUserIsActive(String ruser) throws Throwable {
        lumaAccountPage.newAccountDashboard(ruser);
        lumaBasePage.currentUserMode(ruser);
        lumaBasePage.clickSignOut();
    }
}
