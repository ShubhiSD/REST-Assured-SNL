Feature: Snake Ladder Game for V1 REST API
 
Scenario: New Board creation 
	Given REST API base URI is known
	When List of all baords is available  
	And User Create new Board
	Then Message displayed Board created Successfully
	
Scenario: Creation new Players and then update newly created player
	Given Board is created
	When Add new players to board
	And Update player 2 details with "Shiva"
	Then Message displayed Players created Successfully

Scenario: Update new Players
	Given Player already exist
	When Update existing player
	Then Message displayed Players updated Successfully

Scenario: Delete new Players
	Given Player already exist
	When Delete existing player
	Then Message displayed Players deleted Successfully
	
Scenario: Reset existing board
	Given Board already created
	When Reset existing board
	Then Message displayed board reset Successfully

Scenario: Delete existing board
	Given Board already created
	When Delete existing board
	Then Message displayed board deleted Successfully
	But Invalid boardid
	Then Message displayed board donot exist

Scenario: Reset existing board
	Given Board already created
	When Reset existing board
	Then Message displayed board reset Successfully

Scenario: Rolldice on board
	Given Board already created
	When Delete existing board
	Then Message displayed board deleted Successfully
	But Invalid boardid
	Then Message displayed board donot exist
		
	
	