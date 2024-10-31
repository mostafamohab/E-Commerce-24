//Package that contains all test classes
package tests;

//Libraries Used
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//some libraries needs being static
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TestRestAssured {


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
    @TmsLink("TC-17")
    @Test(priority = 17)
    public void getTest1() {
        given()
                .log().all().header("Cookie", "")
                .when().get("")
                .then().log().all().assertThat().statusCode(200)
                .body("name[0]", containsStringIgnoringCase("Google Pixel 6 Pro"))
                .header("Server", "cloudflare");

    }

    // setting a function for Create a Patch Rest API
    // PATCH https://api.restful-api.dev/objects/7
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-18")
    @Test(priority = 18)
    public void getTest2() {

        String payload = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16 (Updated Name)\"\n" +
                "}";

        given()
                .log().all().header("Cookie", "")
                .body(payload)
                .when().patch("/7")
                .then().log().all().assertThat().statusCode(200)
                .body("body", containsStringIgnoringCase("Updated Name"))
                .header("", "");

    }

    // setting a function for Create a Post Rest API
    // POST https://api.restful-api.dev/objects
    @Epic("SHAFT Web GUI Template")
    @Story("ECommerce Basic Validations")
    @TmsLink("TC-19")
    @Test(priority = 19)
    public void getTest3() {

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
                .body(payload)
                .when().post("")
                .then().log().all().assertThat().statusCode(200)
                .body("body", containsStringIgnoringCase("createdAt"))
                .header("", "");

    }

}
