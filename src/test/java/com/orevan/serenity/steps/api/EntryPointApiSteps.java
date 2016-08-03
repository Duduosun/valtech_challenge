package com.orevan.serenity.steps.api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

/**
 * Created by tolaf on 03/08/2016.
 */
public class EntryPointApiSteps {

    private Response response;

    Integer scode;

    @Given("^Web API Entry Point$")
    public void webAPIEntryPoint() throws Throwable {
        given().contentType(ContentType.ANY);
    }

    @When("^User perform GET request for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userPerformGETRequestForAnd(String url, String endpoint) throws Throwable {
        response = when().get(url + endpoint);
        scode = response.statusCode();
    }

    @Then("^User Get \"([^\"]*)\" HTTP Status Code$")
    public void userGetHTTPStatusCode(Integer code) throws Throwable {
        Assert.assertEquals(scode, code);
    }
}