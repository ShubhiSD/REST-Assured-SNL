package snl_service;
import static org.hamcrest.Matchers.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class SnlTest_v1 {
	int boardId;
	int playerid[];
	@BeforeClass
	  public void setBaseUri () {
		RestAssured.baseURI = "http://10.0.1.86/snl/rest/v1";
	}
	@Test(priority=1)
	  public void getListOfBoard() {
		Response response=when().
		        get("/board.json");
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("layout"));	    
	  }
	@Test(priority=2)
	  public void getNewBoard () {
		Response response= 	when().
		get("/board/new.json");
		boardId=response.path("response.board.id");
		String responseBody = response.getBody().asString();
		Assert.assertEquals(StringUtils.countMatches(responseBody, "id"),1);    
	  }
	
	
	@Test(priority=3)
	  public void geBoardDetail() {
		Response response= 	when().
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
		Response response=given().contentType("application/json").body(player1.toString()).when().post("/player.json");
		int statusCode = response.getStatusCode();
		playerid[0]=response.path("response.player.id");
		System.out.println(playerid[0]+"  "+statusCode);
		Assert.assertEquals(Integer.toString(statusCode), "200");
		Response response2=given().contentType("application/json").body(player2.toString()).when().post("/player.json");
		statusCode = response2.getStatusCode();
		playerid[1]=response2.path("response.player.id");
		Assert.assertEquals(Integer.toString(statusCode), "200");
		System.out.println(playerid[1]+"  "+statusCode);
		Response response3=given().contentType("application/json").body(player3.toString()).when().post("/player.json");
		statusCode = response3.getStatusCode();
		playerid[2]=response3.path("response.player.id");
		Assert.assertEquals(Integer.toString(statusCode), "200");
		System.out.println(playerid[2]+"  "+statusCode);
		when().get("board/{boardId}.json",boardId).then().assertThat().body("response.board.players.id",hasSize(3));
		
	}
	@Test(priority=5)
	  public void updatePlayer() throws JSONException
	{
		JSONObject player1 = new JSONObject(); 
		JSONObject player1Name = new JSONObject();
		player1Name.put("name", "ShubhiShukla");
		player1.put("player", player1Name);
		Response response=given().contentType("application/json").body(player1.toString()).when().put("/player/{playerid}.json",playerid[0]);
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
		Response response2=given().contentType("application/json").body(player2.toString()).when().post("/player.json");
		String responseBody = response2.getBody().asString();
		Assert.assertTrue(responseBody.contains("Player already exists"));	 
	
	}
	@Test(priority=7)
	  public void moveOnBoard()
	{
		
		Response response=given().param("player_id",playerid[0]).when().get("/move/{id}.json",boardId);
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
		
		Response response=given().when().delete("/player/{playerid}.json",playerid[2]);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(Integer.toString(statusCode), "200");
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("OK"));	    
		//.pathParam("player_id", playerid[0])
	} 
	@Test(priority=9)
	  public void resetBoard() {
		Response response= 	when().
				put("/board/"+boardId+".json");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(Integer.toString(statusCode), "200");	}

	@Test(priority=10)
	public void deleteBoard() {
		Response response= 	when().
				delete("/board/"+boardId+".json");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(Integer.toString(statusCode), "200");
		//get board detail of deleted board
		Response response2= when().
				get("/board/"+boardId+".json");
				String responseBody = response2.getBody().asString();
		Assert.assertTrue(responseBody.contains("Invalid board id"));	
		}
}