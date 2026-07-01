package com.portfolio.threecard.api;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;
@Epic("Three Card Poker Game")
@Feature("Test Evaluate API Positive Scenarios")
public class EvaluateApiTest extends BaseApiTest {

	@Test
	@Story("Validate When Card is dealt, hand is evaluated")
	@Description("When 3 cards are dealt, response is HTTP200")
	public void validateSuccessResponse() {
		String hand = """
								{
				    "cards": [
				        {
				            "suit": "Spade",
				            "rank": "J"
				        },
				        {
				            "suit": "Spade",
				            "rank": "9"
				        },
				        {
				            "suit": "Clubs",
				            "rank": "K"
				        }
				    ]
				}
								""";
		given()
		.body(hand)
		.when()
		.post("/api/evaluate")
		.then()
		.statusCode(200);
	}
	
	@Test
	@Story("Validate correct result is sent")
	@Description("When 3 Aces are dealt, three of a kind is responded")
	public void validateThreeOfAKind() {
		String hand = """
								{
				    "cards": [
				        {
				            "suit": "Spade",
				            "rank": "A"
				        },
				        {
				            "suit": "Hearts",
				            "rank": "A"
				        },
				        {
				            "suit": "Clubs",
				            "rank": "A"
				        }
				    ]
				}
								""";
		given()
		.body(hand)
		.when()
		.post("/api/evaluate")
		.then()
		.body("description", equalTo("Three of a Kind"));
	}
	
	@Test
	@Story("Validate Evaluate API Response Adhers to Schema")
	@Description("Validate Evaluate API Response Adhers to Schema")
	public void validateEvaluateResponseAdhersToSchema() {
		String hand = """
								{
				    "cards": [
				        {
				            "suit": "Spade",
				            "rank": "A"
				        },
				        {
				            "suit": "Hearts",
				            "rank": "A"
				        },
				        {
				            "suit": "Clubs",
				            "rank": "A"
				        }
				    ]
				}
								""";
		given()
		.body(hand)
		.when()
		.post("/api/evaluate")
		.then()
		.body(matchesJsonSchemaInClasspath("schemas/evaluate-response-schema.json"));
	}
}
