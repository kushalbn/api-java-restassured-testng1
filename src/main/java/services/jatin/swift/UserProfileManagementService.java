package services.jatin.swift;

import com.api.base.BaseService;
import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
    private final static String BASE_PATH = "/api/users";

    public Response getProfile(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"/profile");
    }
}
