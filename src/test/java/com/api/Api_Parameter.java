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


public class Api_Parameter {

    @Test
    public void Post_Test1() {
        int cont = 0;
        try {
            for (int i = 0; i < 3; i++) {
                cont++;

                System.out.println("*****Parameter - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("code","JJR"+ Math.round(Math.random() * 20));
                requestParams.put("description","Parameter/Create"+ Math.round(Math.random() * 20));
                requestParams.put("value","Test");

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

    @Test//Pendiente
    public void Get_Test2() {

        System.out.println("***** Parameter - Get*****");
        Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/Get?Id="+Math.round(Math.random()*6));
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/Get");

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
    public void GetALL_Test2() {
       ///Select one date the tabla
       System.out.println("*****RiskLevel - GetAll*****");
       Response response = RestAssured.get("https://api/services/app/Parameter/GetAll");
       System.out.println("=================================================");
       System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/GetAll ");

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
    public void Put_Test3() {

        System.out.println("***** Parameter - Update*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("code","JJR"+ Math.round(Math.random() * 20));
        requestParams.put("description","Parameter/Update"+ Math.round(Math.random() * 20));
        requestParams.put("value","Test");
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
    public void Delete_Test4() {

        System.out.println("***** Parameter - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/Delete/?Id="+ Math.round(Math.random()*10));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
    
    }
