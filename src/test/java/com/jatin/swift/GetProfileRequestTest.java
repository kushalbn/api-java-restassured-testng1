package com.jatin.swift;

import io.restassured.response.Response;
import models.jatin.swift.requestModels.LoginRequest;
import models.jatin.swift.responseModels.LoginResponse;
import models.jatin.swift.responseModels.UserProfileResponse;
import org.testng.annotations.Test;
import services.jatin.swift.AuthenticateService;
import services.jatin.swift.UserProfileManagementService;

public class GetProfileRequestTest {
    @Test(description="passing value from one api to another")
    public void GetProfileInfoTest(){
        LoginRequest loginRequest = new LoginRequest("klm123nop@gmail.com","klm123nop");
        AuthenticateService authenticateService = new AuthenticateService();
        Response response = authenticateService.login(loginRequest);
        LoginResponse loginResponse= response.as(LoginResponse.class);
        String token = loginResponse.getToken();
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getusername());
    }
}
