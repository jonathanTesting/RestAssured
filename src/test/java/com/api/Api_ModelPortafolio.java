package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static io.restassured.http.Method.PUT;

public class Api_ModelPortafolio {

   @Test
    public void Post_test1() {
        int cont=0;
        try {
            for (int i = 1; i < 5; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****ModelPortfolio - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/ModelPortfolio/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                    JSONObject requestParams = new JSONObject();

                    requestParams.put("riskProfileId", Math.round(Math.random()*10));
                    requestParams.put("name", "ModelPortfolio_Create" + Math.round(Math.random()*30));
                    requestParams.put("isActive", true);
                    requestParams.put("created", "2019-10-22T19:41:49.041Z");
                    requestParams.put("targetProfiability", 0);
                    requestParams.put("targetVolatility", 0);


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
    public void Get_test3() {
        System.out.println("*****ModulePortafolio - GetAll *****");
        Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/ModelPortfolio/GetAll");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/ModelPortfolio/GetAll ");

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
    public void Get_test4() {

        System.out.println("*****ModelPortfolio - Get*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/ModelPortfolio/Get";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("id", Math.round(Math.random()*10));

        System.out.println(requestParams);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.GET, "");

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
    public void PUT_test4() {

                System.out.println("*****ModulePortafolio - Update*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/ModelPortfolio/Update";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams = new JSONObject();

        requestParams.put("riskProfileId", 2);
        requestParams.put("name", "ModelPortfolio_Update" + Math.round(Math.random()*30));
        requestParams.put("isActive", true);
        requestParams.put("created", "2019-10-22T19:41:49.041Z");
        requestParams.put("targetProfiability", 0);
        requestParams.put("targetVolatility", 0);
        requestParams.put("id", 1);


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

        System.out.println("*****ModulePrortafolio - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/ModelPortfolio/Delete?Id=" +  Math.round(Math.random()*10));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
    
    }






