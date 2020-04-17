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


public class Api_CreditRating {

    @Test
    public void Post_Test1() {
        int cont = 0;
        try {
            for (int i = 1; i < 5; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****CreditRating - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","CreditRating/Create"+ Math.round(Math.random() * 20));
                requestParams.put("ratingCategoryId", Math.round(Math.random() * 61));

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
        int cont = 0;
        try {
            for (int i = 1; i < 10; i++) {
                cont++;

                ////Insert in Table
                System.out.println("***** CreateOrUpdateCreditRatingByRiskProfile - Create *****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/CreateOrUpdateCreditRatingByRiskProfile";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();
                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                try {

                    requestParams.put("id",Math.round(Math.random()*10));

                    JSONObject requestParams3 = new JSONObject();
                    requestParams3.put("value", Math.round(Math.random()*10));
                    requestParams3.put("id", Math.round(Math.random()*10));

                    ///Create Array
                    JSONArray jc = new JSONArray();
                    jc.add(requestParams3);
                    requestParams.put("riskProfiles", jc);

                }catch (JsonException e) {
                    e.printStackTrace();
                }
                array.add(requestParams);

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
    public void Post_Test3() {

                System.out.println("*****CreditRating - Get*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/Get";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                JSONObject requestParams = new JSONObject();

                    requestParams.put("id",Math.round(Math.random()*10));

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
    public void Get_Test4() {
        ///Select one date the tabla
        System.out.println("*****CreditRating - GetAll*****");
        Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/GetAll");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/GetAll ");

        //Body post Request
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
    public void Put_Test5() {

        System.out.println("*****CreditRating - Update*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","CreditRating_Update" + Math.round(Math.random()*20));
        requestParams.put("ratingCategoryId",Math.round(Math.random()*10));
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
    public void Delete_Test6() {

        System.out.println("*****CreditRating - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/CreditRating/Delete/?Id="+Math.round(Math.random()*10));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }


    }
