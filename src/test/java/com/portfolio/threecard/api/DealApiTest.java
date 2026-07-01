package com.portfolio.threecard.api;


import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;




@Epic("Three Card Poker Game")
@Feature("Deal Hand API")
public class DealApiTest extends BaseApiTest{

	@Test
	@Story("Deal Request returns successful response")
	@Description("API response code is 200")
	@Severity(SeverityLevel.BLOCKER)
	public void dealReturnsHttp200() {
		
		when()
			.post("/api/deal")
		.then()
			.statusCode(200);
	}
	
	@Test
	@Story("Deal Request returns 3 cards")
	@Description("size of cards is 3")
	@Severity(SeverityLevel.BLOCKER)
	public void dealReturnsThreeCards() {
		given()
			.spec(ApiConfig.requestSpec)
		.when()
			.post("/api/deal")
		.then()
			.body("cards.size()", equalTo(3));
	}
	@Test
	@Story("Deal Request returns suit and rank")
	@Description("check valid suit")
	@Severity(SeverityLevel.BLOCKER)
	public void eachCardHasValidSuitAndRank() {
		when()
			.post("/api/deal")
		.then()
			.body("cards.suit",everyItem(not(emptyOrNullString())))
			.body("cards.suit", everyItem(isIn(List.of("Hearts", "Diamonds", "Spade", "Clubs"))));
			
	}
	
	@Test
	@Story("Deal Request returns 3 cards in consecutize deals")
	@Description("check size of card array is 3")
	@Severity(SeverityLevel.BLOCKER)
	public void consecutiveDealCallsReturnThreeCards() {
		when()
		.post("/api/deal")
		.then()
		.body("cards.size()", equalTo(3));
		when()
		.post("/api/deal")
		.then()
		.body("cards.size()", equalTo(3));
	}
	
}
