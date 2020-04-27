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

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test
    public void Post_test1() {
        int cont=1;
        try {
            for (int i = 1; i < 1; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****SpanishMessage - Create*****");
                RestAssured.baseURI = URL+"/api/services/app/SpanishMessage/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                    JSONObject requestParams = new JSONObject();

                    requestParams.put("moduleMessageId", Math.round(Math.random()*10));
                    requestParams.put("channelId", 98);
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
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/SpanishMessage/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/SpanishMessage/Get?Id=8389"));

    }

    @Test
    public void GetALL_test3() {
        System.out.println("***** SpanishMessage Get ALL*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/SpanishMessage/GetAll");


        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/SpanishMessage/GetAll"));
    }

    @Test
    public void PUT_test3() {

        System.out.println("*****SpanishMessage - Update*****");
        RestAssured.baseURI = URL+"/api/services/app/SpanishMessage/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams = new JSONObject();

        requestParams.put("moduleMessageId", 0);
        requestParams.put("text", "SpanishMessage_Update *es"+Math.round(Math.random()*29));
        requestParams.put("id", 8377);


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

        Response response =request.delete(URL+"/api/services/app/SpanishMessage/Delete?Id=" +  Math.round(Math.random()*9000));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }



}






