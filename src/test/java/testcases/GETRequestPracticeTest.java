package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestPracticeTest {

    @Test
    public void get_request_practice1() {
        // 1. Register a base URI where the request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify the request that will be send
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users/2");

        // 3. Using the response object, let's extract each part
        // of the response (Status line, Headers, Body)
        System.out.println( response.statusLine() );
        System.out.println( response.statusCode() );

        // Headers
        Headers headers = response.headers();
        String entireHeaders = headers.toString();
        System.out.println(entireHeaders);
         String specificHeader = headers.getValue("Content-Type");
        // Body
        //ResponseBody responseBody = response.getBody().asString();
        //String prettyBody = responseBody.prettyPrint();



    }
}
