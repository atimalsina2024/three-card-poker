package com.portfolio.threecard.ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class GamePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public GamePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://localhost:8080");
	}
	
	private By dealButton = By.id("deal-button");
	private By cardZero = By.id("card-0");
	private By cardOne = By.id("card-1");
	private By cardTwo = By.id("card-2");
	private By handResult = By.id("hand-result");
	private By errorMsg = By.id("error-msg");

	@Step
	public void clickDeal() {
		wait
		.until(ExpectedConditions.elementToBeClickable(dealButton))
		.click();
	}
	@Step
	public String getCardText(int index) {
		switch (index) {
		case 0: {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(cardZero)).getText();
		}
		case 1: {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(cardOne)).getText();
		}
		case 2: {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(cardTwo)).getText();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + index);
		}
	}
	@Step
	public String getHandResults() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(handResult)).getText().replace("\"", "");
	}
	@Step
	public String getErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
	}
	@Step
	public boolean isDealButtonEnabled() {
		return wait.until(ExpectedConditions.elementToBeClickable(dealButton)).isEnabled();
	}
	@Step
	public void waitForHandResult() {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(handResult, "")));
	}
}
