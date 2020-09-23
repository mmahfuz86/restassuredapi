package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PublicContactListTest extends ApiConfig {
    @Test
    public void register_single_user() {

        String payload = "{" +
                "    \"email\": \"peter86@example.com\",\n" +
                "    \"password\": \"SuperChargeCarV8Turbo\"\n" +
                "}";

         RestAssured.baseURI = "https://craftplacer.trexion.com";
         RequestSpecification spec = RestAssured.given();
         spec.header("Content-Type", "Application/json");
         spec.body(payload);

         Response response = spec.post("/pcl/auth/register");
         System.out.println(response.getStatusLine() );
         
    }

    @Test
    public void register_single_user_file_payload() {
        String path = System.getProperty("user.dir") + "/src/test/resources/payloads/newUser.json";
        String payload = read(path).trim();

        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/json");
        spec.body(payload);
        System.out.println("PAYLOAD" + payload);

        Response response = spec.post("/pcl/auth/register");
        System.out.println(response.getStatusLine() );

    }

    //private String read(String path) { };


    @Test
    public void login_registered_user_extract_sessionToken() {
        String payload = "{" +
                "    \"email\": \"peter86@example.com\",\n" +
                "    \"password\": \"SuperChargeCarV8Turbo\"\n" +
                "}";
        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/json");
        spec.body(payload);

        Response response = spec.post("/pcl/auth/register");
        System.out.println(response.getStatusLine() );
        String sessionToken = response.body().asString();
        System.out.println(sessionToken);



    }
}
