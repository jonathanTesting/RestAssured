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


public class Api_RiskLevel {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test
    public void Post_Test1() {
        int cont = 0;
        try {
            for (int i = 1; i < 1; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****RiskLevel - Create*****");
                RestAssured.baseURI = URL+"api/services/app/RiskLevel/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","RiskLevel/Create"+ Math.round(Math.random() * 20));


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

                System.out.println("***** CreateOrUpdateRiskLevelByRiskProfile - Create *****");
                RestAssured.baseURI = URL+"/api/services/app/RiskLevel/CreateOrUpdateRiskLevelByRiskProfile";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();
                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                try {

                    requestParams.put("id",1);

                    JSONObject requestParams3 = new JSONObject();
                    requestParams3.put("value", 5);
                    requestParams3.put("id", 4);

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

    @Test
    public void Get_Test3() {

        System.out.println("***** CreateOrUpdateRiskLevelByRiskProfile - Create *****");
        System.out.println("=================================================");
        RestAssured.baseURI = URL+"/api/services/app/RiskLevel/Get";

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/RiskLevel/Get?Id=2"));

    }

    @Test
    public void GetALL_Test4() {
       ///Select one date the tabla
        System.out.println("*****RiskLevel - GetAll*****");
        System.out.println("=================================================");
        Response response = RestAssured.get(URL+"/api/services/app/RiskLevel/GetAll");


        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/RiskLevel/GetAll"));


    }
    @Test
    public void Put_Test5() {

        System.out.println("***** RiskLevel - Update*****");
        RestAssured.baseURI = URL+"/api/services/app/RiskLevel/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","ALTO" + Math.round(Math.random()*20));
        requestParams.put("id",1);

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

        System.out.println("***** RiskLevel - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL+"/api/services/app/RiskLevel/Delete/?Id=4");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
    
    }
