package com.api;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.http.Method.PUT;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Api_Channel {

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test
    public void Post_test1() {
        int cont = 0;
        try {
            for (int i = 1; i < 2; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****Channel - Create*****");
                RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Channel/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","Channel_Create");
                requestParams.put("Code ","39");
                requestParams.put("File", "C:/Users/Testing2/IdeaProjects/RestAssured");
                requestParams.put("OfficeCode","Test");
                requestParams.put("OfficeName","Channel_Create");

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
    public void Get_Test2() {
        System.out.println("***** Channel - Get *****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Channel/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Channel/Get?Id=98"));

    }

    @Test
    public void GetALL_test4 () {
        ///Select date the All tabla
        System.out.println("*****Channel - Select all Data*****");
        System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Channel/GetALL");
        System.out.println("=================================================");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/Channel/GetALL"));
    }

    @Test
    public void Put_test3 () {

            System.out.println("*****Channel - Upadate*****");
            RestAssured.baseURI = "https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Channel/Update";
            System.out.println("=================================================");
            System.out.println("La URL a validar:" + RestAssured.baseURI);
            RequestSpecification httpRequest = RestAssured.given();

            //Body post Request
            JSONObject requestParams = new JSONObject();
            requestParams.put("name", "USA");
            requestParams.put("Code", "09");
            requestParams.put("OfficeCode","02tESTEEEEEEEEEE");
            requestParams.put("OfficeName", "UTHA");
            requestParams.put("Id", 98);


        ///Se crea el segundo objeto
        JSONObject requestParams1 = new JSONObject();

        requestParams.put("File", requestParams1);



            httpRequest.header("Content-Type", "application/json");
            httpRequest.body(requestParams.toJSONString());

            System.out.println(requestParams);

            Response response = httpRequest.request(PUT, "");

            String responseBody = response.getBody().asString();
            System.out.println("Response Body is: " + responseBody);

            int status = response.getStatusCode();
            System.out.println("Status code is: " + status);
            Assert.assertEquals(status, 200);
        }

    @Test
    public void Delete_test5 () {

            ///Delete date the tabla
            System.out.println("*****Channel - Delete*****");
            System.out.println("La URL a validar:  https://02p-elevaapi-d01.azurewebsites.net/api/services/app/Channel/Delete");
            RequestSpecification request = RestAssured.given();

            Response response = request.delete(URL+"/api/services/app/Channel/Delete?Id=88"+ Math.round(Math.random()*100));

            request.header("Content-Type", "application/json");
            String responseBody = response.getBody().asString();
            System.out.println("Response Body is: " + responseBody);

            int status = response.getStatusCode();
            System.out.println("Status code is: " + status);
            Assert.assertEquals(status, 200);

        }
    }
