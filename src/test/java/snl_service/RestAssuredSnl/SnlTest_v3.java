package snl_service.RestAssuredSnl;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;

public class SnlTest_v3 {
	 String token;
	 int boardId;
	 int playerid[];
  @BeforeTest
  public void getToken() {
	  Response tokenResp=given().          
	    relaxedHTTPSValidation()            
	    .redirects().follow(false)        
	    .param("Auth URL", "http://10.0.1.86/snl/oauth/authorization")
	    .param("Access Token URL", "http://10.0.1.86/snl/oauth/token")
	    .param("Client ID", "cb4e80ef02e772d7e2a18f35b77a2f9e6cb93a786c2c3f5b7bb5fb53505309ad")
	    .param("Client Secret", "74eba68f874ac95864345d80418d14003bfda3d530b8f85329bcb09b6342c2ae")
	    .param("Scope", "SUBSCRIPTION_ALL")
	    .param("Grant Type", "Client Credentials")
	    .when()
	    .redirects().follow(false)
	    .post("http://10.0.1.86/snl/oauth/token?grant_type=client_credentials&client_id=cb4e80ef02e772d7e2a18f35b77a2f9e6cb93a786c2c3f5b7bb5fb53505309ad&client_secret=74eba68f874ac95864345d80418d14003bfda3d530b8f85329bcb09b6342c2ae");
	 JsonPath jsonPath = new JsonPath(tokenResp.asString());
	 token=jsonPath.getString("access_token");
	System.out.println(token);
	RestAssured.baseURI = "http://10.0.1.86/snl/rest/v3";
  }
 

  @Test(priority=1)
  public void getListOfBoard() {
	Response response=given().param("access_token",token).when().
	        get("/board.json");
	String responseBody = response.getBody().asString();
	Assert.assertTrue(responseBody.contains("layout"));	    
  }
@Test(priority=2)
  public void getNewBoard () {
	Response response= 	given().param("access_token",token).when().
	get("/board/new.json");
	boardId=response.path("response.board.id");
	String responseBody = response.getBody().asString();
	Assert.assertEquals(StringUtils.countMatches(responseBody, "id"),1);    
  }


@Test(priority=3)
  public void geBoardDetail() {
	Response response=given().param("access_token",token).when().
			get("/board/"+boardId+".json");
			String responseBody = response.getBody().asString();
			String id=Integer.toString(boardId);
			System.out.println(id);
			Assert.assertTrue(responseBody.contains(id));
			//Get the desired value of a parameter
			// String result = JSONResponseBody.getString({key});
}
@Test(priority=4)
  public void createNewPlayer() throws JSONException
{
	JSONObject player1 = new JSONObject();
	player1.put("board",boardId); 
	JSONObject player1Name = new JSONObject();
	player1Name.put("name", "Shubhi");
	player1.put("player", player1Name);
	JSONObject player2 = new JSONObject();
	player2.put("board",boardId); 
	JSONObject player2Name = new JSONObject();
	player2Name.put("name", "Aashi");
	player2.put("player", player2Name);
	JSONObject player3 = new JSONObject();
	player3.put("board",boardId); 
	JSONObject player3Name = new JSONObject();
	player3Name.put("name", "Akul");
	player3.put("player", player3Name);
	playerid=new int[3];
	// Add the Json to the body of the request
	Response response=given().header("Authorization", "Bearer "+token).contentType("application/json").body(player1.toString()).when().post("/player.json");
	int statusCode = response.getStatusCode();
	playerid[0]=response.path("response.player.id");
	System.out.println(playerid[0]+"  "+statusCode);
	Assert.assertEquals(Integer.toString(statusCode), "200");
	Response response2=given().header("Authorization", "Bearer "+token).contentType("application/json").body(player2.toString()).when().post("/player.json");
	statusCode = response2.getStatusCode();
	playerid[1]=response2.path("response.player.id");
	Assert.assertEquals(Integer.toString(statusCode), "200");
	System.out.println(playerid[1]+"  "+statusCode);
	Response response3=given().header("Authorization", "Bearer "+token).contentType("application/json").body(player3.toString()).when().post("/player.json");
	statusCode = response3.getStatusCode();
	playerid[2]=response3.path("response.player.id");
	Assert.assertEquals(Integer.toString(statusCode), "200");
	System.out.println(playerid[2]+"  "+statusCode);
	given().param("access_token",token).when().get("board/{boardId}.json",boardId).then().assertThat().body("response.board.players.id",hasSize(3));
	
}
@Test(priority=5)
  public void updatePlayer() throws JSONException
{
	JSONObject player1 = new JSONObject(); 
	JSONObject player1Name = new JSONObject();
	player1Name.put("name", "ShubhiShukla");
	player1.put("player", player1Name);
	Response response=given().header("Authorization", "Bearer "+token).contentType("application/json").body(player1.toString()).when().put("/player/{playerid}.json",playerid[0]);
	int statusCode = response.getStatusCode();
	Assert.assertEquals(Integer.toString(statusCode), "200");
	
	
}
@Test(priority=6)
  public void updateExistingPlayerWithSameName() throws JSONException
{
	JSONObject player2 = new JSONObject();
	player2.put("board",boardId); 
	JSONObject player2Name = new JSONObject();
	player2Name.put("name", "Aashi");
	player2.put("player", player2Name);
	Response response2=given().header("Authorization", "Bearer "+token).contentType("application/json").body(player2.toString()).when().post("/player.json");
	String responseBody = response2.getBody().asString();
	Assert.assertTrue(responseBody.contains("Player already exists"));	 

}
@Test(priority=7)
  public void moveOnBoard()
{
	
	Response response=given().param("access_token",token).param("player_id",playerid[0]).when().get("/move/{id}.json",boardId);
	int statusCode = response.getStatusCode();
	Assert.assertEquals(Integer.toString(statusCode), "200");
	String responseBody = response.getBody().asString();
	System.out.println("Response Body is" + responseBody);
	Assert.assertTrue(responseBody.contains("roll"));	    
	//.pathParam("player_id", playerid[0])
}
@Test(priority=8)
  public void deletePlayer()
{
	
	Response response=given().param("access_token",token).when().delete("/player/{playerid}.json",playerid[2]);
	int statusCode = response.getStatusCode();
	Assert.assertEquals(Integer.toString(statusCode), "200");
	String responseBody = response.getBody().asString();
	Assert.assertTrue(responseBody.contains("OK"));	    
	//.pathParam("player_id", playerid[0])
} 
@Test(priority=9)
  public void resetBoard() {
	Response response=given().param("access_token",token).when().
			put("/board/"+boardId+".json");
	int statusCode = response.getStatusCode();
	Assert.assertEquals(Integer.toString(statusCode), "200");	}

@Test(priority=10)
public void deleteBoard() {
	Response response= given().param("access_token",token).when().
			delete("/board/"+boardId+".json");
	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	Assert.assertEquals(Integer.toString(statusCode), "200");
	//get board detail of deleted board
	Response response2=  given().param("access_token",token).when().
			get("/board/"+boardId+".json");
			String responseBody = response2.getBody().asString();
			System.out.println(responseBody);
	Assert.assertTrue(responseBody.contains("Invalid board id"));	
	}
  @Test
  public void printhi() {System.out.println("hi");
  
  }
}
