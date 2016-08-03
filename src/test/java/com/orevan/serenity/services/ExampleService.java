package com.orevan.serenity.services;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;

/**
 * Created by tolaf on 02/08/2016.
 */
public class ExampleService {

    private Response response;
    private String duluxBaseURL = "http://www.dulux.com.sg";
    private String colorEndPoint = "/en/api/products/colors";
    private String lumaBaseURI = "http://magento2-demo.nexcess.net";
    private String productEndPoint = "/api/rest/products/";
    private String thomasURI = "http://www.thomas-bayer.com";
    private String customerEndPoint = "/sqlrest/CUSTOMER/";

   /**
    @Step
    public void whenIAddThePetToTheStore(){

        for (Pet pet : pets) {
            int id = Math.abs(new Random().nextInt());
            Map<String, Object> jsonAsMap = new HashMap<>();
            jsonAsMap.put("id", id);
            jsonAsMap.put("name", pet.getName());
            jsonAsMap.put("status", pet.getStatus());
            jsonAsMap.put("photoUrls", new ArrayList<>(Arrays.asList()));

            given().contentType("application/json")
                    .content(jsonAsMap).log().body()
                    .baseUri("http://petstore.swagger.io")
                    .basePath("v2/pet")
                    .when().post();

            pet.setId(id);

        }
    }
    */

   public Integer getResponse(){
       return response.statusCode();
   }


    public void simpleExample(){
        //expect().body("body", contains("found")).when().get(lumaBaseURI);

        expect().body("body", contains("01234")).when().get(thomasURI);
    }


    public void checkHTTPStatus(){
        given().contentType(ContentType.JSON);
        response = when().get(thomasURI + customerEndPoint);
        Assert.assertEquals(200, response.statusCode());

        response = when().get(lumaBaseURI + productEndPoint);
        Assert.assertEquals(404, response.statusCode());

        //response = when().get(duluxBaseURL + colorEndPoint);
        //Assert.assertEquals(200, response.statusCode());
    }
}


    //List<String> colourNames = from(response.asString()).get("colors.name");
    //    Assert.assertTrue(colourNames.size() >= 0);
