package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.PUT;


public class Api_Parameter {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";
    @Test
    public void Post_Test1() {
        int cont = 0;
        try {
            for (int i = 0; i < 2; i++) {
                cont++;

                System.out.println("*****Parameter - Create*****");
                RestAssured.baseURI = URL+"/api/services/app/Parameter/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("code","JJR"+ Math.round(Math.random() * 20));
                requestParams.put("description","Parameter/Create"+ Math.round(Math.random() * 20));
                requestParams.put("value","Test");

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

        System.out.println("***** Parameter - Get*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL+" https://elevadevbackend.azurewebsites.net/api/services/app/Parameter/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Parameter/Get?Id=19"));
    }

    @Test
    public void GetALL_Test2() {
       ///Select one date the tabla
       System.out.println("*****RiskLevel - GetAll*****");
       System.out.println("=================================================");
       System.out.println("La URL a validar: "+URL+" /api/services/app/Parameter/GetAll ");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Parameter/GetAll"));

   }

    @Test
    public void Put_Test3() {

        System.out.println("***** Parameter - Update*****");
        RestAssured.baseURI = URL+"/api/services/app/Parameter/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("code","JJR9");
        requestParams.put("description","Parameter/Update"+ Math.round(Math.random() * 20));
        requestParams.put("value","Test");
        requestParams.put("id",21);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(PUT, "");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);
        Assert.assertEquals(status, 200);

    }

    @Test///Pendiente
    public void Delete_Test4() {

        ///Delete date the tabla
        System.out.println("*****Channel - Delete*****");
        System.out.println("La URL a validar: "+URL+"/api/services/app/Parameter/Delete");
        RequestSpecification request = RestAssured.given();

        Response response = request.delete(URL+"/api/services/app/Parameter/Delete?id=21");

        request.header("Content-Type", "application/json");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);
        Assert.assertEquals(status, 200);





    }
    
    }
