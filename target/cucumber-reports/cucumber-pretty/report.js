$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Snl.feature");
formatter.feature({
  "line": 1,
  "name": "Snake Ladder Game for V1 REST API",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "New Board creation",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;new-board-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "REST API base URI is known",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "List of all baords is available",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User Create new Board",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Message displayed Board created Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.setBaseUri()"
});
formatter.result({
  "duration": 4248092,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.getListOfBoard()"
});
formatter.result({
  "duration": 640930885,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.getNewBoard()"
});
formatter.result({
  "duration": 191762677,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.scenario1Sucessful()"
});
formatter.result({
  "duration": 77248,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Creation new Players and then update newly created player",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;creation-new-players-and-then-update-newly-created-player",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Board is created",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Add new players to board",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Update player 2 details with \"Shiva\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Message displayed Players created Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.geBoardDetail()"
});
formatter.result({
  "duration": 156995739,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.createNewPlayer()"
});
formatter.result({
  "duration": 1231505891,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 14
    },
    {
      "val": "Shiva",
      "offset": 30
    }
  ],
  "location": "StepDefinitions.updatePlayer(int,String)"
});
formatter.result({
  "duration": 463998716,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.playerUpdateSuccess()"
});
formatter.result({
  "duration": 223641,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Update new Players",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;update-new-players",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Player already exist",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Update existing player",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Message displayed Players updated Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 20,
  "name": "Delete new Players",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;delete-new-players",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Player already exist",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Delete existing player",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Message displayed Players deleted Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 25,
  "name": "Reset existing board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;reset-existing-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Reset existing board",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Message displayed board reset Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 30,
  "name": "Delete existing board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;delete-existing-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Delete existing board",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "Message displayed board deleted Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Invalid boardid",
  "keyword": "But "
});
formatter.step({
  "line": 35,
  "name": "Message displayed board donot exist",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 37,
  "name": "Reset existing board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;reset-existing-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 38,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Reset existing board",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Message displayed board reset Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 42,
  "name": "Rolldice on board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;rolldice-on-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 43,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "Delete existing board",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "Message displayed board deleted Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "Invalid boardid",
  "keyword": "But "
});
formatter.step({
  "line": 47,
  "name": "Message displayed board donot exist",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("Snl.feature");
formatter.feature({
  "line": 1,
  "name": "Snake Ladder Game for V1 REST API",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "New Board creation",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;new-board-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "REST API base URI is known",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "List of all baords is available",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User Create new Board",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Message displayed Board created Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.setBaseUri()"
});
formatter.result({
  "duration": 47537,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.getListOfBoard()"
});
formatter.result({
  "duration": 3982182214,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.getNewBoard()"
});
formatter.result({
  "duration": 489182599,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.scenario1Sucessful()"
});
formatter.result({
  "duration": 72926,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Creation new Players and then update newly created player",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;creation-new-players-and-then-update-newly-created-player",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Board is created",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Add new players to board",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Update player 2 details with \"Shiva\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Message displayed Players created Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.geBoardDetail()"
});
formatter.result({
  "duration": 150409684,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.createNewPlayer()"
});
formatter.result({
  "duration": 12766960497,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 14
    },
    {
      "val": "Shiva",
      "offset": 30
    }
  ],
  "location": "StepDefinitions.updatePlayer(int,String)"
});
formatter.result({
  "duration": 357156825,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.playerUpdateSuccess()"
});
formatter.result({
  "duration": 195550,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Update new Players",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;update-new-players",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Player already exist",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Update existing player",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Message displayed Players updated Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 20,
  "name": "Delete new Players",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;delete-new-players",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Player already exist",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Delete existing player",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Message displayed Players deleted Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 25,
  "name": "Reset existing board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;reset-existing-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Reset existing board",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Message displayed board reset Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 30,
  "name": "Delete existing board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;delete-existing-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Delete existing board",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "Message displayed board deleted Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Invalid boardid",
  "keyword": "But "
});
formatter.step({
  "line": 35,
  "name": "Message displayed board donot exist",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 37,
  "name": "Reset existing board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;reset-existing-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 38,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Reset existing board",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Message displayed board reset Successfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 42,
  "name": "Rolldice on board",
  "description": "",
  "id": "snake-ladder-game-for-v1-rest-api;rolldice-on-board",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 43,
  "name": "Board already created",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "Delete existing board",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "Message displayed board deleted Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "Invalid boardid",
  "keyword": "But "
});
formatter.step({
  "line": 47,
  "name": "Message displayed board donot exist",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
