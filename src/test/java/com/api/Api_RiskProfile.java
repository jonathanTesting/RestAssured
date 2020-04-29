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
        contender URL = new contender();
        int cont = 0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****RiskProfile/Create - Create*****");
                RestAssured.baseURI = URL.metodo()+"/api/services/app/RiskProfile/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","RiskProfile/Create"+ Math.round(Math.random() * 20));
                requestParams.put("minimumValue", Math.round(Math.random() * 10));
                requestParams.put("maximumValue", Math.round(Math.random() * 100));
                requestParams.put("description", "Tests");
                requestParams.put("code", "Test"+Math.round(Math.random() * 100));

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
    public void Get_Test2() {
        contender URL = new contender();

        System.out.println("***** RiskProfile - Get *****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  "+URL.metodo()+"/api/services/app/RiskProfile/Get");


        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/RiskProfile/Get?Id=4"));

    }

    @Test
    public void GetALL_Test3() {
       ///Select one date the tabla
        contender URL = new contender();
       System.out.println("*****RiskProfile - GetAll*****");
       System.out.println("=================================================");
       System.out.println("La URL a validar:  "+URL.metodo()+"/api/services/app/RiskProfile/GetAll ");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/RiskProfile/GetAll?ChannelId="));

   }

    @Test
    public void Put_Test4() {
        contender URL = new contender();

        System.out.println("*****RiskProfile - Update*****");
        RestAssured.baseURI = URL.metodo()+"/api/services/app/RiskProfile/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","RiskProfile_Update" + Math.round(Math.random()*20));
        requestParams.put("minimumValue",1000);
        requestParams.put("maximumValue",10000);
        requestParams.put("id",5);

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
        contender URL = new contender();

        System.out.println("*****RiskProfile- Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL.metodo()+"/api/services/app/RiskProfile/Delete/?Id=4");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }

    }
