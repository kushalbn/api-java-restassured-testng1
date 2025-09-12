package com.jatin.swift;

import io.restassured.response.Response;
import models.jatin.swift.requestModels.LoginRequest;
import models.jatin.swift.responseModels.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.jatin.swift.AuthenticateService;

//add this annotation to perform things as written in TestListener.class
@Listeners(com.listeners.TestListener.class)
public class LoginApiTest4 {
    @Test(description = "implementation as per SOM + POJO + jackson lib")
    public void loginTest(){
        //Serialization
        LoginRequest loginRequest = new LoginRequest("klm123nop@gmail.com","klm123nop");
        AuthenticateService authenticateService = new AuthenticateService();
        Response response = authenticateService.login(loginRequest);
        System.out.println(response.asPrettyString());
        //Deserialization
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertTrue(loginResponse.getToken()!=null);
        Assert.assertEquals(loginResponse.getEmail(),"klm123nop@gmail.com");
    }
}
