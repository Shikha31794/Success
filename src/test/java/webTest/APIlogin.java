package webTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

    public class APIlogin {
//
//        @Test
//        public void testLogin() {
//            given()
//                    .baseUri("https://reqres.in/api")
//                    .contentType("application/json")
//                    .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
//                    .when()
//                    .post("/login")
//                    .then()
//                    .statusCode(200)
//                    .body("token", notNullValue());
//
//        }
        @Test
        public void testLoginAPI() {
            // JSON request body    private static final String BASE_URL = "https://reqres.in/api"; // Dummy API
            String BASE_URL = "https://reqres.in/api";
            RestAssured.baseURI = BASE_URL;
            String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

            // Sending POST request to Login API
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/login")
                    .then()
                    .extract().response();

            // Print Response
            System.out.println("Response Body: " + response.getBody().asString());

            // Assertions
            Assert.assertEquals(response.statusCode(), 200, "Status Code Mismatch");
            Assert.assertNotNull(response.jsonPath().getString("token"), "Token Not Generated");
        }
    }

