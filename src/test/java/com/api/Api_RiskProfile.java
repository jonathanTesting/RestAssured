package com.api;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.PUT;


public class Api_RiskProfile {

    @Test
    public void Post_Test1() {
        int cont = 0;
        try {
            for (int i = 1; i < 10; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****RiskProfile/Create - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/RiskProfile/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","RiskProfile/Create"+ Math.round(Math.random() * 20));
                requestParams.put("minimumValue", Math.round(Math.random() * 10));
                requestParams.put("maximumValue", Math.round(Math.random() * 100));

                httpRequest.header("Content-Type", "application/json");
                httpRequest.body(requestParams.toJSONString());

                Response response = httpRequest.request(Method.POST, "");

                String responseBody = response.getBody().asString();
                System.out.println("Response Body is: " + responseBody);

                int status = response.getStatusCode();
                System.out.println("Status code is: " + status);
                Assert.assertEquals(status, 200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Post_Test2() {

                System.out.println("***** RiskProfile - Get *****");
                RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/RiskProfile/Get";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                JSONObject requestParams = new JSONObject();

                    requestParams.put("id",1);

                httpRequest.header("Content-Type", "application/json");
                httpRequest.body(requestParams.toJSONString());

                System.out.println(requestParams);

                Response response = httpRequest.request(Method.POST, "");

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
    @Test
    public void GetALL_Test3() {
       ///Select one date the tabla
       System.out.println("*****RiskProfile - GetAll*****");
       Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/RiskProfile/GetAll");
       System.out.println("=================================================");
       System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/RiskProfile/GetAll ");

       //Body post Request
       RequestSpecification request = RestAssured.given();
       request.header("Content-Type", "application/json");

       RequestSpecification httpRequest = RestAssured.given();

       String responseBody = response.getBody().asString();
       System.out.println("Response Body is: " + responseBody);

       int statusCode = response.getStatusCode();
       System.out.println("Status codigo es: " + statusCode);
       Assert.assertEquals(statusCode, 200);

       //status line verification
       String statusLine = response.getStatusLine();
       System.out.println("Status linea es:" + statusLine);
       Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
   }
    @Test
    public void Put_Test4() {

        System.out.println("*****RiskProfile - Update*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/RiskProfile/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","RiskProfile_Update" + Math.round(Math.random()*20));
        requestParams.put("minimumValue",1000);
        requestParams.put("maximumValue",10000);
        requestParams.put("id",Math.round(Math.random()*10));

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(PUT, "");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);
        Assert.assertEquals(status, 200);

    }
    @Test
    public void Delete_Test5() {

        System.out.println("*****RiskProfile- Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/RiskProfile/Delete/?Id="+ Math.round(Math.random()*10));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }

    }
