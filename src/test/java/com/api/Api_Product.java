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


public class Api_Product {


    @Test
    public void Post_Test1() {
        contender URL = new contender();
        int cont = 0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table
                System.out.println("***** Product - Create*****");
                RestAssured.baseURI = URL.metodo()+"api/services/app/Product/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","Product/Create"+ Math.round(Math.random() * 20));
                requestParams.put("creditRatingId", Math.round(Math.random() * 10));
                requestParams.put("riskLevelId", 14);


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
        contender URL = new contender();

                System.out.println("***** CreateOrUpdateProductByRiskProfile - Create *****");
                RestAssured.baseURI = URL.metodo()+"/api/services/app/Product/CreateOrUpdateProductByRiskProfile";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();
                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();
                try {

                    requestParams.put("id",1);

                    JSONObject requestParams3 = new JSONObject();
                    requestParams3.put("value", 1);
                    requestParams3.put("id", 1);

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
        contender URL = new contender();

        System.out.println("***** Product - Get *****");
        RestAssured.baseURI = URL.metodo()+"/api/services/app/Product/Get";
        System.out.println("=================================================");
        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/Product/Get?Id=12"));
    }

    @Test
    public void GetALL_Test4() {
        ///Select one date the tabla
        contender URL = new contender();
        System.out.println("*****RiskLevel - GetAll*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Product/GetAll");

        /////Metodo Contenedor///
        contender llamada = new contender();
        llamada.metodo200(RestAssured.given(), RestAssured.get(URL.metodo() + "/api/services/app/Product/GetAll"));
    }

    @Test
    public void Put_Test5() {
        contender URL = new contender();

        System.out.println("***** Product - Update*****");
        RestAssured.baseURI = URL.metodo()+"/api/services/app/Product/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","Product_Update" + Math.round(Math.random()*20));
        requestParams.put("creditRatingId",1);
        requestParams.put("id",12);

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
        contender URL = new contender();

        System.out.println("***** Product - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL.metodo()+"/api/services/app/Product/Delete/?Id=13");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
    
    }
