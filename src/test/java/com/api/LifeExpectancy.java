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

public class LifeExpectancy {

    @Test
    public void Get() {
        contender URL = new contender();
        System.out.println("*****Objective - Select for id*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL.metodo()+"/api/services/app/LifeExpectancy/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/LifeExpectancy/Get?Id=1"));

    }
    @Test
    public void Get_GetAll() {
        contender URL = new contender();
        System.out.println("*****Objective/Get - Select ALL*****");
        Response response = RestAssured.get(URL.metodo() +"/api/services/app/LifeExpectancy/GetAll");
        System.out.println("=================================================");
        System.out.println("La URL a validar: " +URL.metodo()+ "/api/services/app/LifeExpectancy/GetAll");

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
    public void Put_Update() {
        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****Objective - Update*****");
                RestAssured.baseURI = URL.metodo()+"/api/services/app/LifeExpectancy/Update";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();


                JSONObject requestParams = new JSONObject();


                    requestParams.put("manFactor",Math.round(Math.random()*100));
                    requestParams.put("womanFactor", Math.round(Math.random()*100));
                    requestParams.put("manExpectancy",120);
                    requestParams.put("womanExpectancy",110);
                    requestParams.put("id",Math.round(Math.random()*100));


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
    @Test
    public void Put_BatchUpdate() {
        contender URL = new contender();
        int cont=0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;
                System.out.println("*****Objective - Update*****");
                RestAssured.baseURI = URL.metodo()+"/api/services/app/LifeExpectancy/BatchUpdate";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

               ///Creación de Array [{}]
                JSONArray array = new JSONArray();
                JSONObject requestParams = new JSONObject();

                try {
                requestParams.put("manFactor",Math.round(Math.random()*100));
                requestParams.put("womanFactor", Math.round(Math.random()*100));
                requestParams.put("manExpectancy",120);
                requestParams.put("womanExpectancy",110);
                requestParams.put("id",Math.round(Math.random()*100));

                }catch (JsonException e) {
                    e.printStackTrace();
                }
                array.add(requestParams);/// Digo al Array add el " JSONObject requestParams = new JSONObject();"

                httpRequest.header("Content-Type", "application/json");
                httpRequest.body(array.toJSONString());//Onlie Array

                System.out.println(array);

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


}
