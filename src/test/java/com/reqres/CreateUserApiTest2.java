package com.reqres;

//whenever we are using class having only static variables and methods
//it is better to do static import of class as it increases the readability
//Restassured has all its methods and variables as static, hence we will do static import.
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserApiTest2 {
    @Test(description="static import")
    public void loginTest3() {
        //method chaining i.e. replacing x with what x is assigned value , y with its assigned value so on..
        Response response = given()
                .baseUri("https://reqres.in")
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{\"name\": \"Virendar\",\"job\":\"Team lead\"}")
                .post("/api/users");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

}
