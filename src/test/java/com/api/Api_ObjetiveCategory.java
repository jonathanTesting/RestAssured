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

import static io.restassured.http.Method.*;

public class Api_ObjetiveCategory {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test
    public void Post_test1() {
        int cont = 0;
        try {
            for (int i = 1; i < 10; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****Objective Category - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/ObjectiveCategory/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                try {

                    requestParams.put("name", "ObjectiveCategory - Create" + Math.round(Math.random() * 20));


                    JSONArray ja = new JSONArray();
                    requestParams.put("channel", ja);

                } catch (JsonException e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void POST_Test2() {
        System.out.println("*****CreateObjectiveCategoryByCalculationVariable - Create*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/ObjectiveCategory/CreateObjectiveCategoryByChannel";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Reques
        //
        JSONArray array = new JSONArray();
        JSONObject requestParams = new JSONObject();
        requestParams.put("objectiveCategoryId", Math.round(Math.random()*10));
        requestParams.put("channelId", 5);

        array.add(requestParams);

        System.out.println(array);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(array.toArray());//Imprimer el Array

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
    public void Get_Test3() {
        System.out.println("*****GetObjectiveCategoryByChannel - GET *****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/ObjectiveCategory/GetObjectiveCategoryByChannel?ObjectiveCategoryId=2&ChannelId=2");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ObjectiveCategory/GetObjectiveCategoryByChannel?ObjectiveCategoryId=2&ChannelId=2"));
    }

    @Test
    public void Get_Test4() {

        System.out.println("*****ObjectiveCategory - Get*****");
        System.out.println("=================================================");
        RestAssured.baseURI = URL+"/api/services/app/ObjectiveCategory/Get";

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ObjectiveCategory/Get?Id=3"));

    }

    @Test
    public void GetALL_Test4() {
        System.out.println("*****ObjectiveCategory/GetALL - Select ALL*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL+"/api/services/app/ObjectiveCategory/GetAll");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ObjectiveCategory/GetAll?Id=0"));
    }

    @Test
    public void PUT_Test5() {
        System.out.println("*****ObjectiveCategory  Order*****");
        RestAssured.baseURI = URL+"/api/services/app/ObjectiveCategory/Order";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Reques
        //
        JSONArray array = new JSONArray();
        JSONObject requestParams = new JSONObject();
        requestParams.put("order", Math.round(Math.random() * 10));
        requestParams.put("id", Math.round(Math.random() * 10));

        array.add(requestParams);

        System.out.println(array);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(array.toArray());//Imprimer el Array

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
    public void PUT_Test6() {

        System.out.println("*****ObjectiveCategory  Update*****");
        RestAssured.baseURI = URL+"/api/services/app/ObjectiveCategory/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        JSONArray array = new JSONArray();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "ObjectiveCategory - Update" + Math.round(Math.random() * 20));
        requestParams.put("id", Math.round(Math.random() * 20));
        try {

            JSONArray ja = new JSONArray();
            requestParams.put("channel", ja);

        } catch (JsonException e) {
            e.printStackTrace();
        }
        array.add(requestParams);

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

    @Test///Pendiente
    public void Delete_test7() {

        ///Delete date the tabla
        System.out.println("*****ObjectiveCategory - Delete*****");
        System.out.println("La URL a validar: "+URL+"/api/services/app/ObjectiveCategory/Delete");
        RequestSpecification request = RestAssured.given();

        Response response =request.delete(URL+"/api/services/app/ObjectiveCategory/Delete?Id=33");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }

    @Test// Pendiente de Mensaje
    public void Delete_Test8() {

        System.out.println("*****DeleteObjectiveCategory  Update*****");
        RestAssured.baseURI = URL+"/app/ObjectiveCategory/DeleteObjectiveCategoryByChannel";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("objectiveCategoryId",2 );
        requestParams.put("channelId", 2);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        System.out.println(requestParams);

        Response response = httpRequest.request(DELETE, "");

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

