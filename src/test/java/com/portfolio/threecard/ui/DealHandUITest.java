package com.portfolio.threecard.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Three Card Poker Game")
@Feature("Deal Hand UI")
public class DealHandUITest {

	private WebDriver driver;
	private GamePage gamePage;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		gamePage = new GamePage(driver);
	}
	
	@Test(priority = 1)
	@Story("This test verifies all three cards are not empty")
	@Description("asserts card text is not empty")
	public void dealHandShowsThreeCards() {
		gamePage.clickDeal();
		Assert.assertFalse(gamePage.getCardText(0).isEmpty());
		Assert.assertFalse(gamePage.getCardText(1).isEmpty());
		Assert.assertFalse(gamePage.getCardText(2).isEmpty());
	}
	@Test
	@Story("This test verifies card has both rank and suit")
	@Description("asserts length of card text is greater than 1")
	public void eachCardHasRandAndSuit() {
		gamePage.clickDeal();
		Assert.assertTrue(gamePage.getCardText(0).length()>1);
		Assert.assertTrue(gamePage.getCardText(1).length()>1);
		Assert.assertTrue(gamePage.getCardText(2).length()>1);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
