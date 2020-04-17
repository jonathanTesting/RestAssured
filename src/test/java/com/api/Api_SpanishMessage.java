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

public class Api_SpanishMessage {

    @Test
    public void Post_test1() {
        int cont=1;
        try {
            for (int i = 1; i < 5; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****SpanishMessage - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                    JSONObject requestParams = new JSONObject();

                    requestParams.put("moduleMessageId", Math.round(Math.random()*10));
                    requestParams.put("text", "SpanishMessage_Create" + Math.round(Math.random()*10));

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
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Get_Test2() {

        System.out.println("***** SpanishMessage - Get*****");
        Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/Get?Id="+Math.round(Math.random()*10));
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/Get");

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
    public void Get_test3() {
        System.out.println("***** SpanishMessage Get ALL*****");
        Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/GetAll");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/GetAll");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        RequestSpecification httpRequest=RestAssured.given();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int statusCode=response.getStatusCode();
        System.out.println("Status codigo es: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine=response.getStatusLine();
        System.out.println("Status linea es:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
    @Test
    public void PUT_test3() {

        System.out.println("*****SpanishMessage - Update*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams = new JSONObject();

        requestParams.put("moduleMessageId", 0);
        requestParams.put("text", "SpanishMessage_Update *es"+Math.round(Math.random()*29));
        requestParams.put("id", 4);


        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        System.out.println(requestParams);

        Response response = httpRequest.request(PUT, "");

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
    public void Delete_test4() {

        System.out.println("*****SpanishMessage - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/SpanishMessage/Delete?Id=" +  Math.round(Math.random()*9));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }



}






