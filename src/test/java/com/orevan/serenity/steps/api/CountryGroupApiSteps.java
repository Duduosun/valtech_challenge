package com.orevan.serenity.steps.api;

import com.jayway.restassured.http.ContentType;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by tolaf on 20/01/2017.
 */
public class CountryGroupApiSteps {

    private String baseURI;
    private Response response;
    private Integer scode;

    @Given("^GroupKT REST$")
    public void groupktREST() throws Throwable {
        given().contentType(String.valueOf(ContentType.ANY));
    }

    @When("^User trigger GroupKT get call on \"([^\"]*)\"$")
    public void userTriggerGroupKTGetCallOn(String webservice) throws Throwable {
        response = when().get(webservice);
    }

    @Then("^HTTP status code \"([^\"]*)\"$")
    public void httpStatusCode(Integer hcode) throws Throwable {
        scode = response.statusCode();
        assertEquals(scode,hcode);
    }

    @And("^Display all countries \"([^\"]*)\"$")
    public void displayAllCountries(String record) throws Throwable {
        String countryCollection = response.asString();
        assertTrue(countryCollection.contains(record));
    }
}
