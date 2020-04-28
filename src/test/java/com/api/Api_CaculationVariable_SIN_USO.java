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
import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.PUT;

public class Api_CaculationVariable_SIN_USO {

    @Test
    public void Post_Test1() {
        int cont=1;
        try {

            for (int i = 0; i < 1; i++) {
                cont++;

                System.out.println("======================POST===========================");
                System.out.println("***** CalculationVariable - Create*****");
                RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name", "CalculationVariable_Create"+ Math.round(Math.random() * 100));
                requestParams.put("code", "RIO");
                requestParams.put("description", "Automation JJR");
                requestParams.put("minimumValue", Math.round(Math.random() * 20000));
                requestParams.put("maximumValue", Math.round(Math.random() * 10000000));
                requestParams.put("warning", "Atomation warning");
                requestParams.put("isList", true);

                httpRequest.header("Content-Type", "application/json");
                httpRequest.body(requestParams.toJSONString());

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Post_test2() {
        int cont = 1;
        try {
            for (int i = 0; i < 1; i++) {
                cont++;

        ///Insert in table [VariableListValueByCalculationVariable]
        System.out.println("======================POST===========================");
        System.out.println("*****CalculationVariable - Create Variable List Value By Calculation Variable*****");
        RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/CreateVariableListValueByCalculationVariable";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request ARRAY
        JSONArray array = new JSONArray();
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put("calculationVariableId", Math.round(Math.random()*10));
            requestParams.put("variableListValueId", Math.round(Math.random()*10));
        } catch (JsonException e) {
            e.printStackTrace();
        }
        array.add(requestParams);

        System.out.println(array);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(array.toJSONString());


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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Post_Test3() {
        ///Insert in table [VariableListValueByCalculationVariable]
        System.out.println("======================POST===========================");
        System.out.println("***** Create Calculation Formula By Calculation Variable*****");
        RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/CreateCalculationFormulaByCalculationVariable";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request ARRAY
        JSONArray array = new JSONArray();
        JSONObject requestParams = new JSONObject();
        try {
            requestParams.put("calculationVariableId", Math.round(Math.random()*30));
            requestParams.put("calculationFormulaId", Math.round(Math.random()*30));
        } catch (JsonException e) {
            e.printStackTrace();
        }
        array.add(requestParams);

        System.out.println(array);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(array.toJSONString());


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
    public void Get_Test4() {

        System.out.println("***** CalculationVariable - GET********");
        Response response = RestAssured.get("https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/Get?Id=3");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/Get");

        //Body post Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        RequestSpecification httpRequest = RestAssured.given();
        System.out.println(response);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status codigo es: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status linea es:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void GetALL_Test5() {
        System.out.println("***** CalculationVariable - GetALL *****");
        RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/GetAll";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status codigo es: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status linea es:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test
    public void GetVariable_Test6() {

        System.out.println("***** GetVariableListValueByCalculationVariable - Get *****");
        Response response = RestAssured.get("https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/GetVariableListValueByCalculationVariable?CalculationVariableId=2&VariableListValueId=2");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/GetVariableListValueByCalculationVariable");

        //Body post Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        RequestSpecification httpRequest = RestAssured.given();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status codigo es: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status linea es:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void GetCalculation_Test7() {

        System.out.println("***** GetVariableListValueByCalculationVariable - Get *****");
        Response response = RestAssured.get("https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/GetCalculationFormulaByCalculationVariable?CalculationVariableId=2&CalculationFormulaId=1");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/GetCalculationFormulaByCalculationVariable");

        //Body post Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        RequestSpecification httpRequest = RestAssured.given();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status codigo es: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status linea es:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void Put_Test8() {

        System.out.println("*****VariableListValue - Update*****");
        RestAssured.baseURI="https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams= new JSONObject();
        requestParams.put("name","CalculationVariable_Update"+Math.round(Math.random()*199));
        requestParams.put("code","PJJR");
        requestParams.put("description","Update_Automation JJR");
        requestParams.put("minimumValue",Math.round(Math.random()*1999));
        requestParams.put("maximumValue",Math.round(Math.random()*9999));
        requestParams.put("warning","Atomation warning");
        requestParams.put("id",Math.round(Math.random()*9));

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
    public void Delete_Test9() {

        ///Delete date the tabla
        System.out.println("*****CalculationVariable/Deletee - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/Delete?Id="+Math.round(Math.random()*10));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }

    @Test
    public void Delete_Test10() {

        ///Delete date the tabla
        System.out.println("*****Delete Variable ListValue By CalculationVariable - Delete*****");
        RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/DeleteVariableListValueByCalculationVariable";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("calculationVariableId",8);
        requestParams.put("variableListValueId",1);


        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        System.out.println(requestParams);

        Response response = httpRequest.request(DELETE, "");

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
    public void Delete_Test11() {

        ///Delete date the tabla
        System.out.println("*****Delete Variable ListValue By CalculationVariable - Delete*****");
        RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationVariable/DeleteCalculationFormulaByCalculationVariable";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("calculationVariableId",Math.round(Math.random()*20));
        requestParams.put("calculationFormulaId",Math.round(Math.random()*20));


        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        System.out.println(requestParams);

        Response response = httpRequest.request(DELETE, "");

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



}
