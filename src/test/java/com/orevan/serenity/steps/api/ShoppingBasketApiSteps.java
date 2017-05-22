package com.orevan.serenity.steps.api;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static junit.framework.TestCase.*;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by tolaf on 16/01/2017.
 */
public class ShoppingBasketApiSteps {

    private Response empResp;
    private Response nonEmpResp;

    @Given("^Shopping basket$")
    public void shoppingBasket() throws Throwable {
        given().baseUri("http://localhost:9876/order");
    }

    @When("^User trigger get call to basket web service$")
    public void userTriggerGetCallToBasketWebService() throws Throwable {
        when().
                get("http://localhost:9876/order");
        empResp = when().get("http://localhost:9876/order");
    }

    @Then("^Shopping basket is empty$")
    public void shoppingBasketIsEmpty() throws Throwable {
        when().
                get("http://localhost:9876/order")
                .then().assertThat().
                body(equalTo("Your shopping cart is empty"));

        assertEquals(empResp.toString(),"Your shopping cart is empty");
        assertTrue(empResp.body().toString().equals("Your shopping cart is empty"));
    }

    @Given("^User add one item to basket$")
    public void userAddOneItemToBasket() throws Throwable {
        given().
                body("Ordering 1 item");
    }

    @When("^User trigger POST call to basket web service$")
    public void userTriggerPOSTCallToBasketWebService() throws Throwable {
        when().
                post("http://localhost:9876/order");

        nonEmpResp = when().post("http://localhost:9876/order");
    }

    @Then("^Shopping basket is not empty$")
    public void shoppingBasketIsNotEmpty() throws Throwable {
        when().
                post("http://localhost:9876/order").
                then().

                assertThat().
                body(equalTo("Item placed in shopping cart"));

        assertFalse(nonEmpResp.body().toString().equals("Your shopping cart is empty"));
        assertNotSame(nonEmpResp.toString(),"Your shopping cart is empty");
    }

    @And("^Item apppear in basket$")
    public void itemApppearInBasket() throws Throwable {
        when().
                post("http://localhost:9876/order").
                then().

                assertThat().
                body(equalTo("Item placed in shopping cart"));
    }
}