package com.portfolio.threecard.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Three Card Poker Game")
@Feature("Hand Evaluation UI")
public class HandRankUiTest {
	private static final Logger logger = LoggerFactory.getLogger(HandRankUiTest.class);
	private WebDriver driver;
	private GamePage gamePage;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		gamePage = new GamePage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	@Story("This test verifies hand result is displayed or not")
	@Description("asserts hand result is not null")
	@Severity(SeverityLevel.CRITICAL)
	public void dealShowsHandRank() {				
		gamePage.clickDeal();
		String result = gamePage.getHandResults();
		Assert.assertNotNull(result);		
	}
	
	@Test
	@Story("This test verifies hand rank displayed are valid ranks as per rule of the game")
	@Description("asserts if result string is contained in list of possible hand ranks or not")
	@Severity(SeverityLevel.CRITICAL)
	public void handRankIsValidValue() {
		List<String> handResult = new ArrayList<>(Arrays.asList(
				"Flush",
				"Straight",
				"Pair",
				"High Card",
				"Three of a Kind",
				"Straight Flush"));
		gamePage.clickDeal();
		String result = gamePage.getHandResults();
		Assert.assertTrue(handResult.contains(result));
	}
	
	@Test
	@Story("This test verifies hand results are displayed in consecutive deals")
	@Description("asserts hand result is always displayed")
	@Severity(SeverityLevel.NORMAL)
	public void consecutiveDealUpdateHandRank() {
		List<String> handResults = new ArrayList<>();
		for(int i=0;i<3;i++) {
			gamePage.clickDeal();
			handResults.add(gamePage.getHandResults());
		}
		Assert.assertEquals(handResults.size(), 3);
	}
}
