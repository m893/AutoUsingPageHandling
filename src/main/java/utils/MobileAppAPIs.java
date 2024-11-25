package utils;
import com.google.gson.JsonDeserializationContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class MobileAppAPIs {
    //APIS Authentications
    public static String tokenAuth;
    public static String apiKey= "MIXojpPiXVcYl6rwKz6k4eGzXeHp7CnmrkhDPUaAXLGwWwxFYPLBDDYzCExCkcBG";

    // Static Variables to make code dynamic based on the response of APIS
     public static    Integer foundId = null;
    public static    Integer foundId2 = null;
    public static  Integer FoundCategoryID = null;
    public static Integer RoomID = null;
    public static Integer PantryID = null;

    public static int meetingId;
    public static int DeskId=1;


    //Date and Time To make the bookng date and time Dynamic based on the current time
    LocalDateTime fromDate = LocalDateTime.now(ZoneOffset.UTC);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    String fromDateString = fromDate.format(formatter);
    LocalDateTime toDate = fromDate.plus(20, ChronoUnit.MINUTES);
    String toDateString = toDate.format(formatter);


    public MobileAppAPIs()
    {
        Login();
        verifyLogin();
    }

    public void Login()
    {
        RestAssured.baseURI = "https://jeel-api-dev.dclickltd.com";

        String requestBody = "{\"email\": \"test@dclickltd.com\"}";

        Response response = RestAssured.given().header("Content-Type", "application/json").body(requestBody)
                .when().post("/api/v1/Login").
                then().extract().response();
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(),200);
    }

    public void verifyLogin()
    {
        String jsonBody = "{\n" +
                "    \"deviceId\": \"Automation\",\n" +
                "    \"deviceName\": \"UsingAPI\",\n" +
                "    \"email\": \"test@dclickltd.com\",\n" +
                "    \"verificationCode\": \"12345\"\n" +
                "}";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).when().post("/api/v1/Login/VerifyCode")
                .then().extract().response();
        tokenAuth = response.jsonPath().getString("token");


    }

    public void BookDesk()
    {

        String jsonBody = "{\"bookNow\":true,\"workspaceId\":1,\"fromDate\":\""+fromDateString+"\",\"toDate\":\""+toDateString+"\"}\n";

        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().post("/api/v1/WorkspaceBooking")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);

        // Extract the meeting ID
        DeskId = jsonPath.getInt("id");
        Assert.assertEquals(response.getStatusCode(),200);
    }

    public void GetTheCateringThatWillorderd() {

        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth)
                .when().get("/api/v1/Pantry/3/caterings")
                .then().extract().response();
        String nameToFind = "Test";
        String nameToFind2 = "Test2";

        // Use JsonPath to parse the response and extract the ID
        //list of map key is string and value is object
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> data = jsonPath.getList("data");

        for (Map<String, Object> item : data) {
            if (nameToFind.equals(item.get("name"))) {
                foundId = (Integer) item.get("id");
                break;
            }
        }
        for (Map<String, Object> item : data) {
            if (nameToFind2.equals(item.get("name"))) {
                foundId2 = (Integer) item.get("id");
                break;

            }
        }

        System.out.println("First Beverage: "+foundId);
        System.out.println("Second Beverage: "+foundId2);

        Assert.assertEquals(response.getStatusCode(),200);
    }

    public void OrderCatering()
    {
        String jsonBody = "[{\"cateringId\": \""+foundId+"\", \"quantity\": 0, \"addOns\": \"string\"}]";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().post("/api/v1/Order/userOrder")
                .then().extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    public void OrderCatering2()
    {
        String jsonBody = "[{\"cateringId\": \"" + foundId + "\", \"quantity\": 0, \"addOns\": \"string\"}," +
                "{\"cateringId\": \"" + foundId2 + "\", \"quantity\": 0, \"addOns\": \"string\"}]";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().post("/api/v1/Order/userOrder")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
    public void GetOrderedCatering()
    {
        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth)
                .when().get("/api/v1/Order/userOrder")
                .then().extract().response();

    }
    public void GetCategoryThatWillDeleted()
    {
        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth)
                .when().get("/api/v1/Category")
                .then().extract().response();
        String nameToFind = "TestCategory";

        // Use JsonPath to parse the response and extract the ID
        //list of map key is string and value is object
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> data = jsonPath.getList("$");


        for (Map<String, Object> item : data) {
            if (nameToFind.equals(item.get("name"))) {
                FoundCategoryID = (Integer) item.get("id");
                break;

            }
        }
        System.out.println("CategoryID: "+FoundCategoryID);
        Assert.assertEquals(response.getStatusCode(),200);
    }
    public void DeleteCategory()
    {
        Response response = RestAssured.given().pathParam("id",FoundCategoryID).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().delete("/api/v1/Category/{id}")
                .then().extract().response();
        Assert.assertEquals(response.getStatusCode(),204);
    }
    public void DeleteCatering()
    {
        Response response = RestAssured.given().pathParam("id",foundId).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().delete("/api/v1/Catering/{id}")
                .then().extract().response();
        Response response2 = RestAssured.given().pathParam("id",foundId2).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().delete("/api/v1/Catering/{id}")
                .then().extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response2.getStatusCode(),200);
    }

    public void BookMeeting()
    {
        String jsonBody = "{\"roomId\":"+RoomID+",\"title\":\"AutomationTesting\",\"description\":\"string\",\"fromDate\":\""+fromDateString+"\",\"toDate\":\""+toDateString+"\",\"color\":\"string\",\"requiredAttendees\":[\"omar.ali@dclickltd\"],\"optionalAttendees\":[\"mohammad.omar@dclickltd\"]}";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).header("x-api-key",apiKey).header("Authorization","Bearer " +tokenAuth)
                .when().post("/api/v1/Meeting")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);

        // Extract the meeting ID
        meetingId = jsonPath.getInt("id");

        System.out.println("MeetingID: "+meetingId);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    public void GetTheRoomThatWillBooked() {

        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth)
                .when().get("/api/v1/Location\n")
                .then().extract().response();
        //System.out.println(response.asPrettyString());

        // Use JsonPath to parse the response and extract the ID
        //list of map key is string and value is object
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> items = jsonPath.getList("$");


        for (Map<String, Object> item : items) {
            if ("Room".equals(item.get("type")) && item.get("email") == null) {
                RoomID = (Integer) item.get("id");
                PantryID = (Integer) item.get("pantryId");
                break;
            }
        }

        System.out.println("RoomID: "+RoomID);
        System.out.println("PantryID: "+PantryID);
        Assert.assertEquals(response.getStatusCode(),200);
    }
    public void CancelDeskBooking()
    {
        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth)
                .when().delete("/api/v1/WorkspaceBooking/"+DeskId+"/")
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Desk Canceled");
    }
    public void CancelMeetingBooking()
    {
        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth).pathParam("id",meetingId)
                .when().put("/api/v1/Meeting/{id}/cancel")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Meeting Canceled");
    }

    public void GetPostsOrder()
    {
        Response response = RestAssured.given().header("x-api-key", apiKey).header("Authorization", "Bearer " + tokenAuth)
                .when().get("/api/v1/Post")
                .then().extract().response();
        System.out.println(response.asPrettyString());
    }

}
