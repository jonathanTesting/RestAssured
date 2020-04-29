package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.PUT;

public class ClientProduct {


    @Test
    public void Post_test1() {
        contender URL = new contender();
        int cont = 0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****ClientProduct - Create*****");
                RestAssured.baseURI = URL.metodo() + "/api/services/app/ClientProduct/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("code","2"+ Math.round(Math.random()*100));
                requestParams.put("type","AhorrosAUT");
                requestParams.put("subProductCode","6"+ Math.round(Math.random()*100));
                requestParams.put("name","Test");
                requestParams.put("firstContribution",true);
                requestParams.put("schedulePeriodicContribution",true);


                System.out.println(requestParams);

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
    public void Put_Test2() {

        contender URL = new contender();
        System.out.println("***** ClientProduct - Update *****");
        RestAssured.baseURI = URL.metodo() +"/api/services/app/ClientProduct/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("code","11");
        requestParams.put("type","AhorrosAUT");
        requestParams.put("subProductCode","303500");
        requestParams.put("name","Producto AAA");
        requestParams.put("firstContribution",true);
        requestParams.put("schedulePeriodicContribution",true);
        requestParams.put("id",25);

        System.out.println(requestParams);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

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
    public void Get_Test3() {

        contender URL = new contender();
        System.out.println("*****ClientProduct - GetSurvey*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/ClientProduct/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo() +"/api/services/app/ClientProduct/Get?Id=7"));

    }

    @Test
    public void GetALL_Test4 () {

        contender URL = new contender();
        System.out.println("*****Channel - Select all Data*****");
        System.out.println("La URL a validar:  "+URL.metodo()+"/api/services/app/ClientProduct/GetAll");
        System.out.println("=================================================");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo() +"/api/services/app/ClientProduct/GetAll"));
    }

    @Test
    public void Delete_test5 () {

        contender URL = new contender();
        System.out.println("*****Channel - Delete*****");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/ClientProduct/Delete");
        RequestSpecification request = RestAssured.given();

        Response response = request.delete(URL.metodo() +"/api/services/app/ClientProduct/Delete?Id=44");

        request.header("Content-Type", "application/json");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);
        Assert.assertEquals(status, 200);

    }
}




