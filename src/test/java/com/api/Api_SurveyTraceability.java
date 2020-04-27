package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.PUT;


public class Api_SurveyTraceability {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test
    public void Post_Test1() {
        int cont = 0;
        try {
            for (int i = 0; i < 2; i++) {
                cont++;

                System.out.println("***** Survey Traceability - Create *****");
                RestAssured.baseURI = URL+"/api/services/app/SurveyTraceability/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("typeId","Aqui"+Math.round(Math.random() * 20));
                requestParams.put("numberId","Aqui"+Math.round(Math.random() * 20));
                requestParams.put("date","2019-10-25T16:06:00.541Z");
                requestParams.put("name","SurveyTraceability_Create"+ Math.round(Math.random() * 20));
                requestParams.put("email","Jrodrigue2z@dataifx.com");
                requestParams.put("mobile","3174249877");
                requestParams.put("result","Test");


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

        System.out.println("***** Survey Traceability - Get*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+ URL +"/api/services/app/SurveyTraceability/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/SurveyTraceability/Get?Id=4"));

    }

    @Test
    public void GetALL_Test3() {

       System.out.println("***** Survey Traceability  - GetAll*****");
       System.out.println("=================================================");
       System.out.println("La URL a validar: "+ URL +"/api/services/app/SurveyTraceability/GetAll");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/SurveyTraceability/GetAll"));

    }

    @Test
    public void Put_Test4() {

        System.out.println("***** Survey Traceability - Update*****");
        RestAssured.baseURI = URL+"/api/services/app/SurveyTraceability/Update";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Body post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("typeId","Cambio"+Math.round(Math.random() * 20));
        requestParams.put("numberId","Aqui"+Math.round(Math.random() * 20));
        requestParams.put("date","2019-10-25T16:06:00.541Z");
        requestParams.put("name","SurveyTraceability_Update"+ Math.round(Math.random() * 20));
        requestParams.put("email","Jrodrigue2z@dataifx.com");
        requestParams.put("mobile","3174249877");
        requestParams.put("result","TestUpdate");
        requestParams.put("id",1);

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
    public void Delete_Test4() {

        System.out.println("***** SurveyTraceability - Delete*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+ URL +"/api/services/app/SurveyTraceability/Delete");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL+"/api/services/app/SurveyTraceability/Delete/?Id=4");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }

    }
