package com.jatin.swift;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.jatin.swift.AuthenticateService;

public class ForgotPasswordApiTest {
    @Test(description = "sending as string parameter instead of using pojo forrequest body")
    public void forgotPasswordTest(){
        AuthenticateService authenticateService = new AuthenticateService();
        Response response = authenticateService.forgotPassword("klm123nop@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
