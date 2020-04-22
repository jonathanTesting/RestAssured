package com.api;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.DELETE;


public class Validaciones {


    @Test
    public void test() {


        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");

        Response response = httpRequest.request(Method.GET, "/Delhi");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);
        Assert.assertEquals(status, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status linea es:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    }




