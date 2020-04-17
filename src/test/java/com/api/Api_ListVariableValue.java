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

public class Api_ListVariableValue {

    @Test
    void Get_Test1() {

        System.out.println("*****VariableListValue - Select for id*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/VariableListValue/Get";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("Id", Math.round(Math.random()*10));


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
    void Get_test2() {
        ///Select date the All tabla
        System.out.println("*****VariableListValue - Select all Data*****");
        RestAssured.baseURI="https://elevadevbackend.azurewebsites.net/api/services/app/VariableListValue/GetAll";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"");

        ///Response Body
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
    public void Post_test3() {
        int cont=0;
        try {

            for (int i = 1; i < 1; i++) {
                cont++;

        // Este pos tiene la complejida de dos JSON insert en [VariableListValue]
        ////Insert in Table
        System.out.println("*****VariableListValue/Create - Create*****");
        RestAssured.baseURI="https://elevadevbackend.azurewebsites.net/api/services/app/VariableListValue/Create";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams= new JSONObject();
        requestParams.put("name","Anual"+Math.round(Math.random()*20));
        requestParams.put("days",Math.round(Math.random()*30));
        requestParams.put("months",Math.round(Math.random()*12));
        requestParams.put("calculationVariableId",Math.round(Math.random()*5));


        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST,"");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status=response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status, 200);

        //status line verification
        String statusLine=response.getStatusLine();
        System.out.println("Status linea es:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Put_test4() {

        ///Update date the tabla
        ////Insert in Table
        System.out.println("*****VariableListValue/Update - Upadate*****");
        RestAssured.baseURI="https://elevadevbackend.azurewebsites.net/api/services/app/VariableListValue/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams= new JSONObject();
        requestParams.put("name","Anual_Update"+Math.round(Math.random()*20));
        requestParams.put("days",Math.round(Math.random()*30));
        requestParams.put("months",Math.round(Math.random()*12));
        requestParams.put("calculationVariableId",Math.round(Math.random()*5));
        requestParams.put("id",Math.round(Math.random()*20));

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response=httpRequest.request(PUT,"");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status=response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status, 200);
    }

    @Test
    public void Delete_test5() {

        ///Delete date the tabla [dbo].[VariableListValue]
        System.out.println("*****VariableListValue/Delete - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/VariableListValue/Delete?Id="+ Math.round(Math.random()*20));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);

    }


}

