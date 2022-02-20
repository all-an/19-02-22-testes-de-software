package com.springboot.test;

import com.springboot.entities.Product;
import com.springboot.entities.User;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.mockito.internal.matchers.NotNull;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiTest {

    @Test
    public void getUsers() {
        // http://localhost:8080/users/
        String endpoint = "http://localhost:8080/users/";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getUser() {
        // http://localhost:8080/users/
        String endpoint = "http://localhost:8080/users/1";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    // TODO entender queryParam() abaixo
//    @Test
//    public void getUserWithParam(){
//        String endpoint = "http://localhost:8080/users/";
//
//        User user = (User) given().queryParam("id",1).when().get(endpoint).thenReturn().body();
//        var response =
//                given().
//                        queryParam("id", 1). //error
//                        when().
//                        get(endpoint).
//                        then();
//        System.out.println(user.toString());
//        System.out.println(response.toString());
//
//    }
//
    @Test
    public void createUser(){
        String endpoint = "http://localhost:8080/users/";
        User user = new User("Allan", "allan@gmail.com", "345345345", "98989898");
        var response = given().body(user).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void getUserAsserting() {
        // http://localhost:8080/users/
        String endpoint = "http://localhost:8080/users/1";
        given().when().get(endpoint).then().assertThat().statusCode(200);
    }

    @Test
    public void getUserAssertingResponseBody() {
        // http://localhost:8080/users/
        String endpoint = "http://localhost:8080/users/1";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getUserAssertingField() {
        // http://localhost:8080/users/
        String endpoint = "http://localhost:8080/users/1";
        given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("id", equalTo(1)).
                body("name", equalTo("Maria Brown")).
                body("email", equalTo("maria@gmail.com")).
                body("phone", equalTo("988888888")).
                body("password", equalTo("123456"));
    }

    @Test
    public void getUserVerifyingComplexBodies() {
        // http://localhost:8080/users/
        String endpoint = "http://localhost:8080/users/";
        given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("size()", greaterThan(0));
    }

    @Test
    public void getUserVerifyingNotNull() {
        String endpoint = "http://localhost:8080/users/";
        given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("name", everyItem(notNullValue()));
    }

    @Test
    public void verifyingHeader() {
        String endpoint = "http://localhost:8080/users/";
        given().when().get(endpoint).then().
                assertThat().statusCode(200).
                header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void getDeserializedBody() {
        String endpoint = "http://localhost:8080/users/1";
        given().when().get(endpoint).as(User.class);
    }

    @Test
    public void getDeserializedBodyFields() {
        String endpoint = "http://localhost:8080/users/1";
        User user = new User(
                1L,
                "Allan Pereira Abrahão",
                "allan8tech@gmail.com",
                "988888888",
                "123456"
        );
        User actualUser = given().when().get(endpoint).as(User.class);
        assertThat(actualUser, samePropertyValuesAs(user));
    }
}
