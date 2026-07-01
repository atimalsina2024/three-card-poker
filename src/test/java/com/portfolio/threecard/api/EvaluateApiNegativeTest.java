package com.portfolio.threecard.api;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

@Epic("Three Card Poker Game")
@Feature("Evaluate Hand API malformed request body returns HTTP400")
public class EvaluateApiNegativeTest extends BaseApiTest {

	@Test
	@Story("Validate error when all cards are missing")
	@Description("JSON Body of no cards returns HTTP400")
	public void missingCardsReturns400() {
		String malformedBody = """
								{
				    "cards": []
				}
								""";
		given()
			.body(malformedBody)
		.when()
			.post("/api/evaluate")
		.then()
			.statusCode(400);
	}
	
	@Test
	@Story("Validate error when hand only has 2 cards ")
	@Description("JSON Body of 2 cards returns HTTP400")
	public void incorrectCardCountReturns400() {
		String malformedBody = """
								{
				    "cards": [
				        {
				            "suit": "Spade","rank": "J"
				        },
				        {
				            "suit": "Spade","rank": "9"
				        }
				    ]
				}
								""";
		given()
			.body(malformedBody)
		.when()
			.post("/api/evaluate")
		.then()
			.statusCode(400);
		
	}
	
	@Test
	@Story("Validate error when hand has 4 cards ")
	@Description("JSON Body of 4 cards returns HTTP400")
	public void fourCardCountReturns400() {
		String malformedBody = """
								{
				    "cards": [
				        {
				            "suit": "Spade","rank": "J"
				        },
				        {
				            "suit": "Spade","rank": "9"
				        },
				        {
				            "suit": "Clubs", "rank": "K"
				        },
				        {
				            "suit": "Diamonds", "rank": "10"
				        }
				    ]
				}
								""";
		given()
			.body(malformedBody)
		.when()
			.post("/api/evaluate")
		.then()
			.statusCode(400);
		
	}
	
	@Test
	@Story("Validate error when one of the hand's suit is Gold ")
	@Description("JSON Body with invalid suit returns HTTP400")
	public void invalidSuitReturns400() {
		String malformedBody = """
								{
				    "cards": [
				        {
				            "suit": "Spade","rank": "J"
				        },
				        {
				            "suit": "Spade","rank": "9"
				        },
				        {
				            "suit": "Clubs", "rank": "K"
				        },
				        {
				            "suit": "Gold", "rank": "10"
				        }
				    ]
				}
								""";
		given()
			.body(malformedBody)
		.when()
			.post("/api/evaluate")
		.then()
			.statusCode(400);

	}
	
	@Test
	@Story("Validate error when one of the hand's Rank is 20 ")
	@Description("JSON Body with invalid Rank returns HTTP400")
	public void invalidRankReturns400() {
		String malformedBody = """
								{
				    "cards": [
				        {
				            "suit": "Spade","rank": "J"
				        },
				        {
				            "suit": "Spade","rank": "9"
				        },
				        {
				            "suit": "Clubs", "rank": "K"
				        },
				        {
				            "suit": "Diamonds", "rank": "20"
				        }
				    ]
				}
								""";
		given()
			.body(malformedBody)
		.when()
			.post("/api/evaluate")
		.then()
			.statusCode(400);
		
	}
	
}
