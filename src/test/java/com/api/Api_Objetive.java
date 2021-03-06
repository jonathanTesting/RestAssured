package com.api;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.security.PublicKey;

import static io.restassured.http.Method.PUT;

public class Api_Objetive {

    @Test
    public void Post_Create() {
        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****Objective - Create - Create*****");
                RestAssured.baseURI = URL.metodo() + "/api/services/app/Objective/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                try {
                    requestParams.put("objectiveCategoryId", 24);
                    requestParams.put("calculationFormulaId", 1);
                    requestParams.put("name","Test_app/Objective/Create"+ Math.round(Math.random() * 10));
                    //requestParams.put("order",1);

                    JSONArray ja = new JSONArray();
                    requestParams.put("calculationVariables", ja);

                    JSONObject requestParams3 = new JSONObject();
                    requestParams3.put("calculationVariableId", 2);
                    requestParams3.put("code","|CD|");
                    requestParams3.put("name", "test"+ Math.round(Math.random() * 20));
                    requestParams3.put("description", "Creada desde app/Objective/");
                    requestParams3.put("minimumValue", 3);
                    requestParams3.put("maximumValue", 18);
                    requestParams3.put("warningValue", "Test");
                    requestParams3.put("defaultValue", "null");


                    ///Create Array
                    JSONArray jc = new JSONArray();
                    ja.add(requestParams3);
                    jc.add(2);
                    requestParams.put("variableListValues", jc);


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
    public void POST_CreateObjectiveByCalculationVariable() {
        contender URL = new contender();
        System.out.println("*****CreateObjectiveByCalculationVariable - Create*****");
        RestAssured.baseURI = URL.metodo() +"api/services/app/Objective/CreateObjectiveByCalculationVariable";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

                //Body post Reques

                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                    requestParams.put("objectiveId", 3);
                    requestParams.put("calculationVariableId",Math.round(Math.random() * 10));
                    requestParams.put("name", "TesAuto"+ Math.round(Math.random() * 20));
                    requestParams.put("description", "Este es un test Automatico"+ Math.round(Math.random() * 20));
                    requestParams.put("minimumValue", 18);
                    requestParams.put("maximumValue", 18);
                    requestParams.put("warningValue", "TestJJR");


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
    public void POST_CreateObjectiveByChannel() {
        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 0; i < 5; i++) {
                cont++;
        ////Insert in Table [dbo].[ObjectiveByCalculationVariable]
        System.out.println("*****CreateObjectiveByChannel - Create*****");
        RestAssured.baseURI = URL.metodo() +"/api/services/app/Objective/CreateObjectiveByChannel";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Reques
        //
        JSONArray array = new JSONArray();
        JSONObject requestParams = new JSONObject();
        requestParams.put("objectiveId", 3);
        requestParams.put("channelId",Math.round(Math.random() * 10));


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
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void POST_CreateObjectiveByVariableListValue() {
        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 1; i < 5; i++) {
                cont++;
                ////Insert in Table [dbo].[ObjectiveByVariableListValue]
                System.out.println("*****CreateObjectiveByVariableListValue - Create*****");
                RestAssured.baseURI = URL.metodo() + "/api/services/app/Objective/CreateObjectiveByVariableListValue";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Reques
                //
                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                requestParams.put("objectiveId", 2);
                requestParams.put("variableListValueId",Math.round(Math.random() * 10));
                requestParams.put("id",Math.round(Math.random() * 10));

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
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void PUT_Order() {

        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 0; i < 5; i++) {
                cont++;
                ////Insert in Table
                System.out.println("*****Objective  Order*****");
                RestAssured.baseURI = URL.metodo() + "/api/services/app/Objective/Order";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Reques
                //
                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                requestParams.put("order", Math.round(Math.random() * 30));
                requestParams.put("id",Math.round(Math.random() * 10));

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
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Get_id() {
        contender URL = new contender();
        System.out.println("*****Objective - Select for id*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL.metodo()+"/api/services/app/ObjectiveCategory/GetObjectiveCategoryByChannel?ObjectiveCategoryId=2&Channel");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/ObjectiveCategory/GetObjectiveCategoryByChannel?ObjectiveCategoryId=2&ChannelId=1"));

    }
    @Test
    public void Get_GetAll() {
        contender URL = new contender();
        System.out.println("*****Objective/Get - Select ALL*****");
        Response response = RestAssured.get(URL.metodo() +"/api/services/app/Objective/GetAll");
        System.out.println("=================================================");
        System.out.println("La URL a validar: " +URL.metodo()+ "/api/services/app/Objective/GetAll ");

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
    public void Post_Update() {
        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****Objective - Update*****");
                RestAssured.baseURI = URL.metodo()+"/api/services/app/Objective/Update";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                try {
                    requestParams.put("objectiveCategoryId", 14);
                    requestParams.put("calculationFormulaId", 1);
                    requestParams.put("name","Hoy");
                    requestParams.put("id",69);

                    JSONArray ja = new JSONArray();
                    requestParams.put("calculationVariables", ja);


                    JSONObject requestParams3 = new JSONObject();
                    requestParams3.put("calculationVariableId", 2);
                    requestParams3.put("code","|CD|");
                    requestParams3.put("name", "test"+ Math.round(Math.random() * 20));
                    requestParams3.put("description", "Update app/Objective/");
                    requestParams3.put("minimumValue", 3);
                    requestParams3.put("maximumValue", 18);
                    requestParams3.put("warningValue", "Test");
                    requestParams3.put("defaultValue", "null");

                    ///Create Array
                    JSONArray jc = new JSONArray();
                    ja.add(requestParams3);
                    jc.add(0);
                    requestParams.put("variableListValues", jc);


                }catch (JsonException e) {
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
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**@Test
    public void Put_test3() {

        ///Update date the tabla
        ////Insert in Table
        System.out.println("*****UpdateImagea - Upadate*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/Objective/UpdateImage";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams = new JSONObject();
        requestParams.put("id",7);

        //Body post Request
        JSONObject requestParams2 = new JSONObject();
       requestParams2.put("isVisible", true);

        ///Create Array en una lista
        JSONArray ja = new JSONArray();
        ja.add(requestParams2);
        requestParams.put("File", ja);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        System.out.println(requestParams);
        Response response = httpRequest.request(PUT, "");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);
        Assert.assertEquals(status, 200);

    }**/
    @Test
    public void Delete_test9() {
        contender URL = new contender();
        ///Delete date the tabla
        System.out.println("*****Objective - Delete*****");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Objective/Delete");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL.metodo() +"/api/services/app/Objective/Delete?Id=59");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }


    }






