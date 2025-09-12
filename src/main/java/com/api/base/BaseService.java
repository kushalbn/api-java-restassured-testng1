package com.api.base;

import filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.jatin.swift.requestModels.LoginRequest;

import static io.restassured.RestAssured.given;

//This is like wrapper for restassured
//when the apis are more it becomes difficult to maintain at test level hence we write this class
public class BaseService {
    //we handle base URL, Response, create Request as all these are common for all the apis
    private static final String BASE_URL = "http://64.227.160.186:8080";
    //
    private RequestSpecification requestSpecification;

    //we need to run this filters only once and
    // it has to be run by any thread. So we put this in static block
    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization","Bearer "+token);
    }

    public Response getRequest(String endPoint){
        return requestSpecification.get(endPoint);
    }

    public Response postRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

}
