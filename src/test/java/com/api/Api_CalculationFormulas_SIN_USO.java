package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

import static io.restassured.http.Method.PUT;

public class Api_CalculationFormulas_SIN_USO {




    @Test
    public void Post_Test1() {

        int cont=0;
        try {
            for (int i = 0; i < 1; i++) {
                cont++;

                // Este pos tiene la complejida de dos JSON insert en [CalculationFormulaByCalculationVariable] y [CalculationFormula] con base a la tabla [CalculationVariable]
                ////Insert in Table
                System.out.println("*****CalculationFormula - Create*****");
                RestAssured.baseURI = "/api/services/app/CalculationFormula/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name", "CalculationFormula_Create");
                requestParams.put("formula", "a = A/C(a + b)");


                ///Se crea el segundo objeto para Añadir otro JSON
                JSONObject requestParams2 = new JSONObject();
                requestParams2.put("calculationVariableId", 1);
                requestParams2.put("isVisible", true);

                ///Create Array
                JSONArray ja = new JSONArray();
                ja.add(requestParams2);
                requestParams.put("calculationVariables", ja);


                httpRequest.header("Content-Type", "application/json");
                httpRequest.body(requestParams.toJSONString());

                System.out.println(requestParams);

                Response response = httpRequest.request(Method.POST, "");

                System.out.println(response);
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
        ///Select one date the tabla
        System.out.println("***** CalculationFormula - Get*****");
        Response response = RestAssured.get("https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationFormula/Get?Id=1");
        System.out.println("=================================================");
        System.out.println("La URL a validar: https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationFormula/Get");

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
    public void Put_Test3() {

        System.out.println("***** Calculation Formula - Upadate*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/CalculationFormula/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "CalculationFormula_Update" + Math.round(Math.random()*20));
        requestParams.put("formula", "A= A-C " + Math.round(Math.random()*100));
        requestParams.put("id",1);

        ///Se crea el segundo objeto para Añadir otro JSON
        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("calculationVariableId",2);
        requestParams2.put("isVisible", true);

        ///Create Array en una lista
        JSONArray ja = new JSONArray();
        ja.add(requestParams2);
        requestParams.put("calculationVariables", ja);
        System.out.println(requestParams);

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
     public void GetALL_Test4() {
            ///Select date the All tabla
            System.out.println("*****CalculationFormula - Select all Data*****");
            RestAssured.baseURI="https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationFormula/GetAll";
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
    public void Delete_test5() {

        ///Delete date the tabla
        System.out.println("*****CalculationFormula - Delete*****");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete("https://02p-elevaapi-d01.azurewebsites.net/api/services/app/CalculationFormula/Delete?Id=" +  Math.round(Math.random()*5));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
}
