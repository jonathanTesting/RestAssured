package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.PUT;

public class Api_ModuleMessage {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";
   @Test
    public void Post_test1() {
        int cont=0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("***** ModuleMessage - Create*****");
                RestAssured.baseURI = URL+"/api/services/app/ModuleMessage/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                    JSONObject requestParams = new JSONObject();

                    requestParams.put("moduleId", 13);
                    requestParams.put("code", "ModelPortfolio_Create" + Math.round(Math.random()*20));
                    requestParams.put("description", "Test AutomationJJR");
                    requestParams.put("isVisible", true);


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
    public void Get_test2() {

        System.out.println("**** *ModuleMessage - Get*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/ModuleMessage/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ModuleMessage/Get?Id=12"));

    }

    @Test
    public void GetALL_test3() {

        System.out.println("***** ModuleMessage - GetAll*****");
        System.out.println("=================================================");

        System.out.println("La URL a validar:"+URL+"/api/services/app/ModuleMessage/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ModuleMessage/GetAll?ModuleId=2&Language=es"));

    }

    @Test
    public void PUT_test3() {

       System.out.println("***** ModuleMessage Update*****");
       RestAssured.baseURI = URL+"/api/services/app/ModuleMessage/Update";
       System.out.println("=================================================");
       System.out.println("La URL a validar:" + RestAssured.baseURI);
       RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams = new JSONObject();

        requestParams.put("moduleId", 13);
        requestParams.put("code", "ModuleMessage_Update *es" + Math.round(Math.random()*28));
        requestParams.put("description", "Test Automation JJR");
        requestParams.put("isVisible", true);
        requestParams.put("languaje", "es");
        requestParams.put("text", "Tes Autmation Update");
        requestParams.put("id", 170);


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

        System.out.println("*****ModuleMessage - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL+"/api/services/app/ModuleMessage/Delete?Id=166");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }

    }






