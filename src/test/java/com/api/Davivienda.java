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

import static io.restassured.http.Method.*;

public class Davivienda {


    @Test

    public void Put_UpdateSurvey() {

        contender URL = new contender();

        System.out.println("***** Davivienda -  UpdateSurvey *****");
        RestAssured.baseURI = URL.metodo() + "/api/services/app/Davivienda/UpdateSurvey";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);
        RequestSpecification httpRequest = RestAssured.given();

        //Se crea el priemer objeto
        JSONObject requestParams = new JSONObject();
        requestParams.put("surveyId",20);
        requestParams.put("officeCode", "4090");
        requestParams.put("identificationNumber", "114");
        requestParams.put("identificationType", "1");

 //////////////////////////////////////////////////////////////////////////////////
        ///Se crea el segundo objeto
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("channel", "37");
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
        requestParams2.put("answerId", 1);
        requestParams2.put("questionId", 1);


        JSONObject requestParams3 = new JSONObject();
        requestParams3.put("answerId", 5);
        requestParams3.put("questionId", 1);

        JSONObject requestParams4 = new JSONObject();
        requestParams4.put("answerId", 9);
        requestParams4.put("questionId", 2);

        JSONObject requestParams5 = new JSONObject();
        requestParams5.put("answerId", 13);
        requestParams5.put("questionId", 3);

        JSONObject requestParams6 = new JSONObject();
        requestParams6.put("answerId", 16);
        requestParams6.put("questionId", 4);

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
    public void Post_SendOpeningInvestment() {
        contender URL = new contender();
                ////Insert in Table
                System.out.println("*****Send Opening Investment*****");
                RestAssured.baseURI = URL.metodo() + "/api/services/app/Davivienda/SendOpeningInvestment";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Se crea el priemer objeto
                JSONObject requestParams = new JSONObject();
                /*requestParams.put("identificationNumber", "114");
                requestParams.put("identificationType", "01");
                requestParams.put("officeCode", "4090");
                requestParams.put("clientName","Jaime");
                requestParams.put("clientFirstLastName","Velez");
                requestParams.put("clientSecondLastName","Zapata");
                requestParams.put("birthDate","1980-08-24");
                requestParams.put("address","KR 7 31 6160");
                requestParams.put("addressType",1);
                requestParams.put("city","16911001");
                requestParams.put("email","pruebas@gmail.com");
                requestParams.put("gender","F");
                requestParams.put("phone",0);
                requestParams.put("phoneType",0);
                requestParams.put("openingDate","2020-06-10");
                requestParams.put("clientType","01");
                requestParams.put("consultantCode","1");
                requestParams.put("riskProfileCode","04");
                requestParams.put("initialInvestmentAccount","0570099770000406");
                requestParams.put("initialInvestmentValue",20000);*/

                requestParams.put("identificationNumber", "40001");
                requestParams.put("identificationType", "01");
                requestParams.put("officeCode", "4090");
                requestParams.put("clientName","Ana Maria");
                requestParams.put("clientFirstLastName","Juarez");
                requestParams.put("clientSecondLastName","Juaron");
                requestParams.put("birthDate","1978-12-31T19:00:00");
                requestParams.put("address","fghjk6789");
                requestParams.put("addressType",3);
                requestParams.put("city","16954003");
                requestParams.put("email","jessica.rojas@componenteserviex.com");
                requestParams.put("gender","F");
                requestParams.put("phone",3216548);
                requestParams.put("phoneType",1);
                requestParams.put("openingDate","2020-06-17T13:24:58.860Z");
                requestParams.put("clientType","01");
                requestParams.put("consultantCode","0");
                requestParams.put("riskProfileCode","04");
                requestParams.put("initialInvestmentAccount","4856300034255795");
                requestParams.put("initialInvestmentValue",500000);
                //////////////////////////////////////////////////////////////////////////////////
                ///Se crea el segundo objeto
                JSONObject requestParams1 = new JSONObject();
                requestParams1.put("channel","37");
                requestParams1.put("operationMode", 0);
                requestParams1.put("profile",0);
                requestParams1.put("total", 0);
                requestParams1.put("user", "AX1");
                requestParams1.put("transactionId","0");
                requestParams1.put("workingDay",0);

                requestParams.put("header", requestParams1);

////////////////////////////////////////////////////////////////////////////
                ///Se crea el Tersero objeto para Array
                JSONObject requestParams2 = new JSONObject();
                requestParams2.put("productId", 1);
                requestParams2.put("composition", 0.5);
                requestParams2.put("name", "Estable");

                JSONObject requestParams3 = new JSONObject();
                requestParams3.put("productId", 2);
                requestParams3.put("composition", 0.3);
                requestParams3.put("name", "Renta Fija Global");

                JSONObject requestParams4 = new JSONObject();
                requestParams4.put("productId", 3);
                requestParams4.put("composition", 0.2);
                requestParams4.put("name", "Renta Fija Pesos");

                ///Create Array
                JSONArray ja = new JSONArray();
                ja.add(requestParams2);
                ja.add(requestParams3);
                ja.add(requestParams4);
                requestParams.put("products", ja);

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

    @Test
    public void Get_GetSurvey() {

        contender URL = new contender();
        System.out.println("*****Module - GetSurvey*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Davivienda/GetSurvey");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo() +"/api/services/app/Davivienda/GetSurvey?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&OfficeCode=0&TicketValue=0&SurveyCode=PERFIL_RIESGO"));

    }

    @Test
    public void Get_GetNaturalPerson() {
        contender URL = new contender();

        System.out.println("*****Module - GetNaturalPerson*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo() +"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=9903&OfficeCode=0"));
    }

    /*@Test
    public void Get_Email_Errado() {

        contender URL = new contender();
        System.out.println("*****Validacion Email Errado*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL.metodo() +"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=100&OfficeCode=0"));

    }

    @Test
    public void Get_Telefonos_Errado() {
        contender URL = new contender();

        System.out.println("*****Validacion Telefonos Errado*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL.metodo() +"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=18907&OfficeCode=0"));
    }

    @Test
    public void Get_Listas_Restictivas() {
        contender URL = new contender();
        System.out.println("*****Validacion Listas Restictivas*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=65765437&OfficeCode=0"));

    }

    @Test
    public void Get_Campos_Obligatorios() {
        contender URL = new contender();
        System.out.println("*****Validacion Campos Obligatorios*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo400(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/Davivienda/GetNaturalPerson?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=80907&OfficeCode=0"));
    }*/

    @Test
    public void Get_GetProductBalance() {
        contender URL = new contender();
        System.out.println("*****Module - GetProductBalance*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar: "+URL.metodo()+"/api/services/app/Davivienda/GetProductBalance");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL.metodo()+"/api/services/app/Davivienda/GetProductBalance?Header.Channel=37&Header.TransactionId=0&Header.WorkingDay=0&Header.Profile=0&Header.User=AX1&Header.OperationMode=0&Header.Total=0&IdentificationType=01&IdentificactionNumber=9903&CompanyValue=1&ProductCode=1&ProductNumber=1&WithSavings=1&WithCurrent=1&WithCreditCard=1&WithCredits=1&WithDabuenavida=1&WithProtectedCreditCard=1"));

    }
}


