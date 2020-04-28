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

    String URL = "https://02p-elevaapi-d01.azurewebsites.net";

    @Test//Pendiente de Ajustar
    public void Post_test1() {
        int cont=0;
        try {
            for (int i = 0; i < 1; i++) {
                cont++;

                ////Insert in Table [Objective]
                System.out.println("*****ModelPortfolio - Create*****");
                RestAssured.baseURI = URL+"/api/services/app/ModelPortfolio/Create";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();

                JSONObject requestParams = new JSONObject();
                requestParams.put("riskProfileId", 3);
                requestParams.put("name", "ModelPortfolio_Create" + Math.round(Math.random()*30));
                requestParams.put("isActive", true);
                requestParams.put("created", "2019-10-22T19:41:49.041Z");
                requestParams.put("digitateProfitability", 0.0893);
                requestParams.put("calculateProfitability", 0.061);
                requestParams.put("calculateVolatility", 0);
                requestParams.put("calculateVolatilityP1", 0);
                requestParams.put("isCalculated", true);
                requestParams.put("isVolatilityPercentile", true);

                /////////////////////////////////////////////////////////////////////////////////

                ///Se crea el Segundo objeto para Array
                JSONObject requestParams2 = new JSONObject();
                requestParams2.put("productId", 6);
                requestParams2.put("composition", 0.35);
                requestParams2.put("name", "Acciones Colombia");

                ///Create Array
                JSONArray ja = new JSONArray();
                ja.add(requestParams2);
                requestParams.put("product", ja);

                ///Create segundo rray
                JSONArray jb = new JSONArray();
                jb.add(0);
                requestParams.put("channels", jb);


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
    public void GetALL_test3() {
        System.out.println("*****ModulePortafolio - GetAll *****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"api/services/app/ModelPortfolio/GetAll");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ModelPortfolio/GetAll"));

    }

    @Test
    public void Get_test4() {

        System.out.println("*****ModelPortfolio - Get*****");
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/ModelPortfolio/Get");

        /////Metodo Contenedor///
        contender llamada=new contender();
        llamada.metodo200(RestAssured.given(),RestAssured.get(URL+"/api/services/app/ModelPortfolio/Get?Id=4"));

    }

    @Test//Pendiente de Ajustar
    public void PUT_test4() {

                System.out.println("*****ModulePortafolio - Update*****");
                RestAssured.baseURI = URL+"/api/services/app/ModelPortfolio/Update";
                System.out.println("=================================================");
                System.out.println("La URL a validar:" + RestAssured.baseURI);
                RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams = new JSONObject();

        requestParams.put("riskProfileId", 3);
        requestParams.put("name", "ModelPortfolio_Update" + Math.round(Math.random()*30));
        requestParams.put("isActive", true);
        requestParams.put("created", "2019-10-22T19:41:49.041Z");
        requestParams.put("targetProfiability", 0);
        requestParams.put("targetVolatility", 0);
        requestParams.put("id", 20);

        /////////////////////////////////////////////////////////////////////////////////

        ///Se crea el Segundo objeto para Array
        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("productId", 7);
        requestParams2.put("composition", 0.07);
        requestParams2.put("name", "Renta Fija Global");

        ///Create Array
        JSONArray ja = new JSONArray();
        ja.add(requestParams2);
        requestParams.put("products", ja);

        ///Create segundo Array
        ///Se crea el Segundo objeto para Array
        JSONObject requestParams3 = new JSONObject();
        requestParams2.put("name", "A");
        requestParams2.put("code",  "B");
        requestParams2.put("image", "https://02pelevastoraged.blob.core.windows.net/channel/637231042082089288.svg");
        requestParams2.put("officeCode", "C");
        requestParams2.put("officeName", "D");
        requestParams2.put("id", 2);


        JSONArray jb = new JSONArray();
        jb.add(requestParams3);
        requestParams.put("channels", jb);


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
        System.out.println("=================================================");
        System.out.println("La URL a validar:"+URL+"/api/services/app/ModelPortfolio/Delete");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        Response response =request.delete(URL+"/api/services/app/ModelPortfolio/Delete?Id=20" );

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody );

        int status = response.getStatusCode();
        System.out.println("Status code is: "+ status);
        Assert.assertEquals(status,200);
    }
    
    }






