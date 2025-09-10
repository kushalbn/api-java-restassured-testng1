package com.reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserApiTest {
    @Test(description = "Verify login")
    public void loginTest() {
//        RestAssured.baseURI = "http://64.227.160.186:8080";
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type", "application/json");
        RequestSpecification y1 = y.header("x-api-key", "reqres-free-v1");
        RequestSpecification z = y1.body("{\"name\": \"Virendar\",\"job\":\"Team lead\"}");
        Response response = z.post("/api/users");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),201);

    }

    @Test(description="method chaining")
    public void loginTest2() {
        //method chaining i.e. replacing x with what x is assigned value , y with its assigned value so on..
        Response response = RestAssured.given()
                .baseUri("https://reqres.in")
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{\"name\": \"Virendar\",\"job\":\"Team lead\"}")
                .post("/api/users");
        Assert.assertEquals(response.getStatusCode(),201);

    }



}
