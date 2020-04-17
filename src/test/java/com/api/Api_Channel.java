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

    @Test
    public void Post_test1() {
        int cont = 0;
        try {
            for (int i = 1; i < 10; i++) {
                cont++;

                ////Insert in Table
                System.out.println("*****Channel - Create*****");
                RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/Channel/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                //Body post Request
                JSONObject requestParams = new JSONObject();
                requestParams.put("name","Channel_Create"+Math.round(Math.random()*20));


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
        Response response = RestAssured.get("https://elevadevbackend.azurewebsites.net/api/services/app/Channel/Get?Id="+Math.round(Math.random()*10));
        System.out.println("=================================================");
        System.out.println("La URL a validar:  https://elevadevbackend.azurewebsites.net/api/services/app/Channel/Get");

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
    public void GetALL_test4 () {
        ///Select date the All tabla
        System.out.println("*****Channel - Select all Data*****");
        RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/Channel/GetALL";
        System.out.println("=================================================");
        System.out.println("La URL a validar:" + RestAssured.baseURI);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        ///Response Body
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
    public void Put_test3 () {

            System.out.println("*****Channel - Upadate*****");
            RestAssured.baseURI = "https://elevadevbackend.azurewebsites.net/api/services/app/Channel/Update";
            System.out.println("=================================================");
            System.out.println("La URL a validar:" + RestAssured.baseURI);
            RequestSpecification httpRequest = RestAssured.given();

            //Body post Request
            JSONObject requestParams = new JSONObject();
            requestParams.put("name", "Channel_UpdateJJR"+ Math.round(Math.random() * 10));
            requestParams.put("id", Math.round(Math.random() * 10));

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
    public void Delete_test5 () {

            ///Delete date the tabla
            System.out.println("*****Channel - Delete*****");
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");

            Response response = request.delete("https://elevadevbackend.azurewebsites.net/api/services/app/Channel/Delete?Id="+Math.round(Math.random()*10));

            String responseBody = response.getBody().asString();
            System.out.println("Response Body is: " + responseBody);

            int status = response.getStatusCode();
            System.out.println("Status code is: " + status);
            Assert.assertEquals(status, 200);

        }
    }
