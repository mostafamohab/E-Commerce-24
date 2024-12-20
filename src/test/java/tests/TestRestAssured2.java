//Package that contains all test classes
package tests;

//Libraries Used

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class TestRestAssured2 {


    // setting main url paramter in setup function that will be used in all
    // functions
    @BeforeClass
    public void setUp() {

        // Given - All input details
        // When - Submit the API
        // Then - Validate the Response

        // initializing rest assured base url as object from restassured services
        io.restassured.RestAssured.baseURI = "https://api.restful-api.dev/objects";
    }

    // setting a function for Get post by {id} Rest API
    // GET https://api.restful-api.dev/objects
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-19")
    @Test(priority = 19)
    public void getTest3() {
        given()
                .log().all().header("Cookie", "")
                .when().get("")
                .then().log().all().assertThat().statusCode(200)
                .body("name[0]", containsStringIgnoringCase("Google Pixel 6 Pro"))
                .header("Server", "cloudflare");

    }

    // setting a function for Create a Post Rest API
    // POST https://api.restful-api.dev/objects
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-20")
    @Test(priority = 20)
    public void getTest4() {

        String payload = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        given()
                .log().all().header("Cookie", "")
                .contentType("application/json")
                .body(payload)
                .when().post("")
                .then().log().all().assertThat().statusCode(200)
                .body("name", containsStringIgnoringCase("Apple MacBook Pro 16"));

    }

}

