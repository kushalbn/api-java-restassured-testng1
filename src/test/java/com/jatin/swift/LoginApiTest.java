package com.jatin.swift;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginApiTest {
    @Test(description = "Verify login")
    public void loginTest() {
//        RestAssured.baseURI = "http://64.227.160.186:8080";
        RestAssured.baseURI = "https://swift.techwithjatin.com";
        RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type", "application/json");
        RequestSpecification z = y.body("{\"username\": \"uday1234\",\"password\":\"uday1234\"}");
        Response response = z.post("/api/auth/login");
    }


}


