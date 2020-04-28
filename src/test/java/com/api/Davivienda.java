package com.api;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.http.Method.*;

public class Davivienda {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";


    @Test
    public void Put_Test1() {

        System.out.println("***** Davivienda -  UpdateSurvey *****");
        RestAssured.baseURI = URL+"/api/services/app/Davivienda/UpdateSurvey";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Se crea el priemer objeto
        JSONObject requestParams = new JSONObject();
        requestParams.put("officeCode", 0);
        requestParams.put("ticketValue", 0);
        requestParams.put("identificationType", "1");
        requestParams.put("identificactionNumber", "111111");
        requestParams.put("surveyId",1);

 //////////////////////////////////////////////////////////////////////////////////
        ///Se crea el segundo objeto
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("channel", 37);
        requestParams1.put("transactionId", "0");
        requestParams1.put("workingDay", 0);
        requestParams1.put("profile",0);
        requestParams1.put("user", "AX1");
        requestParams1.put("operationMode", 0);
        requestParams1.put("total", 0);

        requestParams.put("header", requestParams1);

////////////////////////////////////////////////////////////////////////////
        ///Se crea el Tersero objeto para Array
        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("questionId", 1);
        requestParams2.put("answerId", 1);

        JSONObject requestParams3 = new JSONObject();
        requestParams3.put("questionId", 2);
        requestParams3.put("answerId", 5);

        JSONObject requestParams4 = new JSONObject();
        requestParams4.put("questionId", 3);
        requestParams4.put("answerId", 9);


        JSONObject requestParams5 = new JSONObject();
        requestParams5.put("questionId", 4);
        requestParams5.put("answerId", 13);

        JSONObject requestParams6 = new JSONObject();
        requestParams6.put("questionId", 5);
        requestParams6.put("answerId", 16);

        ///Create Array
        JSONArray ja = new JSONArray();
        ja.add(requestParams2);
        ja.add(requestParams3);
        ja.add(requestParams4);
        ja.add(requestParams5);
        ja.add(requestParams6);
        requestParams.put("answers", ja);

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
    public void Get_Test2() {

        System.out.println("*****Module - GetSurvey*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetSurvey");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetSurvey?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&OfficeCode=0&TicketValue=0&SurveyCode=PERFIL_RIESGO"));

    }

    @Test
    public void Get_Test3() {

        System.out.println("*****Module - GetNaturalPerson*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetNaturalPerson");
        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=111111&OfficeCode=0"));

    }
    @Test
    public void Get_Test3_1() {

        System.out.println("*****Validacion Email Errado*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=100&OfficeCode=0"));

    }

    @Test
    public void Get_Test3_1_1() {

        System.out.println("*****Validacion Telefonos Errado*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=18907&OfficeCode=0"));
    }

    @Test
    public void Get_Test3_2() {

        System.out.println("*****Validacion Listas Restictivas*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=65765437&OfficeCode=0"));

    }

    @Test
    public void Get_Test3_3() {

        System.out.println("*****Validacion Campos Obligatorios*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=80907&OfficeCode=0"));
    }

    @Test
    public void Get_Test4() {

        System.out.println("*****Module - GetProductBalance*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Davivienda/GetProductBalance");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Davivienda/GetProductBalance?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=1&IdentificactionNumber=40001&CompanyValue=1&ProductCode=1&ProductNumber=1&WithSavings=1&WithCurrent=1&WithCreditCard=1&WithCredits=1&WithDabuenavida=1&WithProtectedCreditCard=1"));

    }
}


