package com.orevan.serenity.steps.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by tolaf on 13/01/2017.
 */
public class CRUDApiSteps {

    private Response response;
    private String username;
    private String password;
    private String key;

    @When("^User Retrieve and Item \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userRetrieveAndItemAnd(String type, String name) throws Throwable {
        given().when().get(type).then().statusCode(200);
        given().when().get("/garage").then().statusCode(200);
        given().when().get("").then().statusCode(200);

/*        given().when().get("http://www.google.com").then().statusCode(200);
        given().when().get("/garage").then().statusCode(200);
        given().when().get("").then().statusCode(200);
        given().when().get("/garage").then().body(containsString("Acme garage"));
        given().when().get("/garage").then().body("name",equalTo("Acme garage"));
        given().when().get("/garage").then().body("info.slots",equalTo(150)).body("info.status",equalTo("open"));
        given().when().get("/garage").then().body("name",equalTo("Acme garage")).body("info.slots",equalTo(150))
                .body("info.status",equalTo("open")).statusCode(200);*/
    }

    @Then("^\"([^\"]*)\" is Retrieved$")
    public void isRetrieved(String name) throws Throwable {
        assertEquals(response.toString(),name);
    }

    @When("^User create an Item \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userCreateAnItemAnd(String type, String name) throws Throwable {
        //Initializing Rest API's URL
        String APIUrl = "http://{API URL}";

        //Initializing payload or API body
        String APIBody = "{API Body}"; //e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"

        // Building request using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();

        //Setting API's body
        builder.setBody(APIBody);

        //Setting content type as application/json or application/xml
        builder.setContentType("application/json; charset=UTF-8");

        RequestSpecification requestSpec = builder.build();

        //Making post request with authentication, leave blank in case there are no credentials- basic("","")

        Response response = given().authentication().preemptive().basic(username, password)
                .spec(requestSpec).when().post(APIUrl);

        JSONObject JSONResponseBody = new JSONObject(response.body().asString());

        //Fetching the desired value of a parameter
        String result = JSONResponseBody.getString(key);

        //Asserting that result of Norway is Oslo
        Assert.assertEquals(result, "{expectedValue}");

        //
        Map<String,String> car = new HashMap<>();
        car.put("plateNumber", "xyx1111");
        car.put("brand", "audi");
        car.put("colour", "red");

        given()
                .contentType("application/json")
                .body(car)
                .when().post("/garage/slots").then()
                .statusCode(200);

        //
        //Map<String,String> car = new HashMap<>();
        car.put("plateNumber", "xyx1111");
        car.put("brand", "audi");
        car.put("colour", "red");

        given()
                .contentType("application/json")
                .body(car)
                .when().post("/garage/slots").then()
                .body("empty",equalTo(false))
                .body("position",lessThan(150));

        //
        //Car car = new Car();
        //car.setPlateNumber("xyx1111");
        //car.setBrand("audi");
        //car.setColour("red");

        given()
                .contentType("application/json")
                .body(car)
                .when().post("/garage/slots").then()
                .body("empty",equalTo(false))
                .body("position",lessThan(150));

        //
        //Car car = new Car();
        //car.setPlateNumber("xyx1111");
        //car.setBrand("audi");
        //car.setColour("red");

        //Slot slot = given()
               // .contentType("application/json")
               // .body(car)
               // .when().post("/garage/slots")
               // .as(Slot.class);

        //assertFalse(slot.isEmpty());
        //assertTrue(slot.getPosition() < 150);

        //
        given().contentType(ContentType.JSON).body("{\"key\": \"val\"}").
                when().post("url + resource").then().assertThat().statusCode(200).body("otherVal", equalTo("otherVal"));

        //
        Map<String, Object>  jsonAsMap = new HashMap<>();
        //map.put("key", "val");

        given().
                contentType(ContentType.JSON).
                body(jsonAsMap).
                when().
                post("url + resource").
                then().
                statusCode(200).
                body("otherVal", equalTo("otherVal"));

        //
        given().
                contentType(ContentType.JSON).
                body(new HashMap<String,Object>() {{
                  //  put("key1, "val1");
                      //      put("key2, "val2");
                      //              put("key3", asList("val3", "val4"));
                    put("nested", new HashMap<String,String>() {{
                        put("key4", "val4");
                        put("key5", "val5");
                    }});
                }}).
                when().
                post("url + resource").
                then().
                statusCode(200).
                body("otherVal", equalTo("otherVal"));

        //
        //MyDTO myDTO = new MyDTO(...);
        given().
                contentType(ContentType.JSON).
                //body(myDTO).
                when().
                post("url + resource").
                then().
                statusCode(200).
                body("otherVal", equalTo("otherVal"));

        //
        Response fieldResponse =  given ()
                //.header("Authorization", AuthrztionValue)
                //.header("X-App-Client-Id", XappClintIDvalue)
                .contentType("application/vnd.api+json")
                //.body(myRequest).with()

                .when()
                .post("dataPostUrl")

                .then()
                .assertThat()
                .log().ifError()
                .statusCode(200)
                .extract().response();

        Assert.assertFalse(fieldResponse.asString().contains("isError"));
    }

    @Then("^\"([^\"]*)\" is Created$")
    public void isCreated(String name) throws Throwable {

    }

    @When("^User update an Item \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userUpdateAnItemAnd(String type, String name) throws Throwable {

    }

    @Then("^\"([^\"]*)\" is Updated$")
    public void isUpdated(String name) throws Throwable {

    }

    @When("^User Delete an Item \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userDeleteAnItemAnd(String type, String name) throws Throwable {

        given().pathParam("slotID", 27).when().delete("/garage/slots/{slotID}").then().statusCode(200);

        //
        //Car car = new Car();
        //car.setPlateNumber("xyx1111");
        //car.setBrand("audi");
        //car.setColour("red");

        int positionTakenInGarage = given()
                .contentType("application/json")
               // .body(car)
                .when().post("/garage/slots").then()
                .body("empty",equalTo(false))
                .extract().path("position");

        given().pathParam("slotID", positionTakenInGarage)
                .when().delete("/garage/slots/{slotID}").then()
                .statusCode(200);
    }

    @Then("^\"([^\"]*)\" is Deleted$")
    public void isDeleted(String name) throws Throwable {

    }



/*    String myJson = "{\"name\":\"Jimi Hendrix\"}";
    RestAssured.baseURI  = "http://127.0.0.1:5984/restassured";

    response = given()
                .contentType("application/json").
    body("{\"name\":\"Jimi Hendrix\"}").
    when().
    post("");

    String body = response.getBody().asString();
        System.out.println(body);*/
}
