//Package that contains all test classes
package tests;

//Libraries Used

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class TestRestAssured3 {


    // setting main url paramter in setup function that will be used in all
    // functions
    @BeforeClass
    public void setUp() {

        // Given - All input details
        // When - Submit the API
        // Then - Validate the Response

        // initializing rest assured base url as object from restassured services
        io.restassured.RestAssured.baseURI = "https://holidays.abstractapi.com";
    }

    // setting a function for GET by {api Key , country , year , month & day} Rest API
    // GET https://automationexercise.com/api/verifyLogin
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-19")
    @Test(priority = 21)
    public void getTest3() {
        given()
                .log().all().header("Cookie", "")
                .when().get("/v1/?api_key=47c2fd32d9884a669eadaa1285b40390&country=US&year=2020&month=12&day=25")
                .then().log().all().assertThat().statusCode(200)
                .body("name", contains("Christmas Day"))
                .header("Server", "nginx/1.18.0 (Ubuntu)");

    }
}