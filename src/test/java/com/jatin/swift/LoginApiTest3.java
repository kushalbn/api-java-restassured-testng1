package com.jatin.swift;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.jatin.swift.AuthenticateService;

public class LoginApiTest3 {

    @Test(description = "implementation as per Service Object Model Framework(SOM)")
    public void loginTest(){
        AuthenticateService authenticateService = new AuthenticateService();
//        Response response = authenticateService.login("{\"username\": \"uday1234\",\"password\":\"uday1234\"}");
//        System.out.println(response.asPrettyString());

    }

}
