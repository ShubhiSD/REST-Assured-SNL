package stepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.Matchers.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class StepDefinitions {
	static int boardId;
	static int playerid[];
@Given("^REST API base URI is known$")
public void setBaseUri () {
	RestAssured.baseURI = "http://10.0.1.86/snl/rest/v1";
}
@When("^List of all baords is available$")
public void getListOfBoard() {
	Response response=when().
	        get("/board.json");
	String responseBody = response.getBody().asString();
	Assert.assertTrue(responseBody.contains("layout"));	    
  }
@And("^User Create new Board$")
public void getNewBoard () {
	Response response= 	when().
	get("/board/new.json");
	boardId=response.path("response.board.id");
	String responseBody = response.getBody().asString();
	Assert.assertEquals(StringUtils.countMatches(responseBody, "id"),1);    
  }
@Then("^Message displayed Board created Successfully$")
public void scenario1Sucessful()
{
System.out.println("Scenario New Board creation-- successful");
}




@Given("^Board is created$")
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

@When("^Add new players to board$")
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
@And("^Update player (.*) details with \"(.*)\"$")
public void updatePlayer(int player, String playerName) throws JSONException
	{
		JSONObject player1 = new JSONObject(); 
		JSONObject player1Name = new JSONObject();
		player1Name.put("name", playerName);
		player1.put("player", player1Name);
		Response response=given().contentType("application/json").body(player1.toString()).when().put("/player/{playerid}.json",playerid[player-1]);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(Integer.toString(statusCode), "200");
			
	}
@Then("^Message displayed Players created Successfully$")
public void playerUpdateSuccess()
{System.out.println("Scenario2 Creation new Players and then update newlyc created player---Successful");}
}
