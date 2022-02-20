package com.springboot.test;

import com.google.gson.Gson;
import com.springboot.entities.User;
import org.junit.Test;
import static io.restassured.RestAssured.given;
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

//    @Test
//    public void getUser(){
//        String endpoint = "http://localhost:8080/users/";
//        var response =
//                given().
//                        queryParam("id", 1).
//                        when().
//                        get(endpoint).
//                        then();
//        response.log().body();
//    }
//
//    @Test
//    public void createUser(){
//        String endpoint = "http://localhost:8080/users/";
//        String body = """
//                {
//                    "name": "Allan",
//                    "email": "a@gmail.com",
//                    "phone": "252342",
//                    "password": "789789676252342"
//                }
//                """;
//        var response = given().body(body).when().post(endpoint).then();
//        response.log().body();
//    }

}
