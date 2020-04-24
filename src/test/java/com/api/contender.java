package com.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;



public class contender {


public void metodo200(RequestSpecification request,Response response){

    //Body post Request
    request.header("Content-Type", "application/json");

    String responseBody = response.getBody().asString();
    System.out.println("Response Body is: " + responseBody);

    int statusCode = response.getStatusCode();
    System.out.println("Status codigo is: " + statusCode);
    Assert.assertEquals(statusCode, 200);

    //status line verification
    String statusLine = response.getStatusLine();
    System.out.println("Status linea es:" + statusLine);
    Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
}

    public void metodo400(RequestSpecification request,Response response){

        //Body post Request
        request.header("Content-Type", "application/json");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status codigo is: " + statusCode);
        Assert.assertEquals(statusCode, 400);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status linea es:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 400 OK");
    }





}
