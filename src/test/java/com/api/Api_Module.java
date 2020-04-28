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

import java.rmi.MarshalException;

import static io.restassured.http.Method.PUT;

public class Api_Module {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test
    public void Post_test1() {
        int cont=1;
        try {
            for (int i = 0; i < 1; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****Module - Create*****");
                RestAssured.baseURI = URL+"/api/services/app/Module/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                    JSONObject requestParams = new JSONObject();

                    requestParams.put("name", "Module_Create"+Math.round(Math.random()*30));

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

        System.out.println("*****Module - Get*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"api/services/app/Module/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Module/Get?Id=15"));

    }

    @Test
    public void GetALL_test3() {
        System.out.println("*****Module - GetAll *****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/Module/GetAll");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Module/GetAll"));
    }

    @Test
    public void PUT_test4() {

                System.out.println("*****Module - Update*****");
                RestAssured.baseURI = URL+"/api/services/app/Module/Update";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();


                JSONObject requestParams = new JSONObject();

                    requestParams.put("name","Module_Update"+Math.round(Math.random()*20));
                    requestParams.put("id",15);


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
    public void Delete_test5() {

        System.out.println("*****Module - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL+"/api/services/app/Module/Delete?Id=14");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
    }






