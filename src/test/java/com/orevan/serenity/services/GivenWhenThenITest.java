package com.orevan.serenity.services;

/**
 * Created by tolaf on 03/08/2016.
 */
public class GivenWhenThenITest {
/**
    @Test
    public void
    simple_given_when_then_works() {
        given().
                param("firstName", "John").
                param("lastName", "Doe").
                when().
                get("/greet").
                then().
                statusCode(200).
                body("greeting", equalTo("Greetings John Doe"));
    }

    @Test public void
    given_when_then_works_with_assert_that_and_and() {
        given().
                param("firstName", "John").
                param("lastName", "Doe").
                when().
                get("/greet").
                then().
                assertThat().
                statusCode(200).
                and().
                body("greeting", equalTo("Greetings John Doe"));
    }

    @Test public void
    given_when_then_works_with_xpath_assertions() {
        given().
                parameters("firstName", "John", "lastName", "Doe").
        when().
                get("/greetXML").
        then().
                body(hasXPath("/greeting/firstName[text()='John']"));
    }

    @Test public void
    given_when_then_works_with_multiple_body_assertions() {
        given().
                parameters("firstName", "John", "lastName", "Doe").
                when().
                get("/greetXML").
                then().
                body(containsString("greeting")).
                body(containsString("John"));
    }
*/
}