package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReqresGetTest {

    @Test
    public void client_can_get_all_user() {
        // Test Data
        String baseURI ="https://reqres.in";
        String endpoint = "/api/users?page=2";
        int expectedStatusCode = 200;
        String expectedProtocolVersion = "HTTP/1.4";

        // Test Steps

        //1. form a request
        //2. send the request
        //3. capture the response
        //4. extract the data and store them as actual

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);
        int actualStatusCode = response.getStatusCode();
        boolean actualProtocol = response.getStatusLine().contains(expectedProtocolVersion);


        // Status line
        System.out.println("Here is the status line");

        // Test Assertion
        //Assert.assertEquals(actualStatusCode, expectedStatusCode);
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(actualStatusCode, expectedStatusCode);
        sAssert.assertTrue(actualProtocol);
        sAssert.assertAll();

    }

    @Test
    public void client_can_get_all_headers() {
        // Test Data
        String baseURI ="https://reqres.in";
        String endpoint = "/api/users?page=2";
        String expectedContentType = "application/xml";
        String expectedServer = "cloudfare";
        String expectedConnection = "keep-alive";

        // Test Steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);
        // response.headers().getValue("Content-Type");
        String actualContentType =response.headers().getValue("Content-Type");
        String actualServer =response.headers().getValue("Server");
        String actualConnetion =response.headers().getValue("Connection");

        // Status line
        System.out.println("Here is the status line");

        // Test Assertion
        SoftAssert sAssert = new SoftAssert();
        boolean ret1 = actualContentType.contains(expectedContentType);
        sAssert.assertTrue(ret1);
        boolean ret2 = actualServer.contains(expectedServer);
        sAssert.assertTrue(ret2);
        boolean ret3 = actualConnetion.contains(expectedConnection);
        sAssert.assertTrue(ret3);
        sAssert.assertAll();

    }
    @Test
    public void client_can_get_all_user_body() {
        // Test Data
        String baseURI = "https://reqres.in";
        String endpoint = "/api/users?page=2";


        // Test Steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);


        // Test Assertion
        SoftAssert sAssert = new SoftAssert();


        sAssert.assertAll();
    }

}
