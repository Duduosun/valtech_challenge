package com.orevan.serenity.steps.api;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by tolaf on 20/01/2017.
 */
public class BookStepDefinitions {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";


    @Given("^a book exists with an isbn of (\\d+)$")
    public void aBookExistsWithAnIsbnOf(String isbn) throws Throwable {
        request = given().param("q", "isbn:" + isbn);
    }

    @When("^a user retrieves the book by isbn$")
    public void aUserRetrievesTheBookByIsbn() throws Throwable {
        response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("^the status code is (\\d+)$")
    public void theStatusCodeIs(int statusCode) throws Throwable {
        json = response.then().statusCode(statusCode);
    }

    @And("^response includes the following$")
    public void responseIncludesTheFollowing(Map<String, String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @And("^response includes the following in any order$")
            public void responseIncludesTheFollowingInAnyOrder (Map < String, String > responseFields) throws Throwable
            {
                for (Map.Entry<String, String> field : responseFields.entrySet()) {
                    if (StringUtils.isNumeric(field.getValue())) {
                        json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
                    } else {
                        json.body(field.getKey(), containsInAnyOrder(field.getValue()));
                    }
                }

            }
        }