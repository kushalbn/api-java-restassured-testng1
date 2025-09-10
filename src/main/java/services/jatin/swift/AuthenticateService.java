package services.jatin.swift;

import com.api.base.BaseService;
import io.restassured.response.Response;
import models.jatin.swift.requestModels.LoginRequest;

import java.util.HashMap;

public class AuthenticateService extends BaseService {
    private static final String BASE_PATH="/api/auth";

    public Response login(LoginRequest payload){
        return postRequest(payload,BASE_PATH+"/login");
    }

    //since payload has only one value to be sent and we know that payload in future will not change
    //with respect to number of values to be sent will not increase, its better to send that single value
    //as parameter directly rather than creating new class for that request
    public Response forgotPassword(String emailAddress){
        HashMap<String,String> payload = new HashMap<String,String>();
        payload.put("email", emailAddress);
        return postRequest(payload,BASE_PATH+"/forgot-password");
    }
}
